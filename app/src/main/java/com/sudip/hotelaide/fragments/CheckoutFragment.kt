package com.sudip.hotelaide.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.sudip.hotelaide.R
import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.entity.Checkout
import com.sudip.hotelaide.entity.CustomerService
import com.sudip.hotelaide.entity.Food
import com.sudip.hotelaide.entity.Service
import com.sudip.hotelaide.repository.UserRepository
import com.sudip.hotelaide.ui.FoodActivity
import com.sudip.hotelaide.ui.TabActivity
import kotlinx.coroutines.*


class CheckoutFragment : Fragment() {
private lateinit var roomno:TextView
private lateinit var name:TextView
private lateinit var pricefood:TextView
private lateinit var roomcharge:TextView
private lateinit var scharge:TextView
private lateinit var total:TextView
private lateinit var btnreq:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_checkout, container, false)
        roomno=view.findViewById(R.id.roomno)
        name=view.findViewById(R.id.name)
        pricefood=view.findViewById(R.id.pricefood)
        roomcharge=view.findViewById(R.id.roomcharge)
        scharge=view.findViewById(R.id.scharge)
        total=view.findViewById(R.id.total)
        btnreq=view.findViewById(R.id.btnreq)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.getmyFood(ServiceBuilder.roomno!!)
                if (response.message == "success") {
                    var foodp=""
                    var totals=response.data!!
                    for (i in totals){
                        pricefood.setText(i.total)
                        foodp=i.total!!
                    }
                    roomcharge.setText("1000")
                    var charge=(foodp.toInt()+1000)/10
                    scharge.setText(charge.toString())
                    var totalp=foodp.toInt()+1000+charge
                    total.setText(totalp.toString())
                    roomno.setText(ServiceBuilder.roomno)
                    name.setText(ServiceBuilder.fullname)

                } else {
                    withContext(Dispatchers.Main) {
                        val toast: Toast = Toast.makeText(
                            context,
                            "Try Again",
                            Toast.LENGTH_LONG
                        )
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        ex.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        btnreq.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Checkout")
            builder.setMessage("Confirm Request??")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes") { _, _ ->
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val roomno=ServiceBuilder.roomno
                        val food=pricefood.text.toString()
                        val roomcharge=roomcharge.text.toString()
                        val serviccharge=scharge.text.toString()
                        val total=total.text.toString()

                        val checkout= Checkout(roomno=roomno,food=food,roomcharge=roomcharge,servicecharge=serviccharge,total=total  )
                        val repository = UserRepository()
                        val response = repository.checkout(checkout)
                        if (response.message == "success") {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    context,
                                    "Checkout Requested",
                                    Toast.LENGTH_LONG
                                ).show()
                                delay(400)
                                startActivity(
                                    Intent(
                                        context,
                                        FoodActivity::class.java
                                    )
                                )
                                activity?.finish()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                val toast: Toast = Toast.makeText(
                                    context,
                                    "Try Again",
                                    Toast.LENGTH_LONG
                                )
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                context,
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





        return view
    }


}