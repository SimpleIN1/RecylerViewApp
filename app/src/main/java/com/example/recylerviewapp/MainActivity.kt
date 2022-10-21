package com.example.recylerviewapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = mutableListOf<Int>()

        adapter = RecyclerAdapter(list){
            list.removeAt(it)
            adapter.notifyItemRemoved(it)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val button = findViewById<Button>(R.id.button2)
        val textEdit = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if(textEdit.text.toString()!=""){
                list.add(textEdit.text.toString().toInt())
                adapter.notifyItemInserted(list.lastIndex)
                textEdit.text = null
            }
        }

        val radioGroup =  findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.radioButton ->{
                    adapter.updateList(list.filter { it%2==0 })
                    adapter.run { notifyDataSetChanged() }
                    Log.d("check", "0")
                }
                R.id.radioButton2 ->{
                    adapter.updateList(list.filter { it%2!=0 })
                    adapter.run { notifyDataSetChanged() }
                    Log.d("check", "1")
                }
                R.id.radioButton3 ->{
                    adapter.updateList(list)
                    adapter.run { notifyDataSetChanged() }
                    Log.d("check", "2")
                }
            }
        }


    }

}