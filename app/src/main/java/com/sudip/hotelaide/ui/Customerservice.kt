package com.sudip.hotelaide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.sudip.hotelaide.R
import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.entity.CustomerService
import com.sudip.hotelaide.entity.Service
import com.sudip.hotelaide.repository.UserRepository
import kotlinx.coroutines.*

class Customerservice : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var msg:EditText
    private lateinit var btnmsg:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customerservice)
        toolbar = findViewById(R.id.toolbar)
        msg = findViewById(R.id.msg)
        btnmsg = findViewById(R.id.btnmsg)
        btnmsg.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val msg=msg.text.toString()
                val send= CustomerService(roomno = ServiceBuilder.roomno,message = msg)
                try {
                    val repository = UserRepository()
                    val response = repository.sendMessage(send)
                    if (response.message == "success") {

                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@Customerservice,
                                "Message sent",
                                Toast.LENGTH_LONG
                            ).show()
                            delay(400)
                            startActivity(
                                Intent(
                                    this@Customerservice,
                                    TabActivity::class.java
                                )
                            )
                            finish()
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            val toast: Toast = Toast.makeText(
                                this@Customerservice,
                                "Try Again",
                                Toast.LENGTH_LONG
                            )
                        }
                    }
                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@Customerservice,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

        }




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
}