package com.futabooo.androidfluxsample.action

class CountAction(type: ActionType, data: Any) : Action(type, data)

enum class CountActionType : ActionType {
  COUNT_UP, COUNT_DOWN
}