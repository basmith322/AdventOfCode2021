package dayOne

import java.io.File

fun main() {
    val aocDay1 = AOCDay1()
    aocDay1.calcNum()
}

class AOCDay1 {
    fun calcNum(){
        var currentNum: Int
        var lastNum: Int
        var isGreaterThan = 0
        val numbers = "/home/ben/uleska/AdventOfCode2021/src/main/resources/AOCDay1Data.txt"
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