package com.futabooo.androidfluxsample.store

import com.futabooo.androidfluxsample.action.Action
import com.futabooo.androidfluxsample.action.CountActionType

class CountStore(listener: StoreChangeListener) : Store(listener) {

  var count: Int = 0
    private set

  override fun changeEvent(): StoreChangeEvent {
    return CountStoreChangeEvent()
  }

  override fun onAction(action: Action) {
    when (action.type) {
      CountActionType.COUNT_UP -> {
        countUp(action.data as Int)
        emitStoreChange()
      }
      CountActionType.COUNT_DOWN -> {
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