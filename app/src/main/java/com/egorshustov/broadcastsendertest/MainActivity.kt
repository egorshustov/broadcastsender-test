package com.egorshustov.broadcastsendertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view);
    }

    fun sendBroadcast(v: View) {
        val intent = Intent("com.egorshustov.broadcastreceivertest.EXAMPLE_ACTION")
        intent.putExtra("com.egorshustov.broadcastreceivertest.EXAMPLE_TEXT", "Broadcast received")
        sendBroadcast(intent)
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val receivedText = intent?.getStringExtra("com.egorshustov.broadcastreceivertest.EXAMPLE_TEXT")
            textView.text = receivedText
        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter("com.egorshustov.broadcastreceivertest.EXAMPLE_ACTION")
        registerReceiver(broadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}
