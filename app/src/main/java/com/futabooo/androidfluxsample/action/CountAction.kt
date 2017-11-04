package com.futabooo.androidfluxsample.action

class CountAction(type: String, data: Any) : Action(type, data) {
  companion object {
    const val COUNT_UP = "count_up"
    const val COUNT_DOWN = "count_down"
  }
}