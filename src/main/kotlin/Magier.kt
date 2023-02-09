class Magier(name: String, HP: Double, isAlive: Boolean): Hero(name, HP, isAlive) {

    override var weapon = mutableListOf("Zauberspruch", "Zauberpulver")
    override var damage = mutableListOf(10.0, 12.5)
}