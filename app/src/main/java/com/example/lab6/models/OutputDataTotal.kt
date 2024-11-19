package com.example.lab6.models

data class OutputDataTotal (
    val K: Double,        // Коефіцієнт використання
    val nEf: Double,      // Ефективна кількість ЕП
    val Ka: Double,       // Розрахунковий коефіцієнт активної потужності
    val Ra: Double,       // Розрахункове активне навантаження
    val Rr: Double,       // Розрахункове реактивне навантаження
    val S: Double,        // Повна потужність
    val I: Double,        // Розрахунковий струм I
)