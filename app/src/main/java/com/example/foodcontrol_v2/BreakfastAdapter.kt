package com.example.foodcontrol_v2

import android.R
import android.R.attr.name
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.foodcontrol_v2.fragments.Data


class ProductAdapter(private var activity: Context, private var items: ArrayList<Product>): BaseAdapter() {


    lateinit var modellist: ArrayList<Product>
    lateinit var arrayList: ArrayList<Product>

    lateinit var inflater: LayoutInflater


    fun ListViewAdapter(context: Context, modellist: List<Product>) {
        this.modellist = modellist as ArrayList<Product>
        inflater = LayoutInflater.from(context)
        arrayList = ArrayList<Product>()
        arrayList.addAll(modellist)


    }


    private class ViewHolder(row: View?) {
        lateinit var txtName: TextView
        lateinit var descName: TextView


        init {


            this.txtName = row!!.findViewById<TextView>(com.example.foodcontrol_v2.R.id.titleProduct)
            this.descName = row!!.findViewById<TextView>(com.example.foodcontrol_v2.R.id.descProduct)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater =
                activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(com.example.foodcontrol_v2.R.layout.breakfast_custom, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var userDto = items[position]
        viewHolder.txtName?.text = userDto.getText()
        viewHolder.descName?.text = userDto.getCheck()

        return view as View
    }


    override fun getItem(i: Int): Product {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}
data class Product( var title:String, var description: String) {
    fun getText(): String {
        return title
    }

    fun setText(text: String) {
        this.title = text
    }

    fun getCheck(): String {
        return description
    }

    fun setCheck(check: String) {
        this.description = check
    }
}
