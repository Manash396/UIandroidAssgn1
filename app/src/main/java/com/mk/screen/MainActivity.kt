package com.mk.screen

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.mk.screen.R.id.stockListRecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//
        val checkDrawable  = ContextCompat.getDrawable(this,R.drawable.baseline_check_24)
        val buttonToggle = findViewById<MaterialButtonToggleGroup>(R.id.viewToggle)


        val tableBtn = findViewById<MaterialButton>(R.id.viewTableBtn)

        val listBtn = findViewById<MaterialButton>(R.id.viewListBtn)
        // layouts for table and list

        val listLayout = findViewById<LinearLayout>(R.id.listContainer)
        val tableLayout = findViewById<LinearLayout>(R.id.tableContainer)

// by default table button checked and also chedked icon
        tableBtn.icon =checkDrawable
        tableBtn.isChecked = true
        buttonToggle.addOnButtonCheckedListener { _ ,isCheckedId , isChecked -> 
            if (isChecked){
                 when(isCheckedId){
                     R.id.viewTableBtn -> {
                         tableBtn.icon = checkDrawable
                         listBtn.icon = null
                          listLayout.visibility = View.INVISIBLE
                          tableLayout.visibility = View.VISIBLE
                     }

                     R.id.viewListBtn -> {
                         listBtn.icon = checkDrawable
                         tableBtn.icon = null
                         listLayout.visibility = View.VISIBLE
                         tableLayout.visibility = View.INVISIBLE
                     }

                 }
            }
        }


        val spinner  =  findViewById<Spinner>(R.id.stockSpinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.products_list,
            R.layout.text
        ).also{
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            spinner.adapter = adapter
        }

// setting adapter for table stock
        val recyclerViewTable = findViewById<RecyclerView>(R.id.stockTableRecycler)
        val sampleData = listOf(
                StockTable("10 Jan 2025", "20 pcs", "20 pcs"),
                StockTable("09 Jan 2025", "30 pcs", "30 pcs"),
                StockTable("08 Jan 2025", "10 pcs", "10 pcs"),
                StockTable("10 Jan 2025", "20 pcs", "20 pcs"),
                StockTable("09 Jan 2025", "30 pcs", "30 pcs"),
                StockTable("08 Jan 2025", "10 pcs", "10 pcs")
        )

        recyclerViewTable.layoutManager  = LinearLayoutManager(this)
        recyclerViewTable.adapter = AdapterTable(
            sampleData
        )



//         setting adapter class for list view

        val stockItems = listOf(
            StockList("Cloth Wash Soap", "85", "1.0", "44.0", "40"),
            StockList("Laptop", "120", "60", "55", "5"),
            StockList("Rice Bag 25kg", "300", "270", "28", "2"),
            StockList("LED Bulb", "500", "480", "15", "5"),
            StockList("Plastic Chair", "150", "100", "40", "10"),
            StockList("Notebook Pack", "250", "220", "25", "5")
        )

        val recyclerViewList = findViewById<RecyclerView>(stockListRecyclerView)
        recyclerViewList.layoutManager = LinearLayoutManager(this)

        recyclerViewList.adapter = AdapterList(stockList = stockItems)



//         setting listener on item selected
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View, position: Int, id: Long
            ) {
                val selected = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selected: $selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }

    }
}