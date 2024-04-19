package com.targetindia.programs

import com.targetindia.app.MathOps

fun main() {
    val op: MathOps = MathOps();

    val list: List<Double> = op.performMaths(1.2, 3.4)

    println(list[0])
    println(list[1])
    println(list[2])
    println(list[3])
}