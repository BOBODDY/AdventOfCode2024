package day4

import readInput
import kotlin.time.measureTimedValue

fun day4Part1(input: List<List<Char>>): Int {
    val xmas = "XMAS"
    val samx = "SAMX"
    var count = 0
    // Look over the whole matrix for any instance of "XMAS" horizontally, diagonally, vertically, or backwards
    for (r in input.indices) {
        for (c in input[r].indices) {
            val vertical = listOf(
                r to c,
                r+1 to c,
                r+2 to c,
                r+3 to c,
            )
            if (isChristmas(input, vertical, false)) {
                //println("Found vertical $vertical at ($r,$c)")
                count += 1
            }

            val horizontal = listOf(
                r to c,
                r to c+1,
                r to c+2,
                r to c+3
            )
            if (isChristmas(input, horizontal, false)) {
                //println("Found horizontal $horizontal at ($r,$c)")
                count += 1
            }

            val verticalReverse = listOfNotNull(
                r to c,
                r-1 to c,
                r-2 to c,
                r-3 to c,
            )
            if (isChristmas(input, verticalReverse, true)) {
                //println("Found vertical reverse $verticalReverse at ($r,$c)")
                count += 1
            }

            val horizontalReverse = listOfNotNull(
                r to c,
                r to c-1,
                r to c-2,
                r to c-3
            )
            if (isChristmas(input, horizontalReverse, true)) {
                //println("Found horizontal reverse $horizontalReverse at ($r,$c)")
                count += 1
            }

            val diagNW = listOf(
                r to c,
                r-1 to c-1,
                r-2 to c-2,
                r-3 to c-3,
            )
            if (isChristmas(input, diagNW, false)) {
                //println("Found diagonal NW $diagNW at ($r,$c)")
                count += 1
            }

            val diagNE = listOf(
                r to c,
                r-1 to c+1,
                r-2 to c+2,
                r-3 to c+3,
            )
            if (isChristmas(input, diagNE, false)) {
                //println("Found diagonal NW $diagNW at ($r,$c)")
                count += 1
            }

            val diagSW = listOf(
                r to c,
                r+1 to c-1,
                r+2 to c-2,
                r+3 to c-3,
            )
            if (isChristmas(input, diagSW, false)) {
                //println("Found diagonal SW $diagNW at ($r,$c)")
                count += 1
            }

            val diagSE = listOf(
                r to c,
                r+1 to c+1,
                r+2 to c+2,
                r+3 to c+3,
            )
            if (isChristmas(input, diagSE, false)) {
                //println("Found diagonal NW $diagNW at ($r,$c)")
                count += 1
            }
        }
    }

    return count
}

fun isChristmas(
    input: List<List<Char>>,
    coords: List<Pair<Int, Int>>,
    reverse: Boolean
): Boolean {
    val word = coords.mapNotNull {
        input.getOrNull(it.first)?.getOrNull(it.second)
    }
    if (word.size != 4) {
        return false
    }
    val targetWord = if (reverse) "SAMX" else "XMAS"
    return word.joinToString("") == targetWord
}

fun main() {
    val input = readInput("day4/input").map { it.toCharArray().toList() }
    val (output, timeTaken) = measureTimedValue { day4Part1(input) }
    println("Part 1")
    println("Answer: $output")
    println("Time taken: $timeTaken")
}