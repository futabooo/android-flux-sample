package com.futabooo.androidfluxsample.actioncreator

import com.futabooo.androidfluxsample.action.CountAction
import com.futabooo.androidfluxsample.action.CountActionType
import com.futabooo.androidfluxsample.dispatcher.Dispatcher

class CountActionCreator(dispatcher: Dispatcher) : ActionCreator(dispatcher) {

  fun countUp(count: Int) {
    dispatcher.dispatch(CountAction(CountActionType.COUNT_UP, count))
  }

  fun countDown(count: Int) {
    dispatcher.dispatch(CountAction(CountActionType.COUNT_DOWN, count))
  }
}