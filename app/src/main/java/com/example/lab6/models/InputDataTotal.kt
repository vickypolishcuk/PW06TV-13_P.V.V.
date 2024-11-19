package com.example.lab6.models

data class InputDataTotal (
    val n: Int,        // Кількість ЕП
    val nP: Int,       // n * P
    val nPK: Int,      // n * P * K
    val nPKtg: Int,    // n * P * K * tg
    val nP2: Int,      // n * P^2
)