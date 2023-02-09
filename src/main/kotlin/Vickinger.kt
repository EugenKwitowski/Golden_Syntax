class Vickinger(name: String, HP: Double, isAlive: Boolean): Hero(name, HP, isAlive) {

    override var weapon = mutableListOf("Schwert", "Axt")
    override var damage = mutableListOf(5.0, 7.5)
}