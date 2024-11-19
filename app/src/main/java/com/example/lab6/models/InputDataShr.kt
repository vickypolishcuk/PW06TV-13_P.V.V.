package com.example.lab6.models

data class InputDataShr (
    val name: String,     // Назва ЕП
    val nomK: Double,     // Номінальне значення коефіцієнта корисної дії ЕП
    val cos: Double,      // Коефіцієнт потужності навантаження: cos
    val U: Double,        // Напруга навантаження: Uн, кВ
    val n: Int,           // Кількість ЕП: n, шт
    val P: Int,           // Номінальна потужність ЕП: P, кВт
    val K: Double,        // Коефіцієнт використання: КВ
    val tg: Double,       // Коефіцієнт реактивної потужності: tgφ
)