package com.example.foodcontrol_v2.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import com.example.foodcontrol_v2.Breakfast
import com.example.foodcontrol_v2.ChangeRegine
import com.example.foodcontrol_v2.MainActivity
import com.example.foodcontrol_v2.R
import kotlinx.android.synthetic.main.activity_priority__weight.*
import kotlinx.android.synthetic.main.first_window.*
import kotlinx.android.synthetic.main.fragment_thrid.*


class ThirdFragment : Fragment() {
    
    lateinit var sit: RadioButton
    lateinit var dayCal: TextView
    lateinit var male: RadioButton
    lateinit var prior: TextView
    lateinit var weightTxt: TextView
    var weighttt = 0
    var heighttt = 0
    var age = 0
    var male2 = false
    lateinit var txtWeight: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View


        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_thrid, container, false)
        //sit = view.findViewById(R.id.sitRegine)
        dayCal = view.findViewById(R.id.dayCal)
        var extras2 = activity!!.intent.extras!!
        var text2 = extras2.getString("text")

        dayCal = view!!.findViewById(R.id.dayCal)

        if(text2 != "")
        {
            dayCal.text = text2
        }
        var extras = activity!!.intent.extras!!
        var isMale = extras.getBoolean("male1")
        var weight = extras.getString("weight1")
        var height = extras.getString("height1")
        var isSit = extras.getBoolean("isSit1")
        var isTraining = extras.getBoolean("isTraining1")
        var isClasses = extras.getBoolean("isClasses1")
        var isIntens = extras.getBoolean("isIntens1")
        var isSportsman = extras.getBoolean("isSportsman1")
        var age = extras.getString("age1")
        val priorityweight = extras.getString("PriorityWeight")
        prior = view.findViewById(R.id.priorTxt)
        prior.text = priorityweight
        weightTxt = view.findViewById(R.id.weightStart)
        male2 = isMale
        weightTxt.text = weight
        txtWeight = view.findViewById(R.id.txtWeight)
        txtWeight.text = weight



        if (isMale) {
            if (isSit) {
                dayCal.text =
                    ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                        .toDouble()) - (5.7 * age.toString().toDouble())) * 1.2).toInt().toString()
            }

            if (isTraining) {
                dayCal.text =
                    ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                        .toDouble()) - ((5.7 * age.toString().toDouble()))) * 1.375).toInt().toString()
            }

            if (isClasses)
            {
                dayCal.text =
                    ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                        .toDouble()) - ((5.7 * age.toString().toDouble()))) * 1.55).toInt().toString()
            }

            if (isIntens)
            {
                dayCal.text =
                    ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                        .toDouble()) - ((5.7 * age.toString().toDouble()))) * 1.725).toInt().toString()

            }

            if (isSportsman)
            {
                dayCal.text =
                    ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                        .toDouble()) - ((5.7 * age.toString().toDouble()))) * 1.9).toInt().toString()
            }



        }

        else {
            if (isSit) {
                dayCal.text =
                    ((447.6 + (9.2 * weight.toString().toDouble()) + (3.1 * height.toString()
                        .toDouble()) - ((4.3 * age.toString().toDouble()))) * 1.2).toInt().toString()
            }

            if (isTraining) {
                dayCal.text =
                    ((447.6 + (9.2 * weight.toString().toDouble()) + (3.1 * height.toString()
                        .toDouble()) - (4.3 * age.toString().toDouble())) * 1.375).toInt().toString()
            }

            if (isClasses)
            {
                dayCal.text =
                    ((447.6 + (9.2 * weight.toString().toDouble()) + (3.1 * height.toString()
                        .toDouble()) - (4.3 * age.toString().toDouble())) * 1.55).toInt().toString()
            }

            if (isIntens)
            {
                dayCal.text =
                    ((447.6 + (9.2 * weight.toString().toDouble()) + (3.1 * height.toString()
                        .toDouble()) - (4.3 * age.toString().toDouble())) * 1.725).toInt().toString()

            }

            if (isSportsman)
            {
                dayCal.text =
                    ((447.6 + (9.2 * weight.toString().toDouble()) + (3.1 * height.toString()
                        .toDouble()) - (4.3 * age.toString().toDouble())) * 1.9).toInt().toString()
            }


        }

        return view
    }


    fun changeClick()
    {

        startActivity(Intent(activity, ChangeRegine::class.java)
            .apply {

                putExtra("weight2", weighttt)
                putExtra("height2", heighttt)
                putExtra("age2", age)
                putExtra("male", male2)

            })
    }



}