package com.barstool.cockwojaer

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlinx.android.synthetic.main.activity_user.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import kotlin.random.Random

class RandomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)
        var dodajBtn = findViewById<Button>(R.id.dodajBtn)
        var backBtn = findViewById<Button>(R.id.backBtn)

        var originSpinner = findViewById<Spinner>(R.id.originS)

        var destinationSpinner = findViewById<Spinner>(R.id.destinationS)

        var result = findViewById<TextView>(R.id.result)
        var num_nodes = 8
        var num_edges = 64
        var edges_list = Array(num_nodes){IntArray(num_nodes)}

        fun isNumeric(str: String): Boolean = str
            .removePrefix("-")
            .removePrefix("+")
            .all { it in '0'..'9' }
        fun takeScreenshotOfView(view: View, height: Int, width: Int): Bitmap {
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            val bgDrawable = view.background
            if (bgDrawable != null) {
                bgDrawable.draw(canvas)
            } else {
                canvas.drawColor(Color.WHITE)
            }
            view.draw(canvas)
            return bitmap
        }

        fun liczenieTrasy(){


            val cities = 8
            val visitedCities = BooleanArray(cities)
            val shortestPath = IntArray(cities)
            var currentCity = 1
            visitedCities[currentCity] = true
            for (i in 0 until cities-1) {
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
            if(originSpinner.selectedItemPosition == destinationSpinner.selectedItemPosition){
                var toast = Toast.makeText(baseContext, "Nie możesz ustawić odległości do tego samego miasta", Toast.LENGTH_SHORT)
                toast.show()

            }else{

                edges_list[originSpinner.selectedItemPosition][destinationSpinner.selectedItemPosition] = Random.nextInt(0, 100)

                edges_list[destinationSpinner.selectedItemPosition][originSpinner.selectedItemPosition] = Random.nextInt(0, 100)

                var toast = Toast.makeText(baseContext, "Dodano odległość", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        algoBtn.setOnClickListener {
            result.text =""
            liczenieTrasy()

        }
        backBtn.setOnClickListener {
            val intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        screenShotBtn.setOnClickListener {
            var file: File? = null
            var view = findViewById<View?>(android.R.id.content)
            var bitmap = takeScreenshotOfView(view,view.height,view.width)
            return@setOnClickListener try {

                file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString() + File.separator + "wynik.png")
                file.createNewFile()
                val bos = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.PNG,0,bos)
                val bitmapdata = bos.toByteArray()

                val fos = FileOutputStream(file)
                fos.write(bitmapdata)
                fos.flush()
                fos.close()

            }catch (e:java.lang.Exception){
                e.printStackTrace()

            }

        }


    }}