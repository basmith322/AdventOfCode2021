package dayThree

import java.io.File

enum class MoreOrLess {
    MORE, LESS
}

fun main() {
    val binary = "/home/ben/uleska/AdventOfCode2021/src/main/resources/day3Data.txt"
    val lines: List<String> = File(binary).readLines()
    val part3 = Day3Part1()
    val gamma = part3.calcGamma(lines)
    val epsilon = part3.calcEpsilon(lines)
    println("Gamma: $gamma | Epsilon: $epsilon")
    println("Power Consumption = " + (gamma * epsilon))
}

class Day3Part1 {
    fun calcGamma(list: List<String>): Long {

        val binaryArray = decipherBinaryFile(list, MoreOrLess.MORE)
        for (element in binaryArray) {
            numberString += element
        }
        return binaryToDecimal(numberString)
    }


    fun calcEpsilon(list: List<String>): Long {
        val binaryArray = decipherBinaryFile(list, MoreOrLess.LESS)

        for (element in binaryArray) {
            numberString += element
        }

        return binaryToDecimal(numberString)
    }

    private var numberString = ""

    private fun decipherBinaryFile(list: List<String>, moreOrLess: MoreOrLess): ArrayList<Int> {
        //Ini variables
        val binaryArray = ArrayList<Int>()
        var binaryOne = 0
        var binaryZero = 0
        var cursor = 0
        var lineLength = 0
        numberString = ""
        //Iterate through each line at the cursor position
        do {
            list.forEach { line ->
                lineLength = line.length
                if (line[cursor] == '0') {
                    binaryZero++
                } else if (line[cursor] == '1') {
                    binaryOne++
                }
            }
            //Determine if we want more or less for gamma or epsilon
            if (moreOrLess == MoreOrLess.MORE) {
                if (binaryZero > binaryOne) {
                    binaryArray.add(0)
                } else {
                    binaryArray.add(1)
                }
            } else if (moreOrLess == MoreOrLess.LESS) {
                if (binaryZero < binaryOne) {
                    binaryArray.add(0)
                } else {
                    binaryArray.add(1)
                }
            }
            //Reset cursor and counters before moving to next cursor position
            cursor++
            binaryZero = 0
            binaryOne = 0
        } while (cursor < lineLength)
        return binaryArray
    }

    private fun binaryToDecimal(number: String): Long {
        // Assuming that number contains 0,1s
        // Used to store result
        var result: Long = 0
        var bit = 0
        var n: Int = number.length - 1
        // Display Binary number
        print("Binary: $number")
        // Execute given number in reverse order
        while (n >= 0) {
            if (number[n] == '1') {
                // When get binary 1
                result += (1 shl (bit))
            }
            n -= 1
            // Count number of bits
            bit += 1
        }
        // Display decimal result
        println(" | Decimal: $result")

        return result
    }
}