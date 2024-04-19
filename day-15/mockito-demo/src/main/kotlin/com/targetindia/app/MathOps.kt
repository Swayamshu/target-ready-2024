package com.targetindia.app

import com.targetindia.service.ICalculatorService

class MathOps {
    private lateinit var calculatorService: ICalculatorService;

    constructor() {
    }

    constructor(calculatorService: ICalculatorService) {
        this.calculatorService = calculatorService;
    }

    public fun setCalculatorService(calculatorService: ICalculatorService) {
        println("setCalculatorService is triggered ...")
        println("Got an object for type ICalculatorService as " + calculatorService.javaClass.name)
        this.calculatorService = calculatorService;
    }

    /**
     * This method is supposed to calculate the sum, difference, product and dividend of 'first' and 'second'
     * numbers passed as arguments, in the form of a List<Double>
     * @param first
     * @param second
     * @return a list of 4 values (sum, difference, product, dividend)
     */
    public fun performMaths(first: Double, second: Double): List<Double> {
        val list: MutableList<Double> = mutableListOf<Double>()
        var x = calculatorService.add(first, second)
        list.add(x * x)
        x = calculatorService.subtract(first, second)
        list.add(x * x)
        x = calculatorService.multiply(first, second)
        list.add(x * x)
        x = calculatorService.divide(first, second)
        list.add(x * x)
        return list;
    }
}