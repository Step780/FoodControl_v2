package com.example.foodcontrol_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_priority__weight.*

class Priority_Weight : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_priority__weight)

        numberPick.minValue = 30
        numberPick.maxValue = 120
        numberPick.wrapSelectorWheel = false


    }

    fun btnNext(view: View) {

        var extras = intent.extras!!
        var isMale = extras.getBoolean("male")
        var weight = extras.getString("weight")
        var height = extras.getString("height")
        var isSit = extras.getBoolean("sit")
        var isTraining = extras.getBoolean("training")
        var isClasses = extras.getBoolean("classes")
        var isIntens = extras.getBoolean("intens")
        var isSportsman = extras.getBoolean("sportsman")
        var age = extras.getString("age")
        startActivity(Intent(this, MainActivity::class.java)
            .apply {

                putExtra("PriorityWeight", numberPick.getValue().toString())
                putExtra("male1", isMale)
                putExtra("weight1", weight.toString())
                putExtra("height1", height.toString())
                putExtra("isSit1", isSit)
                putExtra("isTraining1", isTraining)
                putExtra("isClasses1", isClasses)
                putExtra("isIntens1", isIntens)
                putExtra("isSportsman1", isSportsman)
                putExtra("age1", age.toString())

            })

    }
}