package com.example.datastoragelab

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.datastoragelab1.R


class MainActivity : AppCompatActivity() {
    var counter = 0
    //инициализация
    var text1 = findViewById<TextView>(R.id.tvResult)
    var text = findViewById<TextView>(R.id.tvRes2)
    var test = "0"
    var pref : SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        counter = pref?.getInt("counter", 0)!!
        test = pref?.getString("test", "0")!!
        //tvResult.text = counter.toString()
        text1.text = counter.toString()
        text.text = test

    }

    fun onClickAdd(view: View)
    {
        counter++
        text1.text = counter.toString()
        saveData(counter)
    }
    //позволяет редактировать данные и помещаем ключ
    fun saveData(res: Int)
    {
        val editor = pref?.edit()
        editor?.putInt("counter",res)
        editor?.putString("test","Test")
        editor?.apply()
    }
    // функция для удаления из памяти
    fun deleteAll()
    {
        val editor = pref?.edit()
        editor?.clear()
        editor?.apply()
    }
    fun deleteItem(deleteItem: String)
    {
        val editor = pref?.edit()
        editor?.remove(deleteItem)
        editor?.apply()
    }
    override fun onDestroy()
    {
        super.onDestroy()
    }

    fun onClickClear(view: View)
    {
        deleteAll()
    }
    fun onClickDeleteItem(view: View)
    {
        deleteItem("counter")
    }
}