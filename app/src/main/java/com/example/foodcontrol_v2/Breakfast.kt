package com.example.foodcontrol_v2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.foodcontrol_v2.fragments.FoodSearch
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import kotlin.collections.ArrayList

class Breakfast : AppCompatActivity() {

    val BREAKFAST_FILE_NAME = "Breakfast"
    val TAG = "Breakfast"

    lateinit var txtProduct: TextView
    lateinit var listProducts: ListView
    var products = ArrayList<String>()
    var klass = ArrayList<String>()
    var prod = ArrayList<Product>()
    lateinit var adapt: ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)


        listProducts = findViewById(R.id.listProducts)

        val path = getFileStreamPath(BREAKFAST_FILE_NAME)

        val products: ArrayList<Product>


        if (getFileStreamPath(BREAKFAST_FILE_NAME).exists()) {
            Log.d(TAG, "file exists")
            val fis: FileInputStream = this.openFileInput(BREAKFAST_FILE_NAME)
            val hm = ObjectInputStream(fis)
            products = hm.readObject() as ArrayList<Product>
            hm.close()
            fis.close()
        } else {
            Log.d(TAG, "file not exists")
            products = arrayListOf()
        }

        prod = ArrayList()

        try {
            var extras = intent.extras!!
            var product = extras.getString("item")!!
            var desc = extras.getString("itemdesc")!!
            products.add(Product(product, desc))
            this.products.add(product.toString())
            prod.add(Product(product.toString(), desc.toString()))
        }
        catch (e: Exception)
        {
            Toast.makeText(this, "???????????? ???? ???????? ????????????????", Toast.LENGTH_LONG).show()
        }







        showData()


        var adapter = ProductAdapter(this, products)

        listProducts.adapter = adapter


        listProducts.setOnItemClickListener { parent, view, position, id ->


            val builder = AlertDialog.Builder(this)
            builder.setTitle("???????????? ???????????????")
            builder.setMessage("???? ?????????? ???????????? ???????????? ?????????????? ???? ?????????????")
            //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                products.removeAt(position)
                val fos: FileOutputStream = this.openFileOutput(BREAKFAST_FILE_NAME, Context.MODE_PRIVATE)
                val os = ObjectOutputStream(fos)
                os.writeObject(products)
                os.close()
                fos.close()

                showData()

                Toast.makeText(applicationContext,
                    "?????????????? ?????????????? ???????????? ???? ????????????", Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(applicationContext,
                    "???? ???????????????? ????????????????", Toast.LENGTH_SHORT).show()
            }


            builder.show()




        }






        val fos: FileOutputStream = this.openFileOutput(BREAKFAST_FILE_NAME, Context.MODE_PRIVATE)
        val os = ObjectOutputStream(fos)
        os.writeObject(products)
        os.close()
        fos.close()


    }

    fun showData()
    {
        adapt = ProductAdapter(this, prod)
        listProducts.adapter = adapt





    }



    fun btnNewProduct(view: View) {

        startActivity(Intent(this, FoodSearch::class.java))

    }
}