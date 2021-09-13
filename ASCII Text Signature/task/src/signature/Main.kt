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
    val medium = Alphabet("c:/temp/medium.txt", 5)
//    val symbolHeight = roman.height

    val lenStatus = medium.length(status)
    val lenName = roman.length(name)
    System.err.println("lenStatus=$lenStatus, lenName=$lenName")
    val romanLines = roman.lines(name)
    val mediumLines = medium.lines(status)

    val lenTotal = if (lenName < lenStatus) lenStatus else lenName
    val borderSize = 2 + 2 + lenTotal + 2 + 2
    System.err.println("lenTotal=$lenTotal")
    System.err.println("$lenTotal / 2 + $lenTotal % 2 + 3 * 2 = ${lenTotal / 2 + lenTotal % 2 + 3 * 2}")
    System.err.println("borderSize=$borderSize")

    // upper border
    repeat(borderSize) { print("8") }
    println()

    var spacesLeft = (lenTotal - lenName) / 2
    var spacesRight = lenTotal - spacesLeft - lenName

    for (i in 0 until roman.height) {
        var line = ""
        for (el in romanLines[i]) {
            line += el
        }
        print("88  ")
        repeat(spacesLeft) { print(" ") }

        print(line)

        repeat(spacesRight) { print(" ") }
        println("  88")
    }

    spacesLeft = (lenTotal - lenStatus) / 2
    spacesRight = lenTotal - spacesLeft - lenStatus

    for (i in 0 until medium.height) {
        var line = ""
        for (el in mediumLines[i]) {
            line += el
        }
        print("88  ")
        repeat(spacesLeft) { print(" ") }

        print(line)

        repeat(spacesRight) { print(" ") }
        println("  88")
    }

    // lower border
    repeat(borderSize) { print("8") }
    println()
}
