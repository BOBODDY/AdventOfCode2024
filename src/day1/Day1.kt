package day1

import readInput
import kotlin.math.absoluteValue
import kotlin.time.measureTimedValue

fun processInput(input: List<String>): Pair<List<Int>, List<Int>> {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    input.map {
        it.split("   ")
    }.forEach {
        left.add(it[0].toInt())
        right.add(it[1].toInt())
    }

    return left to right
}

fun day1Part1(input: List<String>): Int {
    val (left, right) = processInput(input)

    val sortedLeft = left.sorted()
    val sortedRight = right.sorted()

    return sortedLeft.zip(sortedRight).sumOf {
        (it.first - it.second).absoluteValue
    }
}

fun day1Part2(input: List<String>): Int {
    val (left, right) = processInput(input)

    val similarity = left.map { l ->
        val count = right.count { it == l }
        l to count
    }.sumOf {
        it.first * it.second
    }
    return similarity
}

fun main(args: Array<String>) {
    val input = readInput("day1/day1")
    val (output, timeTaken) = measureTimedValue { day1Part1(input) }
    println("Part 1")
    println("Answer: $output")
    println("Time taken: $timeTaken")

    val (output1, timeTaken1) = measureTimedValue { day1Part2(input) }
    println("Part 2")
    println("Answer: $output1")
    println("Time taken: $timeTaken1")
}