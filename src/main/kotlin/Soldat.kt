class Soldat(name: String, HP: Double, isAlive: Boolean): Hero(name, HP, isAlive) {

    override var weapon = mutableListOf("Shotgun", "Bazooka")
    override var damage = mutableListOf(15.0, 17.5)
}