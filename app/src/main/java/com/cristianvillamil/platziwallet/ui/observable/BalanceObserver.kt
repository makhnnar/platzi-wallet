package com.cristianvillamil.platziwallet.ui.observable

class BalanceObserver : Observable {

    private val balanceObserverList : ArrayList<Observer> = arrayListOf()
    private var balance : Double = 0.0

    fun changeBalance(newValue: Double){
        balance = newValue
        notifyObserver(newValue)
    }

    override fun addObserver(observer: Observer) {
        balanceObserverList.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        balanceObserverList.remove(observer)
    }

    override fun notifyObserver(newValue: Double) {
        balanceObserverList.forEach {
            it.notifyChange(newValue)
        }
    }
}