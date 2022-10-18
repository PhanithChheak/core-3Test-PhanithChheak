package com.phanith.core_3_phanithchheak

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        val text1 = sharedPref.getString("text1","none").toString()




        val exampleList = readCsv(File("app/src/main/res/raw/medallists.csv").inputStream())
        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = ExampleAdapter(exampleList)
        //layout manager are responsible for position item into the recycle view
        recycler_view.layoutManager = LinearLayoutManager(this)
        // add some optimization
        recycler_view.setHasFixedSize(true)


    }


    fun readCsv(inputStream: InputStream): List<ExampleItem> {
        val reader = inputStream.bufferedReader()
        val header = reader.readLine()
        return reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val (text1, text2, int1,int2,int3,int4) = it.split(',', ignoreCase = false, limit = 6)
                val str = it.split(",").toTypedArray()
                ExampleItem(
                    R.drawable.ic_baseline_1k_plus_24,
                    str[0].trim(),
                    str[1].trim(),
                    str[2].trim().toInt(),
                    str[3].trim().toInt(),
                    str[4].trim().toInt(),
                    str[5].trim().toInt()
                )
            }.toList()
    }

    // save data to the file
    override fun onPause() {
        super.onPause()
        Log.i( "LIFECYCLE","OnPause")
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            val text1 = findViewById<TextView>(R.id.SelectedView)
            putString("text1",text1.text.toString())
            apply()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE","onStop")
    }





}




