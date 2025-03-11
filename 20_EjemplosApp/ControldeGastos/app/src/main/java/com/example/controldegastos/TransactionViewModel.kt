package com.example.controldegastos

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.toMutableStateList

class TransactionViewModel : ViewModel() {
    private val _transactions = mutableStateListOf<Transaction>()
    val transactions: List<Transaction> = _transactions

    fun addTransaction(transaction: Transaction) {
        _transactions.add(transaction)
    }

    fun getBalance(): Double {
        return _transactions.sumOf { if (it.isIncome) it.amount else -it.amount }
    }
}