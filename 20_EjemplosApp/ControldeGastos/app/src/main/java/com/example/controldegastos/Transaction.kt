package com.example.controldegastos

import java.util.UUID

data class Transaction(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val amount: Double,
    val isIncome: Boolean
)