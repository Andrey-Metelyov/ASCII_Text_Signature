package signature

//class Alphabet {
//    companion object {
//        private val a = arrayOf(
//            "____",
//            "|__|",
//            "|  |"
//        )
//        private val b = arrayOf(
//            "___",
//            "|__]",
//            "|__]"
//        )
//        private val c = arrayOf(
//            "____",
//            "|   ",
//            "|___"
//        )
//        private val d = arrayOf(
//            "___ ",
//            "|  \\",
//            "|__/"
//        )
//        private val e = arrayOf(
//            "____",
//            "|---",
//            "|___"
//        )
//        private val f = arrayOf(
//            "____",
//            "|---",
//            "|   "
//        )
//        private val g = arrayOf(
//            "____",
//            "| __",
//            "|__]"
//        )
//        private val h = arrayOf(
//            "_  _",
//            "|  |",
//            "|  |"
//        )
//        private val i = arrayOf(
//            "_",
//            "|",
//            "|"
//        )
//        private val j = arrayOf(
//            " _",
//            " |",
//            "_|"
//        )
//        private val k = arrayOf(
//            "_  _",
//            "|_/ ",
//            "| \\_"
//        )
//        private val l = arrayOf(
//            "_   ",
//            "|   ",
//            "|___"
//        )
//        private val m = arrayOf(
//            "_  _",
//            "|\\/|",
//            "|  |"
//        )
//        private val n = arrayOf(
//            "_  _",
//            "|\\ |",
//            "| \\|"
//        )
//        private val o = arrayOf(
//            "____",
//            "|  |",
//            "|__|"
//        )
//        private val p = arrayOf(
//            "___",
//            "|__]",
//            "|   "
//        )
//        private val q = arrayOf(
//            "____",
//            "|  |",
//            "|_\\|"
//        )
//        private val r = arrayOf(
//            "____",
//            "|__/",
//            "|  \\"
//        )
//        private val s = arrayOf(
//            "____",
//            "[__ ",
//            "___]"
//        )
//        private val t = arrayOf(
//            "___",
//            " | ",
//            " | "
//        )
//        private val u = arrayOf(
//            "_  _",
//            "|  |",
//            "|__|"
//        )
//        private val v = arrayOf(
//            "_  _",
//            "|  |",
//            " \\/ "
//        )
//        private val w = arrayOf(
//            "_ _ _",
//            "| | |",
//            "|_|_|"
//        )
//        private val x = arrayOf(
//            "_  _",
//            " \\/",
//            "_/ \\_"
//        )
//        private val y = arrayOf(
//            "_   _",
//            " \\_/ ",
//            "  |  "
//        )
//        private val z = arrayOf(
//            "___ ",
//            "  / ",
//            " /__"
//        )
//        private val space = arrayOf(
//            "    ",
//            "    ",
//            "    "
//        )
//        private val letters = mapOf(
//            ' ' to space,
//            'a' to a,
//            'b' to b,
//            'c' to c,
//            'd' to d,
//            'e' to e,
//            'f' to f,
//            'g' to g,
//            'h' to h,
//            'i' to i,
//            'j' to j,
//            'k' to k,
//            'l' to l,
//            'm' to m,
//            'n' to n,
//            'o' to o,
//            'p' to p,
//            'q' to q,
//            'r' to r,
//            's' to s,
//            't' to t,
//            'u' to u,
//            'v' to v,
//            'w' to w,
//            'x' to x,
//            'y' to y,
//            'z' to z
//        )
//        fun get(letter: Char): Array<String> {
//            return letters[letter] ?: throw IllegalArgumentException("Unknown letter: $letter")
//        }
//
//        fun getWidth(letter: Char): Int {
//            return get(letter)[0].length
//        }
//        fun getHeight(letter: Char): Int {
//            return get(letter).size
//        }
//    }
//}

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!.lowercase()
    print("Enter person's status: ")
    val status = readLine()!!
    printFrame(name, status)
}

fun printFrame(name: String, status: String) {
    var lenName = name.length - 1
    val lenStatus = status.length
    val symbolHeight = Alphabet.getHeight(name[0])
    val lines = mutableListOf<MutableList<String>>()
    for (i in 1..symbolHeight) {
        lines.add(mutableListOf())
    }
    for (c in name) {
        lenName += Alphabet.getWidth(c)
        for (i in 0 until symbolHeight) {
            lines[i].add(Alphabet.get(c)[i])
        }
    }

    val lenTotal = if (lenName < lenStatus) lenStatus else lenName

    repeat(lenTotal + 3 * 2) {
        print("*")
    }
    println()

    for (i in 0 until symbolHeight) {
        var line = ""
        for (el in lines[i]) {
            line += "$el "
        }
        print("*  ")
        repeat((lenTotal - lenName) / 2) {
            print(" ")
        }
        print(line)
        repeat(lenTotal - (lenTotal - lenName) / 2 - lenName) {
            print(" ")
        }
        println(" *")
    }
    print("*  ")
    repeat((lenName - lenStatus) / 2) {
        print(" ")
    }
    print(status)
    repeat(lenName - (lenName - lenStatus) / 2 - lenStatus) {
        print(" ")
    }
    println("  *")
    repeat(lenTotal + 3 * 2) {
        print("*")
    }
    println()
//    System.err.println("len = $lenName")
//    System.err.println("status.len = ${lenStatus}")
}

