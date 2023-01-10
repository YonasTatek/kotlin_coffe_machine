package machine

enum class Coffee(val water: Int, val milk: Int, val bean: Int, val money: Int){
    ESPRESSO(250,0,16,4),
    LATTE(350,75,20,7),
    CAPPUCCINO(200,100,12,6)
}
class CoffeeMachine(var water: Int = 400,
                    var milk: Int = 540,
                    var bean: Int = 120,
                    var cup: Int = 9,
                    var money:Int = 550) {
    val info: String
    get()="""
        The coffee machine has:
        ${water} ml of water
        ${milk} ml of milk
        ${bean} g of coffee beans
        ${cup} disposable cups
        $${money} of money
    """.trimIndent()

    fun fill(water: Int,
             milk: Int,
             bean: Int,
             cup: Int) {
        this.water += water
        this.milk += milk
        this.bean += bean
        this.cup += cup
    }

    fun takeMoney():Int{
        val money = this.money
        this.money = 0
        return money
    }
    fun buy(coffee: Coffee):String {
       val less = when{
           coffee.milk > this.milk -> "milk"
           coffee.water > this.water -> "water"
           coffee.bean > this.bean -> "bean"
           this.cup <= 0 -> "cup"
           else -> {
               this.milk -= coffee.milk
               this.water -= coffee.water
               this.bean -= coffee.bean
               this.cup -= 1
               this.money += coffee.money
               ""
           }

       }
       if(less.length>0){
           return "Sorry, not enough ${less}!"
       }

        return "I have enough resources, making you a coffee!"
    }

}

fun main() {

    val coffee = CoffeeMachine()
    while(true){
        println("Write action (buy, fill, take, remaining, exit):")
        val input = readln()
        when(input){
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                val input = readln()
                when(input){
                    "1"-> println(coffee.buy(Coffee.ESPRESSO))
                    "2"-> println(coffee.buy(Coffee.LATTE))
                    "3"-> println(coffee.buy(Coffee.CAPPUCCINO))
                    "back" -> {}
                    else -> {}
                }




            }
            "fill" -> {
                println("Write how many ml of water you want to add:")
                val water = readln().toInt()
                println("Write how many ml of milk you want to add:")
                val milk = readln().toInt()
                println("Write how many grams of coffee beans you want to add:")
                val bean = readln().toInt()
                println("Write how many disposable cups you want to add:")
                val cup = readln().toInt()
                coffee.fill(water,milk,bean,cup)

            }
            "take" -> {coffee.takeMoney()}
            "remaining" -> {
                println(coffee.info)
            }
            "exit" -> {break}
            else -> {}
        }

    }

}
