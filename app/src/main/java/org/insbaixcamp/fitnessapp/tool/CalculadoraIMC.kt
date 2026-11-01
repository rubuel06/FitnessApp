package org.insbaixcamp.fitnessapp.tool

import kotlin.math.round

class CalculadoraIMC {
    companion object {

        /*
        calcula l'index de massa corporal (IMC) a partir del pes i l'alçada
         */
        fun calcularIMC(pes: Double, alçada: Int): Double {
            val alturaMetros = alçada.toDouble() / 100
            return round(pes / (alturaMetros * alturaMetros))
        }
    }
}
