package com.example.foodcontrol_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.foodcontrol_v2.fragments.ThirdFragment
import kotlinx.android.synthetic.main.activity_priority__weight.*
import kotlinx.android.synthetic.main.first_window.*

class ChangeRegine : AppCompatActivity() {

    var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_regine)
    }

    fun btnChange(view: View) {
        var extras = intent.extras!!

        var weight = extras.getInt("weight2")
        var height = extras.getInt("height2")
        var age = extras.getInt("age2")
        var isMale = extras.getBoolean("male")
        if (sitRegine.isChecked || trainingRegine.isChecked || classesRegine.isChecked || intensRegine.isChecked || sportsmanRegine.isChecked)
        {

            if (isMale) {
                if (sitRegine.isChecked) {

                    text =
                        ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.2).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })

                }

                if (trainingRegine.isChecked) {
                    text =
                        ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.375).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })

                }

                if (classesRegine.isChecked) {
                    text =
                        ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.55).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })


                }

                if (intensRegine.isChecked) {
                    text =
                        ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.725).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })


                }


                if (sportsmanRegine.isChecked) {
                    text =
                        ((88.36 + (13.4 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.9).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })
                }
            }

            else {
                if (sitRegine.isChecked) {

                    text =
                        ((447.6 + (9.2 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.2).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })

                }

                if (trainingRegine.isChecked) {
                    text =
                        ((447.6 + (9.2 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.375).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })

                }

                if (classesRegine.isChecked) {
                    text =
                        ((447.6 + (9.2 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.55).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })


                }

                if (intensRegine.isChecked) {
                    text =
                        ((447.6 + (9.2 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.725).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })


                }


                if (sportsmanRegine.isChecked) {
                    text =
                        ((447.6 + (9.2 * weight.toString().toDouble()) + (4.8 * height.toString()
                            .toDouble()) - (5.7 * age.toString().toDouble())) * 1.9).toInt()
                            .toString()


                    Toast.makeText(this, "Успешно изменено", Toast.LENGTH_LONG).show()

                    startActivity(
                        Intent(this, MainActivity::class.java)
                            .apply {

                                putExtra("text", text)

                            })
                }
            }

        }


    }
}