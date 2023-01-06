package com.barstool.cockwojaer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.icu.lang.UCharacter
import android.widget.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.coroutines.withTimeout
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min
import com.barstool.cockwojaer.algorithm as algorithm

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        var dodajBtn = findViewById<Button>(R.id.dodajBtn)
        var arrayBtn = findViewById<Button>(R.id.arrayButton)
        var testBtn = findViewById<Button>(R.id.button2)
        var originSpinner = findViewById<Spinner>(R.id.originS)
        var odleglosc = findViewById<EditText>(R.id.odległośćET)
        var destinationSpinner = findViewById<Spinner>(R.id.destinationS)
        var test = findViewById<TextView>(R.id.textView3)
        var result = findViewById<TextView>(R.id.result)
        var num_nodes = 8
        var num_edges = 64
        var edges_list = Array(num_nodes){IntArray(num_nodes)}

        fun liczenieTrasy(){


            val cities = 8
            val visitedCities = BooleanArray(cities)
            val shortestPath = IntArray(cities)
            var currentCity = 0
            visitedCities[currentCity] = true
            for (i in 0 until cities - 1) {
                var minDistance = Int.MAX_VALUE


                var leastDistance = 0


                for (j in 0 until cities) {
                    if (!visitedCities[j] && edges_list[currentCity][j] < minDistance) {
                        minDistance = edges_list[currentCity][j]
                        leastDistance = j
                    }
                }


                shortestPath[i] = leastDistance
                visitedCities[leastDistance] = true


                currentCity = leastDistance
            }


            shortestPath[cities - 1] = 0


            for (i in 0 until cities) {
                result.append("${shortestPath[i]} >> ")
            }


            var cost = 0
            for (i in 0 until cities - 1) {
                cost += edges_list[shortestPath[i]][shortestPath[i + 1]]
            }
            result.append("\nŁączny pokonany dystans: $cost km")
        }




        dodajBtn.setOnClickListener {
          edges_list[originSpinner.selectedItemPosition][destinationSpinner.selectedItemPosition] = odleglosc.text.toString().toInt()
            edges_list[destinationSpinner.selectedItemPosition][originSpinner.selectedItemPosition] = odleglosc.text.toString().toInt()
          var toast =  Toast.makeText(baseContext,"dodano",Toast.LENGTH_SHORT)
            toast.show()

        }
        button2.setOnClickListener {
            //liczenieTrasy()
            Toast.makeText(getBaseContext(), "Reason can not be blank", Toast.LENGTH_SHORT).show()
        }
        arrayBtn.setOnClickListener {
            test.setText("")
            for (row in edges_list) {

            test.append(row.contentToString() + '\n')
        }
        }

}}