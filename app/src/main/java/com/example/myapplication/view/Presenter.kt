package com.example.myapplication.view

import com.example.myapplication.model.CounterModel

class Presenter(private var view: CounterView) {

    private var model = CounterModel()

    fun increment() {
        model.increment()
        view.showNewCount(model.number)

        if (model.number == 10) {
            view.showToast("Поздравляем")
        } else if (model.number == 15) {
            view.changeColor()
        }
    }

    fun decrement() {
        model.decrement()
        view.showNewCount(model.number)
    }

}