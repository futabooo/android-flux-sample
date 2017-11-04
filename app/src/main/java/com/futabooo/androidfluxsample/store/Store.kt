package com.futabooo.androidfluxsample.store

import com.futabooo.androidfluxsample.action.Action

abstract class Store(private val listener: StoreChangeListener) {
  fun emitStoreChange() {
    listener.onStoreChanged(changeEvent())
  }

  abstract fun changeEvent(): StoreChangeEvent
  abstract fun onAction(action: Action)

  interface StoreChangeEvent

  interface StoreChangeListener {

    fun onStoreChanged(event: Store.StoreChangeEvent)
  }
}