package com.futabooo.androidfluxsample.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.widget.TextView
import com.futabooo.androidfluxsample.R
import com.futabooo.androidfluxsample.action.CountActionCreator
import com.futabooo.androidfluxsample.dispatcher.Dispatcher
import com.futabooo.androidfluxsample.store.CountStore
import com.futabooo.androidfluxsample.store.Store

class MainActivity : AppCompatActivity(), Store.StoreChangeListener {

  private val countUpButton by lazy { findViewById<AppCompatButton>(R.id.up) }
  private val countDownButton by lazy { findViewById<AppCompatButton>(R.id.down) }
  private val count by lazy { findViewById<TextView>(R.id.count) }

  private val dispatcher by lazy { Dispatcher }
  private val countStore by lazy { CountStore(this) }
  private val countActionCreator by lazy { CountActionCreator(dispatcher) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    dispatcher.register(countStore)
    initView()
  }

  override fun onDestroy() {
    dispatcher.unRegister(countStore)
    super.onDestroy()
  }

  private fun initView() {
    countUpButton.setOnClickListener {
      countUp()
    }
    countDownButton.setOnClickListener {
      countDown()
    }
  }

  private fun countUp() {
    countActionCreator.countUp(1)
  }

  private fun countDown() {
    countActionCreator.countDown(1)
  }

  override fun onStoreChanged(event: Store.StoreChangeEvent) {
    when (event) {
      is CountStore.CountStoreChangeEvent -> {
        count.text = countStore.count.toString()
      }
    }
  }
}
