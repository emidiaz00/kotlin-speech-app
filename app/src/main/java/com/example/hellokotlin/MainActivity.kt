package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener{

    var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        findViewById<Button>(R.id.btnSpeak).setOnClickListener {
            speak()
        }

    }
    private fun speak() {
        var message: String = findViewById<TextView>(R.id.etMessage).text.toString()

        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")

        if (message.isEmpty()) {
            findViewById<TextView>(R.id.tvStatus).text = "Debes ingresar un texto!"
        }
    }
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.tvStatus).text = "Ready!"
            tts!!.setLanguage(Locale.US)
        } else {
            findViewById<TextView>(R.id.tvStatus).text = "No disponible"
        }
    }
    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}