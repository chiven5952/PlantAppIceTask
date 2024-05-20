package com.chiven.plantapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    private lateinit var  imgPlant: ImageView
    private var health = 100
    private var water = 0
    private var sunlight = 100

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        imgPlant = findViewById(R.id.imgPant)

        //buttons
        val btnWater = findViewById<Button>(R.id.btnWater)
        val btnHealth = findViewById<Button>(R.id.btnHealth)
        val btnSunlight = findViewById<Button>(R.id.btnSunlight)

        //changing animation
      //  val waterAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_water)
        //val fertilizeAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_fertilize)
        //val sunAnimation = AnimationUtils.loadAnimation(this, R.anim.plant_sun)

        updateUI()

        btnWater.setOnClickListener {
            waterPlant()
            updateUI()
        }

        btnHealth.setOnClickListener {
            fertilizePlant()
            updateUI()
        }

        btnSunlight.setOnClickListener {
            putPlantInSun()
            updateUI()
        }
    }

    //methods
    private fun waterPlant() {
        sunlight -= 5
        if (water < 0) water = 0
        if (water < 100) water += 10
    }

    private fun fertilizePlant() {
        health = 100
    }

    private fun putPlantInSun() {

        health -= 10
        if (health > 100) health = 100
        sunlight += 10
        if (water > 100) water = 100
        water -= 5
        if (sunlight < 0) sunlight = 0
    }

    private fun updateUI() {
        val txtHealth = findViewById<TextView>(R.id.txtHealth)
        val txtWater = findViewById<TextView>(R.id.txtWater)
        val txtSunlight = findViewById<TextView>(R.id.txtSunlight)

        txtHealth.text = "Health: $health"
        txtWater.text = "Water: $water"
        txtSunlight.text = "Sun: $sunlight"
    }
}