package com.cristianvillamil.platziwallet.ui

class TransferProxy {
    val MAX_AMOUNT = 1000000
    val MIN_AMOUNT = 100

    fun checkTransfer(amount:Double) : String {
        return when {
            amount > MAX_AMOUNT -> {
                "La transaccion excede el monto"
            }
            amount < MIN_AMOUNT -> {
                "La transaccion debe ser mayor a $MIN_AMOUNT"
            }
            else -> {
                doTransferAmount(amount)
                "La transferencia se hizo correctamente"
            }
        }
    }

    fun doTransferAmount(amount: Double){

    }
}