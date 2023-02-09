class Skeleton(name: String, HP: Double, isAlive: Boolean): Enemy(name, HP, isAlive) {
    var isCalledToHelp: Boolean = true

    constructor(name: String, HP: Double, isAlive: Boolean, isCalledToHelp: Boolean): this(name, HP, isAlive) {
        this.isCalledToHelp = isCalledToHelp
    }
    override var weapon = mutableListOf("Knochenschlag", "Knochenwurf")
    override var damage = mutableListOf(5.0, 7.5)
}



