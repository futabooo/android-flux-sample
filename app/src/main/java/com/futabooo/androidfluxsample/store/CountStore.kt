package com.futabooo.androidfluxsample.store

import com.futabooo.androidfluxsample.action.Action
import com.futabooo.androidfluxsample.action.CountAction

class CountStore(listener: StoreChangeListener) : Store(listener) {

  var count: Int = 0

  override fun changeEvent(): StoreChangeEvent {
    return CountStoreChangeEvent()
  }

  override fun onAction(action: Action) {
    when (action.type) {
      CountAction.COUNT_UP -> {
        countUp(action.data as Int)
        emitStoreChange()
      }
      CountAction.COUNT_DOWN -> {
        countDown(action.data as Int)
        emitStoreChange()
      }
    }
  }

  private fun countUp(count: Int) {
    this.count += count
  }

  private fun countDown(count: Int) {
    this.count -= count
  }

  open class CountStoreChangeEvent : StoreChangeEvent
}