package com.barstool.cockwojaer

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        var dodajBtn = findViewById<Button>(R.id.dodajBtn)


        var originSpinner = findViewById<Spinner>(R.id.originS)
        var odleglosc = findViewById<EditText>(R.id.odległośćET)
        var destinationSpinner = findViewById<Spinner>(R.id.destinationS)

        var result = findViewById<TextView>(R.id.result)
        var num_nodes = 8
        var num_edges = 64
        var edges_list = Array(num_nodes){IntArray(num_nodes)}

        fun isNumeric(str: String): Boolean = str
            .removePrefix("-")
            .removePrefix("+")
            .all { it in '0'..'9' }

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
                if(i == cities-1){
                    result.append("${shortestPath[i]}")
                }else {
                    result.append("${shortestPath[i]} >> ")
                }
            }


            var cost = 0
            for (i in 0 until cities - 1) {
                cost += edges_list[shortestPath[i]][shortestPath[i + 1]]
            }
            result.append("\nŁączny pokonany dystans: $cost km")
        }




        dodajBtn.setOnClickListener {
            if(originSpinner.selectedItemPosition == destinationSpinner.selectedItemPosition){
                var toast = Toast.makeText(baseContext, "Nie możesz ustawić odległości do tego samego miasta", Toast.LENGTH_SHORT)
                toast.show()

            }else if (isNumeric(odleglosc.text.toString())){

                edges_list[originSpinner.selectedItemPosition][destinationSpinner.selectedItemPosition] =
                    odleglosc.text.toString().toInt()
                edges_list[destinationSpinner.selectedItemPosition][originSpinner.selectedItemPosition] =
                    odleglosc.text.toString().toInt()
                var toast = Toast.makeText(baseContext, "Dodano odległość", Toast.LENGTH_SHORT)
                toast.show()
            }else{

                var toast = Toast.makeText(baseContext, "Można wprowadzić tylko liczby", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        algoBtn.setOnClickListener {
            result.text =""
            liczenieTrasy()

        }


}}