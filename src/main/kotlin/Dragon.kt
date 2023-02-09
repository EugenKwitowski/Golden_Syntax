class Dragon(name: String, HP: Double, isAlive: Boolean): Enemy(name, HP, isAlive) {

    override var weapon = mutableListOf("Schwanzangriff", "Flügelangriff", "Feueratem", "Fluch")
    override var damage = mutableListOf(10.0, 12.5, 15.0, 17.5)




}