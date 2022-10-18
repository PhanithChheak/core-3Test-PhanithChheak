package com.phanith.core_3_phanithchheak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter require list of data to bind to the view holder
class ExampleAdapter(private val exampleList: List<ExampleItem>): RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView1: TextView = itemView.findViewById(R.id.test_view_1)
        val textView2: TextView = itemView.findViewById(R.id.test_view_2)

    }
    // the function will call to create and object for the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
    //xml layout(itemView) are blueprint, to use the layout we have to create view object
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false)
        return ExampleViewHolder(itemView)
    }

    // function will be call many time as we scroll, due to binding the data to the view holder
    //holder are the recycle data that need to put into view and position is to identify each data
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

    }
    // this function need to know how many data are in the list
    override fun getItemCount() = exampleList.size


}