package com.sudip.hotelaide.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sudip.hotelaide.R
import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.entity.Service
import com.sudip.hotelaide.repository.UserRepository
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ServiceAdapter(
    val lstServise:ArrayList<Service>,
    val context: Context

) : RecyclerView.Adapter<ServiceAdapter.ActivityViewHolder>() {
    class ActivityViewHolder(view: View):
        RecyclerView.ViewHolder(view){
        val image: ImageView
        val name: TextView
        val services: CardView

        init{
            image=view.findViewById(R.id.image)
            name=view.findViewById(R.id.name)
            services=view.findViewById(R.id.services)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.merolayout,parent,false)
        return ActivityViewHolder((view))
    }



    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val service=lstServise[position]
        holder.name.text=service.name
        Glide.with(context)
            .load(service.image)
            .into(holder.image)

        holder.services.setOnClickListener {

                val builder = AlertDialog.Builder(context)
                builder.setTitle("Request Service")
                builder.setMessage("Confirm Request??")
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                builder.setPositiveButton("Yes") { _, _ ->
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val serv=Service(name = service.name,roomno = ServiceBuilder.roomno)
                            val repository = UserRepository()
                            val response = repository.Addservice(serv)
                            if (response.message == "success") {

                                withContext(Dispatchers.Main) {
                                    Toast.makeText(
                                        context,
                                        "Order Placed",
                                        Toast.LENGTH_LONG
                                    ).show()
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


    }
    override fun getItemCount(): Int {
        return lstServise.size
    }
}