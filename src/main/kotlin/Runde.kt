class Runde {
    fun round() {

        do {
            if (vickinger.isAlive && (dragon.HP > 0 || skeleton.HP > 0)) {
                 vickinger.attac()
             }
             if (magier.isAlive && (dragon.HP > 0 || skeleton.HP > 0)) {
                 magier.attac()
             }
             if (soldat.isAlive && (dragon.HP > 0 || skeleton.HP > 0)) {
                 soldat.attac()
             }
             if (dragon.isAlive && (vickinger.HP > 0 || magier.HP > 0 || soldat.HP > 0)) {
                 dragon.attac()
             }
             if (skeleton.isAlive && (vickinger.HP > 0 || magier.HP > 0 || soldat.HP > 0)) {
                 skeleton.attac()
             }
        } while (!gameOver())

    }


    fun gameOver(): Boolean {
        if ((!vickinger.isAlive && !magier.isAlive && !soldat.isAlive) || (!dragon.isAlive && !skeleton.isAlive)) {
            return true
        }
        return false
    }


}





