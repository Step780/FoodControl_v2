package com.example.foodcontrol_v2.fragments


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.foodcontrol_v2.Product
import com.example.foodcontrol_v2.R
import kotlin.collections.ArrayList


class ListViewAdapter(private var activity: Context, private var items: ArrayList<Data>): BaseAdapter() {


    lateinit var modellist: ArrayList<Data>
    lateinit var arrayList: ArrayList<Data>

    lateinit var inflater: LayoutInflater


    fun ListViewAdapter(context: Context, modellist: List<Data>) {
        this.modellist = modellist as ArrayList<Data>
        inflater = LayoutInflater.from(context)
        arrayList = ArrayList<Data>()
        arrayList.addAll(modellist)


    }


    private class ViewHolder(row: View?) {
        lateinit var txtName: TextView
        lateinit var descName: TextView


        init {


            this.txtName = row!!.findViewById<TextView>(R.id.title)
            this.descName = row!!.findViewById<TextView>(R.id.desc)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater =
                activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.search_custom, null)
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


    override fun getItem(i: Int): Data {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}
data class Data( var title:String, var description: String)
{
    fun getText(): String
    {
        return title
    }

    fun setText(text:String)
    {
        this.title = text
    }

    fun getCheck(): String
    {
        return description
    }

    fun setCheck(check: String)
    {
        this.description = check
    }
}