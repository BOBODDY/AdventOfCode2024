package day3

import readInput
import kotlin.time.measureTimedValue

fun main() {
    val input = readInput("day3/input_test").joinToString("")
    val (output, timeTaken) = measureTimedValue { day3Part1(input) }
    println("Part 1: $output")
    println("Part 2: $timeTaken")
}

fun day3Part1(input: String): Int {
    val regex = Regex(pattern = ".*(mul\\(\\d+,\\d+\\)).*")
    val matches = regex.findAll(input)
    return matches.map {
        getNumbers(it.value)
    }.sumOf {
        it.first * it.second
    }
}

fun getNumbers(input: String): Pair<Int, Int> {
    val regex = Regex(pattern = "mul\\((\\d+),(\\d+)\\)")
    val matches = regex.findAll(input).toList()
    return matches[0].value.toInt() to matches[1].value.toInt()
}