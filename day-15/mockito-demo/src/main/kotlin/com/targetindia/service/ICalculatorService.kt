package com.targetindia.service

interface ICalculatorService {
    fun add(first: Double, second: Double): Double;
    fun subtract(first: Double, second: Double): Double;
    fun multiply(first: Double, second: Double): Double;
    fun divide(first: Double, second: Double): Double;
}