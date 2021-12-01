package dayOne

import java.io.File

fun main() {
    val part2 = Part2()
    part2.calcNum()
}

class Part2 {
    private val numbers = "/home/ben/uleska/AdventOfCode2021/src/main/resources/part1Data.txt"

    fun calcNum() {
        var currentNumSum: Int
        var lastNumSum: Int
        var isGreaterThanCount = 0
        var lines: List<String> = File(numbers).readLines()

        //Init lastNumberSum with a value for the first comparison
        lastNumSum = lines.map { it.toInt() }.take(3).sum()

        do {
            currentNumSum = lines.map { it.toInt() }.take(3).sum()
            if (currentNumSum > lastNumSum) {
                isGreaterThanCount++
            }
            lastNumSum = currentNumSum
            lines = lines.drop(1)
        } while (lines.isNotEmpty())

        println(isGreaterThanCount)
    }
}