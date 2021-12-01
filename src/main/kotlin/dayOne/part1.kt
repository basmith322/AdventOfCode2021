package dayOne

import java.io.File


fun main() {
    val part1 = Part1()
    part1.calcNum()
}

class Part1 {
    private val numbers = "/home/ben/uleska/AdventOfCode2021/src/main/resources/part1Data.txt"

    fun calcNum() {
        var currentNum: Int
        var lastNum: Int
        var isGreaterThanCount = 0
        val lines: List<String> = File(numbers).readLines()

        //Init lastNumber with a value for the first comparison
        lastNum = lines.first().toInt()
        lines.forEach { line ->
            currentNum = line.toInt()
            if (currentNum > lastNum) {
                isGreaterThanCount++
            }
            lastNum = currentNum
        }
        println(isGreaterThanCount)
    }
}