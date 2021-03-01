import java.util.Arrays
import java.util.Scanner

class Stack() {
    init {
    }

    private var stack_arr = mutableListOf<Int>()

    fun push(value: Int) {
        stack_arr.add(value)
    }

    fun pull(): Int? {
        if (stack_arr.size > 0) {
            val value = stack_arr.elementAt(stack_arr.size - 1)
            stack_arr.removeAt(stack_arr.size - 1)
            return value
        } else {
            return null
        }
    }

    fun size(): Int{
        return stack_arr.size
    }
}

fun main(args: Array<String>) {
    """
    // Variables
    var language = "French"
    val score = 95
    val range: Int = 112
    println("Hello World!")
    println(language)
    println(score)
    println(range)

    // Arrays
    var myArray2 = arrayOf<Int>(1, 10, 4, 6, 15).toMutableList()
    myArray2.removeAt(0)
    val list = mutableListOf(1, 2, 3)
    println(list) // [1, 2, 3]
    list += listOf(4, 5)
    println(list) // [1, 2, 3, 4, 5]
    list.removeAt(0)
    println(list)
    """

    // Queue through two stacks:
    var stack_1: Stack = Stack()
    var stack_2: Stack = Stack()
    val reader = Scanner(System.`in`)
    while (true) {
        println("Enter push or pull:")
        val command = readLine()
        when {
            command == "push" -> {
                println("Enter value:")
                val value: Int = reader.nextInt()
                stack_2.push(value)
            }
            command == "pull" -> {
                if (stack_1.size() > 0) {
                    println(stack_1.pull())
                } else {
                    if (stack_2.size() == 0){
                        println("Queue is empty!")
                    }
                    else {
                        var temp_val = stack_2.pull()
                        while (temp_val != null) {
                            stack_1.push(temp_val)
                            temp_val = stack_2.pull()
                        }
                        println(stack_1.pull())
                        stack_2 = Stack()
                    }
                }
            }
            else -> {
                println("Wrong command!")
            }
        }
    }
}