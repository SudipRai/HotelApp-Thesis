package com.sudip.hotelaide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.sudip.hotelaide.R
import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    private lateinit var etname: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: MaterialButton
    private lateinit var dont: TextView
    private lateinit var linearlayout:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding()
        btnlogin.setOnClickListener {
            login()
        }
    }
    private fun validateInput(): Boolean {
        var res = true
        when {
            (TextUtils.isEmpty(etname.text)) -> {
                etname.error = "This field should not be empty"
                etname.requestFocus()
                res = false
            }

            (TextUtils.isEmpty(etpassword.text)) -> {
                etpassword.error = "This field should not be empty"
                etpassword.requestFocus()
                res = false
            }
        }
        return res
    }

    private fun login(){
        val roomno = etname.text.toString()
        val password = etpassword.text.toString()
        if(validateInput()) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val repository = UserRepository()
                    val response = repository.checkUser(roomno, password)
                    if (response.message == "success") {
                        saveSharedPref()
                        // dashboard khola
                        ServiceBuilder.token = "Bearer ${response.token}"
                        ServiceBuilder.userID = response.data
                        ServiceBuilder.roomno = response.roomno
                        ServiceBuilder.fullname = response.fullname
                            startActivity(
                                Intent(
                                    this@LoginActivity,
                                    TabActivity::class.java
                                )
                            )

                    }
                    else {
                        withContext(Dispatchers.Main) {

                            Toast.makeText(
                                this@LoginActivity,
                                "Invalid Credentials",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
    private fun binding(
    ) {
        etname = findViewById(R.id.etname)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)
        dont=findViewById(R.id.dont)
        linearlayout=findViewById(R.id.linearlayout)

    }
    private fun saveSharedPref() {
        val roomno = etname.text.toString()
        val password = etpassword.text.toString()


        val sharedPref = getSharedPreferences("MyPref",
            MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("roomno", roomno)
        editor.putString("password", password)

        editor.apply()
    }
}