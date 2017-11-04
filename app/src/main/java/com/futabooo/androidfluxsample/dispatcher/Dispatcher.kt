package com.futabooo.androidfluxsample.dispatcher

import com.futabooo.androidfluxsample.action.Action
import com.futabooo.androidfluxsample.store.Store


object Dispatcher {

  private var stores: MutableList<Store> = mutableListOf()

  fun register(store: Store) {
    stores.add(store)
  }

  fun unRegister(store: Store) {
    stores.remove(store)
  }

  fun dispatch(action: Action) {
    post(action)
  }

  private fun post(action: Action) {
    stores.forEach { it.onAction(action) }
  }
}