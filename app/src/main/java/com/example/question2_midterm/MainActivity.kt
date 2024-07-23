package com.example.question2_midterm

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val fName: EditText = findViewById(R.id.fName)
        val lName: EditText = findViewById(R.id.lName)
        val age: EditText = findViewById(R.id.age)
        val submit: Button = findViewById(R.id.submit)
        val result : TextView = findViewById(R.id.result)
        val spinner: Spinner = findViewById(R.id.spinner)

        var flag:String = "fName"
        var options = arrayOf("firstName","lastName","age")

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        submit.setOnClickListener{
            val fName: String = fName.text.toString()
            val lName: String = lName.text.toString()
            val age: Int = age.text.toString().toInt()

            when(flag) {
                "firstName" -> {
                    result.text = displayfName(fName)
                }
                "lastName" -> {
                    result.text = displaylName(lName)
                }
                "age" -> {
                    result.text = displayAge(age).toString()
                }

                else -> {
                    Toast.makeText(this,"None",Toast.LENGTH_SHORT).show()
                }
            }



        }


        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // You can leave this empty if there's no action on nothing selected
            }
        }

    }

    private fun displayfName(x:String) :String {
        return x;
    }

    private fun displaylName(y:String) :String {
        return y;
    }

    private fun displayAge(z:Int) : Int{
        return z
    }


}