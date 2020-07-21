package com.egorshustov.broadcastsendertest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadcast(v: View) {
        val intent = Intent("com.egorshustov.EXAMPLE_ACTION")
            .setPackage("com.egorshustov.broadcastreceivertest")

        val initialExtras = Bundle().apply {
            putString(STRING_EXTRA_KEY, "Start")
        }

        sendOrderedBroadcast(
            intent, android.Manifest.permission.WAKE_LOCK,
            SenderReceiver(), null, 0, "Start", initialExtras
        )
    }

    companion object {
        const val STRING_EXTRA_KEY = "stringExtra"
    }
}
