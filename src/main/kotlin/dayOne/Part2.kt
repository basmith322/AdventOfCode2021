package dayOne

import java.io.File

fun main() {
    val part2 = Part2()
    part2.calcNum()
}

class Part2 {
    fun calcNum() {
        var currentNumSum: Int
        var lastNumSum: Int
        var isGreaterThan = 0
        val numbers = "/home/ben/uleska/AdventOfCode2021/src/main/resources/part1Data.txt"
        var lines: List<String> = File(numbers).readLines()
        lastNumSum = lines.map { it.toInt() }.take(3).sum()

        do {
            currentNumSum = lines.map { it.toInt() }.take(3).sum()
            if (currentNumSum > lastNumSum) {
                isGreaterThan++
            }
            lastNumSum = currentNumSum
            lines = lines.drop(1)
        } while (lines.isNotEmpty())

        println(isGreaterThan)
    }
}