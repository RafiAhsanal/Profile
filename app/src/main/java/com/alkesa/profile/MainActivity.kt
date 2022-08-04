package com.alkesa.profile

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var hex: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvPaste = findViewById<TextView>(R.id.tvPaste)
        val btnRandom = findViewById<TextView>(R.id.btnRandom)

        tvPaste.setOnLongClickListener{
            val clipboard: ClipboardManager =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                } else {
                    TODO("VERSION.SDK_INT < M")
                }
            val clip = ClipData.newPlainText(label.toString(), hex.uppercase())
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, tvPaste.text, Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }

        btnRandom.setOnClickListener{
            val r: Int = RandomColor.getRandom(0, 255)
            val g: Int = RandomColor.getRandom(0, 255)
            val b: Int = RandomColor.getRandom(0, 255)
            val color: Int = Color.rgb( r, g, b)
            hex = String.format("#%02x%02x%02x", r, g, b)
            tvPaste.setTextColor(color)
            tvPaste.text = hex.uppercase()
        }

    }

}


