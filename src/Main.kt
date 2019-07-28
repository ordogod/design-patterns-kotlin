import strategy.Strategy
import java.lang.Exception

fun main(args: Array<String>) {
    while (true) {
        printMenu()
        toggleMenu(getInput())
    }
}

fun printMenu() {
    println("" +
            "1. Strategy\n" +
            "2. Observer\n" +
            "==============================" +
            "")
}

fun getInput(): Int {
    var input: Int
    while (true) {
        println("Select pattern to demonstrate:")
        try {
            input = readLine()!!.toInt()
        } catch (e: Exception) {
            println("Invalid input. Try again.")
            continue
        }
        return input
    }
}

fun toggleMenu(input: Int) {
    println("==============================")
    when(input) {
        1 -> strategy()
        2 -> observer()
    }
    println("==============================")
}


fun strategy() {
    val commonQuackBehavior = object : Strategy.QuackBehavior {
        override fun quack(): String = "\'Quack!\'"
    }
    val rubberQuackBehavior = object : Strategy.QuackBehavior {
        override fun quack(): String = "\'Squeeeeek\'"
    }
    val silentQuackBehavior = object : Strategy.QuackBehavior {
        override fun quack(): String = "\'...\'"
    }

    val mallardDuck = Strategy.Duck(commonQuackBehavior)
    val rubberDuck = Strategy.Duck(rubberQuackBehavior)

    val toyDuck = Strategy.Duck(silentQuackBehavior)
    val decoyDuck = Strategy.Duck(commonQuackBehavior)

    println("Mallard duck says ${mallardDuck.performQuack()}.")
            println("Rubber duck says ${rubberDuck.performQuack()} when it is squeezed.")
    println("Toy duck says ${toyDuck.performQuack()}. Seems like it is primitive toy.")
    println("Decoy duck says ${decoyDuck.performQuack()}, hunter is here.")

    toyDuck.setQuackBehavior(commonQuackBehavior)
    rubberDuck.setQuackBehavior(silentQuackBehavior)

    println("Toy duck now says ${toyDuck.performQuack()} like a real one!")
    println("Rubber duck says ${rubberDuck.performQuack()}. Looks like it is broken.")
}

fun observer() {

}