package signature

fun main() {
    printFrame("Hyper Skill")
}

fun printFrame(string: String) {
    val len = string.length
    print(" ")
    repeat(len + 2) {
        print("_")
    }
    println()
    (" ")
    println("| $string |")
    print(" ")
    repeat(len + 2) {
        print("•")
    }
    print(" ")
}
