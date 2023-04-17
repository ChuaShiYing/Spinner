package com.example.spinnertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create Spinner
        val spinner: Spinner = findViewById(R.id.ColorSelection)
        spinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.color_name,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long){
        val selectionTv : TextView = findViewById(R.id.ColorResult)
        selectionTv.text = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        val selectionTv : TextView = findViewById(R.id.ColorResult)
        selectionTv.text = "You Have Not Make A Color Selection"
    }

}