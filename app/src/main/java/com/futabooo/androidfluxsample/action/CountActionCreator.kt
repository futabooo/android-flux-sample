package com.futabooo.androidfluxsample.action

import com.futabooo.androidfluxsample.dispatcher.Dispatcher

class CountActionCreator(dispatcher: Dispatcher) : ActionCreator(dispatcher) {

  fun countUp(count: Int) {
    dispatcher.dispatch(CountAction(CountAction.COUNT_UP, count))
  }

  fun countDown(count: Int) {
    dispatcher.dispatch(CountAction(CountAction.COUNT_DOWN, count))
  }
}