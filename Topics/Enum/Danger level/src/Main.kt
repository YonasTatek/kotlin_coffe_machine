enum class DangerLevel(val levelNumber:Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);
    fun getLevel():Int = levelNumber

}