package com.example.lab6.functions

import com.example.lab6.models.InputDataShr
import com.example.lab6.models.InputDataTotal
import com.example.lab6.models.OutputDataShr
import com.example.lab6.models.OutputDataTotal
import com.example.lab6.models.TotalShr
import kotlin.math.sqrt
import kotlin.math.pow

class CalculatorsFunctions {
    // Функція обчислень значень кожного ЕП
    fun calculateShr(data: InputDataShr): OutputDataShr {
        val nP = data.n * data.P
        val nPK = nP * data.K
        val nPKtg = nPK * data.tg
        val nP2 = data.n * data.P * data.P
        val I = nP / (sqrt(3.0) * data.U * data.cos * data.nomK)

        return OutputDataShr(data.name, nP, round(nPK), round(nPKtg), nP2, round(I))
    }

    // Функція обчислень загального ШР
    fun calculateTotalShr(data1: List<InputDataShr>, data2: List<OutputDataShr>): TotalShr {
        val n = data1.sumOf {it.n} // sumOf - Повертає суму всіх значень, створених
        // функцією селектора, застосованою до кожного елемента в послідовності
        val nP = data2.sumOf {it.nP}
        val nPK = data2.sumOf {it.nPK}
        val nPKtg = data2.sumOf {it.nPKtg}
        val nP2 = data2.sumOf {it.nP2}
        val K = nPK / nP
        val nEf = (nP.toDouble().pow(2)) / nP2
        val Ka = 1.25
        val Ra = Ka * nPK
        val Rr = 1.0 * nPKtg
        val S = sqrt(Ra.pow(2) + Rr.pow(2))
        val I = Ra / 0.38

        return TotalShr("ШР", n, nP, round(K), round(nPK), round(nPKtg), nP2,
            round(nEf), Ka, round(Ra), round(Rr), round(S), round(I))
    }
    // Функція для обчислення всього цеху
    fun calculateTotal(data: InputDataTotal): OutputDataTotal {
        val K = data.nPK.toDouble() / data.nP.toDouble()
        val nEf = (data.nP.toDouble()).pow(2) / data.nP2
        val Ka = 0.7
        val Ra = Ka * data.nPK
        val Rr = Ka * data.nPKtg
        val S = sqrt(Ra.pow(2) + Rr.pow(2))
        val I = Ra / 0.38

        return OutputDataTotal(round(K), round(nEf), Ka, Ra, Rr, round(S), round(I))
    }
    // Приватна функція для заокруглення значень до двох знаків після коми
    private fun round(num: Double): Double {
        return String.format("%.2f", num).toDouble()
    }
}