package dayTwo

import java.io.File

fun main() {
    val part1 = Day2Part1()
    part1.calcDepth()
}

class Day2Part1 {
    private val directions = "/home/ben/uleska/AdventOfCode2021/src/main/resources/day2Data.txt"

    fun calcDepth() {
        var horizontalPos = 0
        var depth = 0
        var currentDirection: String
        var valueFromDirection: Int

        val lines: List<String> = File(directions).readLines()

        lines.forEach { line ->
            currentDirection = line.filter { it.isLetter() }
            valueFromDirection = line.filter { it.isDigit() }.toInt()
            when (currentDirection) {
                "forward" -> horizontalPos += valueFromDirection
                "down" -> depth += valueFromDirection
                "up" -> depth -= valueFromDirection
            }
        }
        val totalPos: Int = (horizontalPos * depth)
        println(horizontalPos)
        println(depth)
        println(totalPos)
    }

}