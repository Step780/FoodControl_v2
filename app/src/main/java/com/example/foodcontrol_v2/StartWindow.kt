package com.example.foodcontrol_v2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.first_window.*

class StartWindow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.first_window)



    }

    fun buttonnext(view: View) {
        var height = heighttxt.text.toString()
        var weight = weighttxt.text.toString()
        var age = edtAge.text.toString()

        if (height.isNotEmpty() && weight.isNotEmpty() && age.isNotEmpty() && (male.isChecked || female.isChecked))
        {


            startActivity(Intent(this, Priority_Weight::class.java)
                .apply {
                putExtra("male", male.isChecked)
                    putExtra("sit", sitRegine.isChecked)
                    putExtra("height", heighttxt.text.toString())
                    putExtra("weight", weighttxt.text.toString())
                    putExtra("training", trainingRegine.isChecked)
                    putExtra("classes", classesRegine.isChecked)
                    putExtra("intens", intensRegine.isChecked)
                    putExtra("sportsman", sportsmanRegine.isChecked)
                    putExtra("age", edtAge.text.toString())
            })
        }
        else {
            Toast.makeText(this, "Вы не ввели рост или вес!", Toast.LENGTH_LONG).show()

        }


    }

}