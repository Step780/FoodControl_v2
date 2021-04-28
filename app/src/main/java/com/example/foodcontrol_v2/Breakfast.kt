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

        val p : ArrayList<String>


        if (getFileStreamPath(BREAKFAST_FILE_NAME).exists()) {
            Log.d(TAG, "file exists")
            val fis: FileInputStream = this.openFileInput(BREAKFAST_FILE_NAME)
            val hm = ObjectInputStream(fis)
            p = hm.readObject() as ArrayList<String>
            hm.close()
            fis.close()
        } else {
            Log.d(TAG, "file not exists")
            p = arrayListOf()
        }

        prod = ArrayList()

        try {
            var extras = intent.extras!!
            var product = extras.getString("item")
            var desc = extras.getString("itemdesc")
            p.add(product.toString())
            products.add(product.toString())
            prod.add(Product(product.toString(), desc.toString()))
        }
        catch (e: Exception)
        {
            Toast.makeText(this, "Данные не были получены", Toast.LENGTH_LONG).show()
        }







        showData()


//        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, p)
//
//        listProducts.adapter = adapter


        listProducts.setOnItemClickListener { parent, view, position, id ->


            val builder = AlertDialog.Builder(this)
            builder.setTitle("Убрать продукт?")
            builder.setMessage("Вы точно хотите убрать продукт из списка?")
            //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                p.removeAt(position)
                val fos: FileOutputStream = this.openFileOutput(BREAKFAST_FILE_NAME, Context.MODE_PRIVATE)
                val os = ObjectOutputStream(fos)
                os.writeObject(p)
                os.close()
                fos.close()

                showData()

                Toast.makeText(applicationContext,
                    "Продукт успешно удален из списка", Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(applicationContext,
                    "Вы отменили удаление", Toast.LENGTH_SHORT).show()
            }


            builder.show()




        }






        val fos: FileOutputStream = this.openFileOutput(BREAKFAST_FILE_NAME, Context.MODE_PRIVATE)
        val os = ObjectOutputStream(fos)
        os.writeObject(p)
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