package com.targetindia.tests

import com.targetindia.app.MathOps
import com.targetindia.service.ICalculatorService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MathOpsPerformMathsTests {

    @Mock // mockito creates dummy object i.e. a mock
    lateinit var calculatorService: ICalculatorService

    @InjectMocks // mockito injects the above variable into this object via setter
    var ops: MathOps = MathOps();

    // @BeforeEach // fetches this mock object for each test case
    fun setup() {
        Mockito.`when`(calculatorService.add(10.0, 5.0)).thenReturn(15.0);
        Mockito.`when`(calculatorService.subtract(10.0, 5.0)).thenReturn(5.0);
        Mockito.`when`(calculatorService.multiply(10.0, 5.0)).thenReturn(50.0);
        Mockito.`when`(calculatorService.divide(10.0, 5.0)).thenReturn(2.0);
    }

    // @Test
    fun shouldPerformMaths() {
        val list = ops.performMaths(10.0, 5.0)

        Assertions.assertEquals(225.0, list[0])
        Assertions.assertEquals(25.0, list[1])
        Assertions.assertEquals(2500.0, list[2])
        Assertions.assertEquals(4.0, list[3])
    }

    @ParameterizedTest
    @CsvFileSource(files = ["input-source1.csv"])
    fun shouldPerformMathOpsOnMultipleInputs(
        input1: Double, input2:Double,
        return1: Double, return2: Double, return3: Double, return4: Double,
        expected1: Double, expected2: Double, expected3: Double, expected4: Double
    ) {
        Mockito.`when`(calculatorService.add(input1, input2)).thenReturn(return1);
        Mockito.`when`(calculatorService.subtract(input1, input2)).thenReturn(return2);
        Mockito.`when`(calculatorService.multiply(input1, input2)).thenReturn(return3);
        Mockito.`when`(calculatorService.divide(input1, input2)).thenReturn(return4);

        val list = ops.performMaths(input1, input2)

        Assertions.assertEquals(expected1, list[0])
        Assertions.assertEquals(expected2, list[1])
        Assertions.assertEquals(expected3, list[2])
        Assertions.assertEquals(expected4, list[3])
    }
}