package com.example.screa.androidapp1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ListView;
import android.app.Activity

import android.util.Log
import java.nio.file.Files.size
import android.util.SparseBooleanArray
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent




class playback : AppCompatActivity(),OnClickListener {

    internal val LOG_TAG = "myLogs"
    internal var list: ListView? = null
    internal var items: Array<String>? = null
    private var butt: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playback)
        list = findViewById<ListView>(R.id.list_ch)
        list!!.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        val adapter = ArrayAdapter.createFromResource(
                this, R.array.items,
                android.R.layout.simple_list_item_multiple_choice)
        list!!.adapter = adapter

        val btnChecked = findViewById<Button>(R.id.btnChecked)
        btnChecked.setOnClickListener(this)

        // получаем массив из файла ресурсов
        items = resources.getStringArray(R.array.items)
    }

    /*btnChecked!!.setOnClickListener {

            Log.d(LOG_TAG, "checked: " + items!![list!!.checkedItemPosition])

        }*/
    /* override fun onClick(  arg0:View?) {
            // пишем в лог выделенный элемент
            Log.d(LOG_TAG, "checked: " + items!![list!!.getCheckedItemPosition()]);
        }*/
    override fun onClick(arg0: View) {
        // пишем в лог выделенные элементы
        Log.d(LOG_TAG, "checked: ")
        val sbArray = list!!.getCheckedItemPositions()
        var sendler = mutableListOf<String>()
        for (i in 0 until sbArray!!.size()) {
            val key = sbArray.keyAt(i)
            if (sbArray.get(key)) {
                Log.d(LOG_TAG, items!![key])
                sendler!!.add(items!![key])
                Log.d(LOG_TAG, sendler.toString())
            }

        }
        //val send = arrayOfNulls<String>(sendler.size)
        Log.d(LOG_TAG, "send size: ")

        val send = sendler.toTypedArray()




        val intent = Intent(this, MainActivity::class.java)
        if (send.size == 1) {
            intent.putExtra("s_1", send[0])
            startActivity(intent)

        }
        else {
            if (send.size == 2) {
                intent.putExtra("s_1", send[0])
                intent.putExtra("s_2", send[1])
                startActivity(intent)
            }
        }

    }
    }





