enum class DaysOfTheWeek(val day: String) {
    // write here
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),

    FRIDAY("Friday"),
    SATURDAY("Saturday")
}

fun main() {
    // write here
    for (i in DaysOfTheWeek.values()) {
        println(i.name)
    }
}
