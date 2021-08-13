package signature

class Alphabet {
    companion object {
        private val a = arrayOf(
            "____",
            "|__|",
            "|  |"
        )
        private val b = arrayOf(
            "___ ",
            "|__]",
            "|__]"
        )
        private val c = arrayOf(
            "____",
            "|   ",
            "|___"
        )
        private val d = arrayOf(
            "___ ",
            "|  \\",
            "|__/"
        )
        private val e = arrayOf(
            "____",
            "|___",
            "|___"
        )
        private val f = arrayOf(
            "____",
            "|---",
            "|   "
        )
        private val g = arrayOf(
            "____",
            "| __",
            "|__]"
        )
        private val h = arrayOf(
            "_  _",
            "|__|",
            "|  |"
        )
        private val i = arrayOf(
            "_",
            "|",
            "|"
        )
        private val j = arrayOf(
            " _",
            " |",
            "_|"
        )
        private val k = arrayOf(
            "_  _",
            "|_/ ",
            "| \\_"
        )
        private val l = arrayOf(
            "_   ",
            "|   ",
            "|___"
        )
        private val m = arrayOf(
            "_  _",
            "|\\/|",
            "|  |"
        )
        private val n = arrayOf(
            "_  _",
            "|\\ |",
            "| \\|"
        )
        private val o = arrayOf(
            "____",
            "|  |",
            "|__|"
        )
        private val p = arrayOf(
            "___",
            "|__]",
            "|   "
        )
        private val q = arrayOf(
            "____",
            "|  |",
            "|_\\|"
        )
        private val r = arrayOf(
            "____",
            "|__/",
            "|  \\"
        )
        private val s = arrayOf(
            "____",
            "[__ ",
            "___]"
        )
        private val t = arrayOf(
            "___",
            " | ",
            " | "
        )
        private val u = arrayOf(
            "_  _",
            "|  |",
            "|__|"
        )
        private val v = arrayOf(
            "_  _",
            "|  |",
            " \\/ "
        )
        private val w = arrayOf(
            "_ _ _",
            "| | |",
            "|_|_|"
        )
        private val x = arrayOf(
            "_  _",
            " \\/",
            "_/ \\_"
        )
        private val y = arrayOf(
            "_   _",
            " \\_/ ",
            "  |  "
        )
        private val z = arrayOf(
            "___ ",
            "  / ",
            " /__"
        )
        private val space = arrayOf(
            "    ",
            "    ",
            "    "
        )
        private val letters = mapOf(
            ' ' to space,
            'a' to a,
            'b' to b,
            'c' to c,
            'd' to d,
            'e' to e,
            'f' to f,
            'g' to g,
            'h' to h,
            'i' to i,
            'j' to j,
            'k' to k,
            'l' to l,
            'm' to m,
            'n' to n,
            'o' to o,
            'p' to p,
            'q' to q,
            'r' to r,
            's' to s,
            't' to t,
            'u' to u,
            'v' to v,
            'w' to w,
            'x' to x,
            'y' to y,
            'z' to z
        )
        fun get(letter: Char): Array<String> {
            return letters[letter] ?: throw IllegalArgumentException("Unknown letter: $letter")
        }

        fun getWidth(letter: Char): Int {
            return get(letter)[0].length
        }
        fun getHeight(letter: Char): Int {
            return get(letter).size
        }
    }
}
