package com.learning.projectnotepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    lateinit var sharedPref : SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val etTitle2 : EditText = findViewById(R.id.etTitle2)
        val etNote2 : EditText = findViewById(R.id.etNote2)
        val btnSave2 : Button = findViewById(R.id.btnSave2)
        val myIntent = Intent (this, MainActivity::class.java)
        val bundleNote :Bundle? = intent.extras

        val titleEdit = bundleNote?.get("title").toString()
        etTitle2.setText("$titleEdit")

        val noteEdit = bundleNote?.get("saved")
        etNote2.setText("$noteEdit")

        sharedPref = SharedPref(this)
        val keyTitle = "title"
        val keyNote = "note"

        btnSave2.setOnClickListener{
            sharedPref.saveData(keyTitle, etTitle2.text.toString().trim())
            sharedPref.saveData(keyNote, etNote2.text.toString().trim())
            startActivity(myIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val etTitle2 : EditText = findViewById(R.id.etTitle2)
        val etNote2 : EditText = findViewById(R.id.etNote2)
        val bundleNote :Bundle? = intent.extras
        val titleEdit = bundleNote?.get("title").toString()
        val noteEdit = bundleNote?.get("saved")
        val myIntent = Intent (this, MainActivity::class.java)

        when(item.itemId) {
            R.id.share -> {
                val implicitIntent = Intent()
                //val title  = etTitle2.setText("$titleEdit")
                //val note = etNote2.setText("$noteEdit")
                implicitIntent.action = Intent.ACTION_SEND
                implicitIntent.putExtra(Intent.EXTRA_TEXT, "$titleEdit \n$noteEdit")
                implicitIntent.type = "text/plain"
                startActivity(Intent.createChooser(implicitIntent, "Notes"))
            }
            R.id.delete -> {
                etTitle2.text = null
                etNote2.text = null
                sharedPref.editor.clear().commit()
                Toast.makeText(this, "Note Deleted" , Toast.LENGTH_SHORT).show()
                startActivity(myIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}