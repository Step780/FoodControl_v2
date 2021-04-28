package com.example.foodcontrol_v2.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodcontrol_v2.Breakfast
import com.example.foodcontrol_v2.R
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.FileAsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import jxl.Workbook
import jxl.WorkbookSettings
import jxl.read.biff.BiffException
import java.io.File
import java.io.IOException
import java.util.*


class FoodSearch : AppCompatActivity() {

    lateinit var asyncHttpClient: AsyncHttpClient
    lateinit var workbook: Workbook
    var test = ArrayList<Data>()
    lateinit var listView: ListView
    lateinit var adapter: ListViewAdapter
    lateinit var edtSearch: SearchView
    lateinit var watcher: TextWatcher






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_food)
        val url = "https://github.com/Step780/Food/blob/main/Table2.xls?raw=true"
        listView = findViewById<ListView>(R.id.viewFood)
        test = ArrayList()


        listView.setOnItemClickListener { parent, view, position, id ->


            val item = parent.getItemAtPosition(position) as Data



            startActivity(Intent(this, Breakfast::class.java)
                .apply {
                    putExtra("item", item.title.toString())
                    putExtra("itemdesc", item.description.toString())

                })



        }


        asyncHttpClient = AsyncHttpClient()
        asyncHttpClient[url, object : FileAsyncHttpResponseHandler(this) {
            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                throwable: Throwable,
                file: File
            ) {
                Toast.makeText(
                    this@FoodSearch,
                    "Error in Downloading Excel File",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                file: File
            ) {
                val ws = WorkbookSettings()
                ws.gcDisabled = true
                if (file != null) {
                    //text.setText("Success, DO something with the file.");
                    try {
                        workbook = Workbook.getWorkbook(file)
                        val sheet = workbook.getSheet(0)
                        //Cell[] row = sheet.getRow(1);
                        //text.setText(row[0].getContents());
                        for (i in 0 until sheet.rows) {
                            val row = sheet.getRow(i)

                            test.add(Data(row[0].contents, row[1].contents))
                            showData()
                            filterText()


                        }

                    } catch (e: IOException) {
                        e.printStackTrace()
                    } catch (e: BiffException) {
                        e.printStackTrace()
                    }
                }
            }
        }]


    }


    fun showData()
    {
        adapter = ListViewAdapter(this, test)
        listView.adapter = adapter





    }

    fun filterText()
    {

        edtSearch = findViewById(R.id.edtSearch)
        edtSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                if (TextUtils.isEmpty(s)) {
                    filter("")
                    listView.clearTextFilter()
                } else {
                    filter(s)
                }
                return true
            }
        })
    }
    lateinit var modellist: ArrayList<Data>
    lateinit var arrayList: ArrayList<Data>

    fun filter(charText: String) {
        modellist = arrayListOf<Data>()
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())

        modellist.clear()
        if (charText.length == 0) {

            modellist.addAll(test)
        } else {
            for (model in test) {
                if (model.getText().toLowerCase(Locale.getDefault())
                        .contains(charText)
                ) {
                    modellist.add(model)
                }
            }
        }
        adapter = ListViewAdapter(this, modellist)
        listView.adapter = adapter
    }






}


