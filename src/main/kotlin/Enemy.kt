


open class Enemy(var name: String, var HP: Double, var isAlive: Boolean) {

    open var weapon = mutableListOf("", "", "", "")
    open var damage = mutableListOf(0.0, 0.0, 0.0, 0.0)
    var targetList = mutableListOf(vickinger, magier, soldat)
    fun attac() {

        var target = targetList.random()
        var damageRandom = damage.random()
        var weaponRandom = weapon[damage.indexOf(damageRandom)]

    if (target.HP > 0 && this.HP > 0) {
        target.HP -= damageRandom
        println("\nDer ${this.name} hat $target mit $weaponRandom angegriffen.")
        println("Der $target hat $damageRandom Schaden erlitten.")
        println("Sein leben ist jetzt ${target.HP}.")
        if (target.HP <= 0) {
            target.isAlive = false
            targetList.remove(target)
        }
    }


}

    override fun toString(): String {
        return "$name"
    }
}


    /*fun protect() {
        println("Der ${this.name} hat sich beschützt. Sein Leben ist immer noch: ${this.HP}")
    }*/



