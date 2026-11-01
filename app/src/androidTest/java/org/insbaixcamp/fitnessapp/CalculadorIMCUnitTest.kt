package org.insbaixcamp.fitnessapp

import junit.framework.TestCase.assertEquals
import org.insbaixcamp.fitnessapp.tool.CalculadoraIMC
import org.junit.Test


@Test
fun CalculadorIMCUnitTest {

    var pes = 70.0
    var alçada = 1.70
    var imc = CalculadoraIMC.calcularIMC(pes, alçada)
    assertEquals(70.0 / (1.70 * 1.70), imc, 0.01)

}


@Test
fun testCalcularIMC2(){

    var pes = 70.0
    var alçada = 1.70
    var imc = CalculadoraIMC.calcularIMC(pes, alçada)
    assertEquals(70.0 / (1.70 * 1.70), imc, 0.01)

}



