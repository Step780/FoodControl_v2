package com.example.foodcontrol_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.foodcontrol_v2.fragments.*
import com.example.foodcontrol_v2.fragments.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileInputStream
import java.io.ObjectInputStream

class MainActivity : AppCompatActivity() {

    var weighttt = 0
    var heighttt = 0
    var age = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(SecondFragment(), "Second")

        adapter.addFragment(ThirdFragment(), "Third")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        
    }

    fun btn_Breakfast(view: View) {

//        val fis: FileInputStream = this.openFileInput("Breakfast")
//        val hm = ObjectInputStream(fis)
//        val p : String  = hm.readObject().toString()
//        hm.close()
//        fis.close()
//
//        if (p == "")
//        {
//
//        }
//
//        else {
//            val intent = Intent(this, Breakfast::class.java)
//            startActivity(intent)
//        }

        val intent = Intent(this, FoodSearch::class.java)
        startActivity(intent)


    }

    fun changeClick(view: View) {
        var extras = intent.extras!!
        var weight = extras.getString("weight1")
        var height = extras.getString("height1")
        startActivity(Intent(this, ChangeRegine::class.java)
            .apply {

                putExtra("weight2", weighttt)
                putExtra("height2", heighttt)
                putExtra("age2", age)

            })

    }


}