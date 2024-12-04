package day2

import readInput
import kotlin.math.absoluteValue
import kotlin.time.measureTimedValue

fun main() {
    val input = readInput("day2/input")
    val (output, timeTaken) = measureTimedValue { day2Part1(input) }
    println("Part 1")
    println("Answer: $output")
    println("Time taken: $timeTaken")

    val (output1, timeTaken1) = measureTimedValue { day2Part2(input) }
    println("Part 2")
    println("Answer: $output1")
    println("Time taken: $timeTaken1")
}

fun day2Part2(input: List<String>): Int {
    val reports: List<List<Int>> = input.map { lint ->
        lint.split(" ")
    }.map { report ->
        report.map { level ->
            level.toInt()
        }
    }

    return reports.map { report ->
        if (
            (report.isIncreasing() || report.isDecreasing()) ||
            (report.isIncreasingDampened() || report.isDecreasingDampened())
        ) {
            1
        } else {
            0
        }
    }.sum()
}

fun List<Int>.isIncreasingDampened(): Boolean {
    var increasing = false
    for (n in 0..this.size) {
        val dampenedList = this.filterIndexed { idx, _ -> idx != n }

        if (dampenedList.isIncreasing()) {
            increasing = true
        }
    }
    return increasing
}

fun List<Int>.isDecreasingDampened(): Boolean {
    var decreasing = false
    for (n in 0..this.size) {
        val dampenedList = this.filterIndexed { idx, _ -> idx != n }

        if (dampenedList.isDecreasing()) {
            decreasing = true
        }
    }
    return decreasing
}

fun day2Part1(input: List<String>): Int {
    val reports: List<List<Int>> = input.map { lint ->
        lint.split(" ")
    }.map { report ->
        report.map { level ->
            level.toInt()
        }
    }

    return reports.map { report ->
        if (report.isIncreasing() || report.isDecreasing()) {
            1
        } else {
            0
        }
    }.sum()
}

fun List<Int>.isIncreasing(): Boolean {
    var increasing = true
    var i = 1
    while (i < this.size) {
        if (this[i] < this[i - 1]) {
            increasing = false
            break
        } else {
            val diff = (this[i] - this[i - 1]).absoluteValue
            if (diff !in 1..3) {
                increasing = false
            }
        }
        i += 1
    }
    return increasing
}

fun List<Int>.isDecreasing(): Boolean {
    var decreasing = true
    var i = 1
    while (i < this.size) {
        if (this[i] > this[i - 1]) {
            decreasing = false
            break
        } else {
            val diff = (this[i] - this[i - 1]).absoluteValue
            if (diff !in 1..3) {
                decreasing = false
            }
        }
        i += 1
    }
    return decreasing
}
