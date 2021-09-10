package com.sudip.hotelaide.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sudip.hotelaide.R
import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.entity.Food
import com.sudip.hotelaide.entity.Service
import com.sudip.hotelaide.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FoodActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var btnminus:Button
    private lateinit var btnplus:Button
    private lateinit var num:TextView
    private lateinit var confirm:ImageView
    private lateinit var btnminus1:Button
    private lateinit var btnplus1:Button
    private lateinit var num1:TextView
    private lateinit var confirm1:ImageView
    private lateinit var btnminus2:Button
    private lateinit var btnplus2:Button
    private lateinit var num2:TextView
    private lateinit var confirm2:ImageView
    private lateinit var btnminus3:Button
    private lateinit var btnplus3:Button
    private lateinit var num3:TextView
    private lateinit var confirm3:ImageView
    private lateinit var btnminus4:Button
    private lateinit var btnplus4:Button
    private lateinit var num4:TextView
    private lateinit var confirm4:ImageView
    private lateinit var btnminus5:Button
    private lateinit var btnplus5:Button
    private lateinit var num5:TextView
    private lateinit var confirm5:ImageView


    //private lateinit var toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        binding()


        btnplus.setOnClickListener {
           val newnum= num.text.toString().toInt()+1
            num.setText(newnum.toString())
        }
        btnminus.setOnClickListener {
            val newnum=num.text.toString().toInt() - 1
            num.setText(newnum.toString())
        }
        confirm.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Food Order")
            builder.setMessage("Confirm Order??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                val total = num.text.toString().toInt() * 200
                val food = Food(
                    roomno = ServiceBuilder.roomno,
                    foodname = "Burger",
                    number = num.text.toString(),
                    total = total.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = UserRepository()
                        val response = repository.foodOrder(food)
                        if (response.message == "success") {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@FoodActivity,
                                    "Food Ordered",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                val toast: Toast = Toast.makeText(
                                    this@FoodActivity,
                                    "Try Again",
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@FoodActivity,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }


        btnplus1.setOnClickListener {
            val newnum= num1.text.toString().toInt()+1
            num1.setText(newnum.toString())
        }
        btnminus1.setOnClickListener {
            val newnum=num1.text.toString().toInt() - 1
            num1.setText(newnum.toString())
        }
        confirm1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Food Order")
            builder.setMessage("Confirm Order??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                val total = num1.text.toString().toInt() * 100
                val food = Food(
                    roomno = ServiceBuilder.roomno,
                    foodname = "French Fry",
                    number = num1.text.toString(),
                    total = total.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = UserRepository()
                        val response = repository.foodOrder(food)
                        if (response.message == "success") {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@FoodActivity,
                                    "Food Ordered",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                val toast: Toast = Toast.makeText(
                                    this@FoodActivity,
                                    "Try Again",
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@FoodActivity,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }


        btnplus2.setOnClickListener {
            val newnum= num2.text.toString().toInt()+1
            num2.setText(newnum.toString())
        }
        btnminus2.setOnClickListener {
            val newnum=num2.text.toString().toInt() - 1
            num2.setText(newnum.toString())
        }
        confirm2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Food Order")
            builder.setMessage("Confirm Order??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                val total = num2.text.toString().toInt() * 120
                val food = Food(
                    roomno = ServiceBuilder.roomno,
                    foodname = "Chowmein",
                    number = num2.text.toString(),
                    total = total.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = UserRepository()
                        val response = repository.foodOrder(food)
                        if (response.message == "success") {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@FoodActivity,
                                    "Food Ordered",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                val toast: Toast = Toast.makeText(
                                    this@FoodActivity,
                                    "Try Again",
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@FoodActivity,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        btnplus3.setOnClickListener {
            val newnum= num3.text.toString().toInt()+1
            num3.setText(newnum.toString())
        }
        btnminus3.setOnClickListener {
            val newnum=num3.text.toString().toInt() - 1
            num3.setText(newnum.toString())
        }
        confirm3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Food Order")
            builder.setMessage("Confirm Order??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                val total = num3.text.toString().toInt() * 500
                val food = Food(
                    roomno = ServiceBuilder.roomno,
                    foodname = "Nepali Khana",
                    number = num3.text.toString(),
                    total = total.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = UserRepository()
                        val response = repository.foodOrder(food)
                        if (response.message == "success") {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@FoodActivity,
                                    "Food Ordered",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                val toast: Toast = Toast.makeText(
                                    this@FoodActivity,
                                    "Try Again",
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@FoodActivity,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }


        btnplus4.setOnClickListener {
            val newnum= num4.text.toString().toInt()+1
            num4.setText(newnum.toString())
        }
        btnminus4.setOnClickListener {
            val newnum=num4.text.toString().toInt() - 1
            num4.setText(newnum.toString())
        }
        confirm4.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Food Order")
            builder.setMessage("Confirm Order??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                val total = num4.text.toString().toInt() * 400
                val food = Food(
                    roomno = ServiceBuilder.roomno,
                    foodname = "Pizza",
                    number = num4.text.toString(),
                    total = total.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = UserRepository()
                        val response = repository.foodOrder(food)
                        if (response.message == "success") {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@FoodActivity,
                                    "Food Ordered",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                val toast: Toast = Toast.makeText(
                                    this@FoodActivity,
                                    "Try Again",
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@FoodActivity,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        btnplus5.setOnClickListener {
            val newnum= num5.text.toString().toInt()+1
            num5.setText(newnum.toString())
        }
        btnminus5.setOnClickListener {
            val newnum=num5.text.toString().toInt() - 1
            num5.setText(newnum.toString())
        }
        confirm5.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Food Order")
            builder.setMessage("Confirm Order??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                val total = num5.text.toString().toInt() * 200
                val food = Food(
                    roomno = ServiceBuilder.roomno,
                    foodname = "Kathi Roll",
                    number = num5.text.toString(),
                    total = total.toString()
                )
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val repository = UserRepository()
                        val response = repository.foodOrder(food)
                        if (response.message == "success") {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@FoodActivity,
                                    "Food Ordered",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                val toast: Toast = Toast.makeText(
                                    this@FoodActivity,
                                    "Try Again",
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@FoodActivity,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        toolbar = findViewById(R.id.title)
        drawerLayout = findViewById(R.id.drawerLayout)
        navView=findViewById(R.id.navView)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.drawerArrowDrawable.setColor(getResources().getColor(R.color.white));


    }

    private fun binding(){
        btnminus=findViewById(R.id.btnminus)
        btnplus=findViewById(R.id.btnplus)
        num=findViewById(R.id.num)
        confirm=findViewById(R.id.confirm)
        btnminus1=findViewById(R.id.btnminus1)
        btnplus1=findViewById(R.id.btnplus1)
        num1=findViewById(R.id.num1)
        confirm1=findViewById(R.id.confirm1)
        btnminus2=findViewById(R.id.btnminus2)
        btnplus2=findViewById(R.id.btnplus2)
        num2=findViewById(R.id.num2)
        confirm2=findViewById(R.id.confirm2)
        btnminus3=findViewById(R.id.btnminus3)
        btnplus3=findViewById(R.id.btnplus3)
        num3=findViewById(R.id.num3)
        confirm3=findViewById(R.id.confirm3)
        btnminus4=findViewById(R.id.btnminus4)
        btnplus4=findViewById(R.id.btnplus4)
        num4=findViewById(R.id.num4)
        confirm4=findViewById(R.id.confirm4)
        btnminus5=findViewById(R.id.btnminus5)
        btnplus5=findViewById(R.id.btnplus5)
        num5=findViewById(R.id.num5)
        confirm5=findViewById(R.id.confirm5)
    }



    }
