package signature

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val status = readLine()!!
    printFrame(name, status)
//    printFrame("Ian One", "VIP")
}

fun printFrame(name: String, status: String) {
    val roman = Alphabet("c:/temp/roman.txt", 10)
    val medium = Alphabet("c:/temp/medium.txt", 6)
//    val symbolHeight = roman.height

    val lenStatus = medium.length(status)
    val lenName = roman.length(name)
    System.err.println("lenStatus=$lenStatus, lenName=$lenName")
    val romanLines = roman.lines(name)
    val mediumLines = medium.lines(status)

    val lenTotal = if (lenName < lenStatus) lenStatus else lenName
    val borderSize = 2 + (lenTotal + lenTotal % 2) / 2 + 1
    System.err.println("lenTotal=$lenTotal")
    System.err.println("$lenTotal / 2 + $lenTotal % 2 + 3 * 2 = ${lenTotal / 2 + lenTotal % 2 + 3 * 2}")
    System.err.println("borderSize=$borderSize")

//    repeat(lenTotal / 2 + lenTotal % 2 + 3 * 2) {
    // upper border
    repeat(borderSize) {
        print("88")
    }
    println()

    for (i in 0 until roman.height) {
        var line = ""
        for (el in romanLines[i]) {
            line += "$el"
        }
        print("88  ")
        repeat((lenTotal - lenName) / 2) {
            print(" ")
        }
        print(line)
        repeat(lenTotal - (lenTotal - lenName) / 2 - lenName) {
            print(" ")
        }
        println(" 88")
    }

//    print("88  ")
//    repeat((lenName - lenStatus) / 2) {
//        print(".")
//    }

    for (i in 0 until medium.height) {
        var line = ""
        for (el in mediumLines[i]) {
            line += "$el"
        }
        print("88  ")
        repeat((lenTotal - lenStatus) / 2) { print(" ") }

        print(line)

        repeat(borderSize * 2 - 6 - (lenTotal - lenStatus) / 2 - lenStatus - 1) { print(" ") }
        println(" 88")
    }

    // lower border
    repeat(borderSize) {
        print("88")
    }
    println()
}
