package com.barstool.cockwojaer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_user.*
import java.util.*
import kotlin.math.min
import com.barstool.cockwojaer.algorithm as algorithm


class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        var dodajBtn = findViewById<Button>(R.id.dodajBtn)
        var testBtn = findViewById<Button>(R.id.button2)
        var originSpinner = findViewById<Spinner>(R.id.originS)
        var odleglosc = findViewById<EditText>(R.id.odległośćET)
        var destinationSpinner = findViewById<Spinner>(R.id.destinationS)
        var test = findViewById<TextView>(R.id.textView3)
        var num_nodes = 8
        var num_edges = 64
        var edges_list = Array(num_nodes){IntArray(num_nodes)}




        dodajBtn.setOnClickListener {
          edges_list[originSpinner.selectedItemPosition][destinationSpinner.selectedItemPosition] = odleglosc.text.toString().toInt()
            edges_list[destinationSpinner.selectedItemPosition][originSpinner.selectedItemPosition] = odleglosc.text.toString().toInt()



        }
        button2.setOnClickListener {
           /* test.setText("")
            for (row in edges_list){

                test.append(row.contentToString() + '\n')*/
          //test.setText()


        }





}}