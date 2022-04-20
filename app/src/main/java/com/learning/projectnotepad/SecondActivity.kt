package com.learning.projectnotepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

        lateinit var sharedPref : SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val etTitle : EditText = findViewById(R.id.etTitle)
        val etNote : EditText = findViewById(R.id.etNote)
        val btnSave : Button = findViewById(R.id.btnSave)
        val myIntent = Intent (this, MainActivity::class.java)

        sharedPref = SharedPref(this)
        val keyTitle = "title"
        val keyNote = "note"

        btnSave.setOnClickListener{
            sharedPref.saveData(keyTitle, etTitle.text.toString().trim())
            sharedPref.saveData(keyNote, etNote.text.toString().trim())
            startActivity(myIntent)

        }
    }
}