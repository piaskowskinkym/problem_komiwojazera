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

fun <T: Comparable<T>> nextPermutation(vector: MutableList<T>, first: Int, last: Int): Boolean {
    if (first == last) {
        return false
    }

    var i = last
    while (i > first && vector[i - 1] >= vector[i]) {
        i--
    }

    if (i == first) {
        return false
    }

    var j = last
    while (vector[j] <= vector[i - 1]) {
        j--
    }

    val temp = vector[i - 1]
    vector[i - 1] = vector[j]
    vector[j] = temp

    j = last
    while (i < j) {
        val temp2 = vector[i]
        vector[i] = vector[j]
        vector[j] = temp2
        i++
        j--

    }

    return true
}
fun shortest_path_sum(edges_list:Array<IntArray>) :Int{
    var source = 0

    val nodes = Vector<Int>()

    for (i in 0..7) {
        if (i != source) {
            nodes.add(i)
        }

    }

    var shortest_path = Int.MAX_VALUE

    while (nextPermutation(nodes, nodes.firstElement(), nodes.lastElement())){
        var path_weight = 0
        var j = source
        for(n in nodes){
            path_weight += edges_list[j][nodes[n]]
            j = nodes[n]
        }
        path_weight += edges_list[j][source]
        shortest_path = min(shortest_path, path_weight).toInt()
    }
    return shortest_path
}

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
            var it = shortest_path_sum(edges_list)
            test.text = it.toString()

        }





}}