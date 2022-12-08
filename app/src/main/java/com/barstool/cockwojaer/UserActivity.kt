package com.barstool.cockwojaer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)



        val map = arrayOf(
            intArrayOf(0,10,15,20,25,30,35,40),
            intArrayOf(10,0,4,76,3,3,74,53),
            intArrayOf(15,23,0,52,77,56,99,15),
            intArrayOf(20,32,43,0,12,34,76,34),
            intArrayOf(25,76,23,78,0,11,22,54),
            intArrayOf(30,98,88,23,52,0,77,21),
            intArrayOf(35,23,53,23,78,56,0,98),
            intArrayOf(40,12,43,65,76,11,89,0),
        )



    }
}