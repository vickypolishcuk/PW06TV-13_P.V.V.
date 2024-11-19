package com.example.lab6.models

data class TotalShr (
    val name: String,     // Назва ЕП
    val n: Int,           // Кількість ЕП
    val nP: Int,          // n * P
    val K: Double,        // Коефіцієнт використання
    val nPK: Double,      // n * P * K
    val nPKtg: Double,    // n * P * K * tg
    val nP2: Int,         // n * P^2
    val nEf: Double,      // Ефективна кількість ЕП
    val Ka: Double,       // Розрахунковий коефіцієнт активної потужності
    val Ra: Double,       // Розрахункове активне навантаження
    val Rr: Double,       // Розрахункове реактивне навантаження
    val S: Double,        // Повна потужність
    val I: Double,        // Розрахунковий струм I
)