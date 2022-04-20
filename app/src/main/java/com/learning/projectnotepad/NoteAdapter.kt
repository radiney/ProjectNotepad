package com.learning.projectnotepad

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NoteAdapter( private val context: Activity, private val arrayList: ArrayList<Notes>)
    : ArrayAdapter<Notes> (context , R.layout.list_items, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_items, null)

        val tvTitle : TextView = view.findViewById(R.id.tvTitle)
        val tvNotes : TextView = view.findViewById(R.id.tvNotes)

        tvTitle.text = arrayList[position].title
        tvNotes.text = arrayList[position].saved

        return view
    }
}