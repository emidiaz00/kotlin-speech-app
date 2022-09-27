package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener{

    var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        var txt: String = findViewById<TextView>(R.id.txt_hello).text.toString()
        Log.i("mensaje: ", txt)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.txt_hello).text = "Listo!"
        } else {
            findViewById<TextView>(R.id.txt_hello).text = "No disponible"
        }
    }
}