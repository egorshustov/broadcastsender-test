package com.egorshustov.broadcastsendertest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.egorshustov.broadcastsendertest.MainActivity.Companion.STRING_EXTRA_KEY

class SenderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        val resultExtras = getResultExtras(true)
        var stringExtra = resultExtras?.getString(STRING_EXTRA_KEY)

        ++resultCode
        stringExtra += "->SenderReceiver"

        val toastText = "SenderReceiver\n" +
                "resultCode: $resultCode\n" +
                "resultData: $resultData\n" +
                "stringExtra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "SenderReceiver"
        resultExtras.putString(STRING_EXTRA_KEY, stringExtra)

        setResult(resultCode, resultData, resultExtras)
    }
}