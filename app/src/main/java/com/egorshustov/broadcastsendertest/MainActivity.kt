package com.egorshustov.broadcastsendertest

import android.content.*
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)
    }

    fun sendBroadcast(v: View) {
        val intent = Intent("com.egorshustov.EXAMPLE_ACTION")

        intent.setPackage("com.egorshustov.broadcastreceivertest")

        val initialExtras = Bundle()
        initialExtras.putString("stringExtra", "Start")

        sendOrderedBroadcast(intent, null, SenderReceiver(), null, 0, "Start", initialExtras)
    }
}
