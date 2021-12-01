package dayOne

import java.io.File

fun main() {
    val part1 = Part1()
    part1.calcNum()
}

class Part1 {
    fun calcNum(){
        var currentNum: Int
        var lastNum: Int
        var isGreaterThan = 0
        val numbers = "/home/ben/uleska/AdventOfCode2021/src/main/resources/part1Data.txt"
        val lines: List<String> = File(numbers).readLines()

        //Init lastNum
        lastNum = lines.first().toInt()
        lines.forEach { line ->
            run {
                currentNum = line.toInt()
                if (currentNum > lastNum) {
                    isGreaterThan++
                }
                lastNum = currentNum
            }
        }
        println(isGreaterThan)
    }
}