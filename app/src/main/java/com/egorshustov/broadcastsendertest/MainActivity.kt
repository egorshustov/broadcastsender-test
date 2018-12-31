package com.egorshustov.broadcastsendertest

import android.content.*
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
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
        //intent.setClass(this, ExampleBroadcastReceiver2::class.java)

        /*val componentName = ComponentName("com.egorshustov.broadcastreceivertest",
            "com.egorshustov.broadcastreceivertest.ExampleBroadcastReceiver")
        intent.component = componentName*/

        /*intent.setClassName("com.egorshustov.broadcastreceivertest",
            "com.egorshustov.broadcastreceivertest.ExampleBroadcastReceiver")*/

        /*intent.setPackage("com.egorshustov.broadcastreceivertest")
        sendBroadcast(intent)*/

        val infos : List<ResolveInfo> = packageManager.queryBroadcastReceivers(intent, 0)

        for (info in infos) {
            val componentName = ComponentName(info.activityInfo.packageName, info.activityInfo.name)
            intent.component = componentName
            sendBroadcast(intent)
        }
    }
}
