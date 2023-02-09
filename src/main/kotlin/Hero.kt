open class Hero(var name: String, var HP: Double, var isAlive: Boolean) {
    var maxHP = this.HP
    open var weapon = mutableListOf("", "")
    open var damage = mutableListOf(0.0, 0.0)

    var enemyList = mutableListOf(dragon, skeleton)

    fun enemyChoise(): Int {

        if (skeleton.HP > 0 && dragon.HP > 0) {
            println("\nWähle deinen Gegner den du attackieren willst.")
            println("1 = Dragon")
            println("2 = Skeleton")

        } else if (skeleton.HP <= 0 && dragon.HP > 0) {
            println("Du greifst jetzt Dragon an.")

        } else if (dragon.HP <= 0 && skeleton.HP > 0) {
            println("Du greifst jetzt Skeleton an.")
        }

        var target = 0
        do {
            try {

                target = readln().toInt()

            } catch (e: Exception) {
                println("Gebe bitte gültige Zahlen ein.")
            }
            if (target == 1 && dragon.HP > 0) {
                println("Du willst $dragon angreifen.")
            } else if (target == 1 && dragon.HP <= 0 && skeleton.HP > 0) {
                target = 2

            } else if (target == 2 && skeleton.HP > 0) {
                println("Du willst $skeleton angreifen.")
            } else if (target == 2 && skeleton.HP <= 0 && dragon.HP > 0) {
                target = 1

            } else {
                println("Keine gültige Eingabe. Bitte versuche es noch einmal.")
            }
        } while (target != 1 && target != 2)
        return target
    }


    fun attac() {
        var choise = enemyChoise()
        println("Wähle eine Waffe aus.")
        println("1 = ${this.weapon[0]}")
        println("2 = ${this.weapon[1]}")


        var weaponChoise = 0
        do {
            try {

                weaponChoise = readln().toInt()

            } catch (e: Exception) {
                println("Gebe bitte gültige Zahlen ein.")
            }
            if (weaponChoise == 1 && choise == 1 && dragon.HP > 0) {
                println("Du hast dich für ${this.weapon[0]} entschieden.")
                dragon.HP -= damage[0]
                println("Der ${dragon.name} hat ${this.damage[0]} Schaden erlitten.")
                println(" Sein leben ist jetzt: ${dragon.HP}")
                if (dragon.HP <= 0) {
                    dragon.isAlive = false
                    enemyList.remove(dragon)
                }


            } else if (weaponChoise == 2 && choise == 1 && dragon.HP > 0) {
                println("Du hast dich für ${this.weapon[1]} entschieden.")
                dragon.HP -= damage[1]
                println("Der ${dragon.name} hat ${this.damage[1]} Schaden erlitten.")
                println(" Sein leben ist jetzt: ${dragon.HP}")
                if (dragon.HP <= 0) {
                    dragon.isAlive = false
                    enemyList.remove(dragon)
                }


            } else if (weaponChoise == 1 && choise == 2 && skeleton.HP > 0) {
                println("Du hast dich für ${this.weapon[0]} entschieden.")
                skeleton.HP -= damage[0]
                println("Der ${skeleton.name} hat ${this.damage[0]} Schaden erlitten.")
                println(" Sein leben ist jetzt: ${skeleton.HP}")
                if (skeleton.HP <= 0) {
                    skeleton.isAlive = false
                    enemyList.remove(skeleton)
                }


            } else if (weaponChoise == 2 && choise == 2 && skeleton.HP > 0) {
                println("Du hast dich für ${this.weapon[1]} entschieden.")
                skeleton.HP -= damage[1]
                println("Der ${skeleton.name} hat ${this.damage[1]} Schaden erlitten.")
                println(" Sein leben ist jetzt: ${skeleton.HP}")
                if (skeleton.HP <= 0) {
                    skeleton.isAlive = false
                    enemyList.remove(skeleton)
                }
            } else {
                println("Keine gültige Eingabe. Bitte versuche es noch einmal.")
            }
        } while (weaponChoise != 1 && weaponChoise != 2)

    }


    fun takeItemFromBag(hero: Hero) {
        println("Triff deine Entscheidung.")
        println("1 = Heiltrank \n 2 = Waffen um 10% Schaden erhöhen.")
        var choisedItem = 0
        try {
            choisedItem = readln().toInt()
        } catch (e: Exception) {
            println("Gebe bitte gültige Zahlen ein.")
        }
        if (choisedItem == 1 && bag.isNotEmpty && this.HP <= this.maxHP / 2) {
            println("Du hast ${bag.items[0]} gewählt.")
            this.HP += (this.HP * bag.itemPoints[0])
            println("Dein Leben ist jetzt auf ${this.HP} gestiegen.")
            bag.items.removeAt(0)
            bag.itemPoints.removeAt(0)
            if (bag.items.isEmpty() && bag.itemPoints.isEmpty()) {
                bag.isNotEmpty = false
            }
        } else if (choisedItem == 2 && bag.isNotEmpty) {
            println("Du hast ${bag.items.lastIndexOf("Vitamin")} gewählt.")
            this.damage += (this.damage[0] * bag.itemPoints.lastIndexOf(0.1))
            this.damage += (this.damage[1] * bag.itemPoints.lastIndexOf(0.1))
            println("Deine Waffen sind jetzt auf ${this.damage} Schaden erhöht.")
            bag.items.removeAt(bag.items.size - 1)
            bag.itemPoints.removeAt(bag.itemPoints.size - 1)
            if (bag.items.isEmpty() && bag.itemPoints.isEmpty()) {
                bag.isNotEmpty = false
            }
        }
    }


    override fun toString(): String {
        return "$name"
    }
}


