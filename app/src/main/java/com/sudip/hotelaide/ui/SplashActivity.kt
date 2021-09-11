package com.sudip.hotelaide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sudip.hotelaide.R
import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.repository.UserRepository
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            getSharedPref()
            finish()
        }
    }
    fun getSharedPref() {
        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val roomno = sharedPref.getString("roomno", "")
        val password = sharedPref.getString("password", "")

        if (roomno != "") {

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val repository = UserRepository()
                    val response = repository.checkUser(roomno!!, password!!)
                    if (response.message == "success") {
                        ServiceBuilder.token = "Bearer ${response.token}"
                        ServiceBuilder.userID = response.data
                        ServiceBuilder.roomno = response.roomno
                        ServiceBuilder.fullname = response.fullname
                        startActivity(
                            Intent(
                                this@SplashActivity,
                                TabActivity::class.java
                            )
                        )

                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@SplashActivity,
                                "Error",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@SplashActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }


        } else {
            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )
        }
    }
}