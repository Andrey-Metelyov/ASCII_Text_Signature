package signature

import java.io.File

class Alphabet(filename: String, private val spaceSize: Int) {
    class Letter(val arr: Array<String>, val width: Int) {
        val height: Int = arr.size
        override fun toString(): String {
            return "Letter(arr=${arr.contentToString()}, height=$height, width=$width)"
        }
    }

    private val letters = mutableMapOf<Char, Letter>()
    var height = 0

    init {
        load(filename)
    }

    fun lines(line: String): MutableList<MutableList<String>> {
        val res = mutableListOf<MutableList<String>>()
//        for (i in 1..height) {
//            res.add(mutableListOf())
//        }
        for (i in 0 until height) {
            res.add(mutableListOf(letters[line[0]]!!.arr[i]))
//            System.err.println(res[i])
        }
        for (i in 0 until height) {
            for (j in 1..line.lastIndex) {
                res[i].add((letters[line[j]]!!.arr[i]))
//                System.err.println(res[i])
            }
        }
        return res
    }

    fun get(letter: Char): Letter {
        return letters[letter] ?: throw IllegalArgumentException("Unknown letter: $letter")
    }

    fun length(line: String): Int {
        var res = 0
        for (c in line) {
            res += if (c == ' ') {
                spaceSize
            } else {
                letters[c]!!.width
            }
        }
        return res
    }

    private fun load(filename: String) {
        val file = File(filename)
        val lines = file.readLines()
        val (height, count) = lines[0].split(" ").map { it.toInt() }
        this.height = height
//        System.err.println("$height, $count")
        for (i in 0 until count) {
            val currentLine = 1 + i * (1 + height)
            val (ch, width) = lines[currentLine].split(" ")
//            System.err.println("$i - ${1 + i * (1 + height)}: $ch - $height x $width")
            val arr = Array(height) { "" }
            for (j in 0 until height) {
                arr[j] = lines[currentLine + j + 1]
//                System.err.println(arr[j])
            }
            val letter = Letter(arr, width.toInt())
//            System.err.println(letter)
            letters[ch[0]] = letter
        }
        letters[' '] = Letter(Array(height) { " ".repeat(spaceSize) }, spaceSize)
    }
}
