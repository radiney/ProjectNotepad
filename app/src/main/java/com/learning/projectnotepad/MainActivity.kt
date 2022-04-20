package com.learning.projectnotepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvNotePad : ListView = findViewById(R.id.lvNotePad)
        val fabAdd : FloatingActionButton = findViewById(R.id.fabAdd)
        val firstIntent = Intent(this, SecondActivity::class.java )
        val thirdIntent = Intent(this, ThirdActivity::class.java)

        sharedPref = SharedPref(this)

        val noteList = ArrayList<Notes>()

        val keyTitle = "title"
        val keyNote = "note"

        if (noteList.size == 0 ) {

        var note = Notes("${sharedPref.retrieveData(keyTitle)}", "${sharedPref.retrieveData(keyNote)}")
        noteList.add(note)

        } else {

            var note1 = Notes("${sharedPref.retrieveData(keyTitle)}", "${sharedPref.retrieveData(keyNote)}")
            noteList.add(note1)
        }


        var adapter = NoteAdapter(this, noteList)

        lvNotePad.adapter = adapter
        lvNotePad.setOnItemClickListener{ AdapterView, view , i, l ->
            thirdIntent.putExtra("title", noteList.get(i).title)
            thirdIntent.putExtra("saved", noteList.get(i).saved)
            startActivity((thirdIntent))
        }


        fabAdd.setOnClickListener{
            startActivity(firstIntent)
        }

    }

    override fun onBackPressed() {

        finishAffinity()
        super.onBackPressed()

    }
}

