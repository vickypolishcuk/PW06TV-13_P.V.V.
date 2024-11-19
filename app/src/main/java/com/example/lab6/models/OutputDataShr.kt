package com.example.lab6.models

data class OutputDataShr (
    val name: String,     // Назва ЕП
    val nP: Int,          // n * P
    val nPK: Double,      // n * P * K
    val nPKtg: Double,    // n * P * K * tg
    val nP2: Int,         // n * P^2
    val I: Double,        // Розрахунковий струм I
)