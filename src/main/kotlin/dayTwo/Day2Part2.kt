package dayTwo

import java.io.File

fun main() {
    val part2 = Day2Part2()
    part2.calcDepth()
}

class Day2Part2 {
    private val directions = "/home/ben/uleska/AdventOfCode2021/src/main/resources/day2Data.txt"

    fun calcDepth() {
        var horizontalPos = 0
        var depth = 0
        var aim = 0
        var currentDirection: String
        var valueFromDirection: Int

        val lines: List<String> = File(directions).readLines()

        lines.forEach { line ->
            currentDirection = line.filter { it.isLetter() }
            valueFromDirection = line.filter { it.isDigit() }.toInt()
            when (currentDirection) {
                "forward" -> {
                    horizontalPos += valueFromDirection
                    depth += (aim * valueFromDirection)
                }
                "down" -> {
                    aim += valueFromDirection
                }
                "up" -> {
                    aim -= valueFromDirection
                }
            }
        }
        val totalPos: Int = (horizontalPos * depth)
        println(horizontalPos)
        println(depth)
        println(totalPos)
    }
}