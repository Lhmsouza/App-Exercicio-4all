package com.example.go4all

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun processInfoButton(view: View){
        val infoIntent = Intent(this, InfoActivity::class.java)

        startActivity(infoIntent)
    }

    fun processTimeButton(view: View){
        val showGottenTimestampView = findViewById<TextView>(R.id.timeText) // Encontra os views de time stamp, para alteracao da time stamp atual, e de constraintLayout, para mudar a cor do fundo do app
        val layoutView = findViewById<ConstraintLayout>(R.id.constraintLayout)

        val unixTimestamp = System.currentTimeMillis() / 1000               // Calcula time stamp no formato UNIX
        val gottenTimestampString = unixTimestamp.toString()

        val toastGetTime = Toast.makeText(this, "Updated time stamp!", Toast.LENGTH_SHORT)

        val newBackground = when(gottenTimestampString.takeLast(1)){ // Verifica o ultimo digito da string de timestamp
            "0" -> "#fcb268"
            "1" -> "#ff3030"
            "2" -> "#ff1493"
            "3" -> "#00bfff"
            "4" -> "#334660"
            "5" -> "#ff4500"
            "6" -> "#adff2f"
            "7" -> "#ffa500"
            "8" -> "#236648"
            "9" -> "#bbffff"
            else -> "#000000"
        }

        showGottenTimestampView.text = "Current time stamp: " + gottenTimestampString + "\nCurrent color: " + newBackground

        toastGetTime.show()

        layoutView.setBackgroundColor(Color.parseColor(newBackground))

    }
}
