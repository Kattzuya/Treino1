package com.example.treino1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val resposta = findViewById<TextView>(R.id.resposta)
        val service = Network.getPersonagemService()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val personagens = service.getPersonagens()
                CoroutineScope(Dispatchers.Main).launch {
                    resposta.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                    resposta.text = personagens.toString()
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    resposta.setTextColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.purple_200
                        )
                    )
                    resposta.text = "Deu ruim"

                }
            }
        }

    }

}