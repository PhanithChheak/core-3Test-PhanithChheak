package com.phanith.core_3_phanithchheak

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),ExampleAdapter.OnItemClickListener {

    private val data = mutableListOf<ExampleItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //read file
        val readfile = resources.openRawResource(R.raw.medallists).bufferedReader()
        readfile.readLine() //ignore headers
        readfile.forEachLine {
            val temp = it.split(",")
            val item = ExampleItem(
                R.drawable.ic_baseline_1k_plus_24,
                temp[0],
                temp[1],
                temp[2].toInt(),
                temp[3].toInt(),
                temp[4].toInt()
            )
            data.add(item)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ExampleAdapter(data,this)
        //layout manager are responsible for position item into the recycle view
        recyclerView.layoutManager = LinearLayoutManager(this)
        // add some optimization
        recyclerView.setHasFixedSize(true)
    }

    override fun OnItemClick(position: Int) {
        saveData(data[position])
    }

    // save data to the file
    fun saveData(item: ExampleItem) {
        val sharepref = this.getSharedPreferences("data", Context.MODE_PRIVATE) ?: return
        sharepref.edit().apply {
            putString("name", item.text1)
            putString("code", item.text2)
        }.apply()
        btmfragpass(item)
    }

    private fun btmfragpass(item: ExampleItem): ToastbarSnack
    {
        val btmfrag = ToastbarSnack()
        val bundle = Bundle()
        bundle.putSerializable("data", item)
        btmfrag.arguments = bundle
        btmfrag.show(supportFragmentManager, "BottomSheetDialog")
        return btmfrag
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE", "onStop")
    }

   // Menu inflater
   override fun onCreateOptionsMenu(menu: Menu): Boolean {
       val inflater: MenuInflater = menuInflater
       inflater.inflate(R.menu.menuitem, menu)
       return true
   }


    // handling events for menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.item_detail -> {
                Log.i("intent information","intent function run")
                val i = Intent(this, ItemDetail::class.java)
                startActivity(i)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}




