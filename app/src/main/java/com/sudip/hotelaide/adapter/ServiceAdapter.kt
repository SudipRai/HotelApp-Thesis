package com.sudip.hotelaide.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sudip.hotelaide.R
import com.sudip.hotelaide.entity.Service
import de.hdodenhof.circleimageview.CircleImageView

class ServiceAdapter(
    val lstServise:ArrayList<Service>,
    val context: Context

) : RecyclerView.Adapter<ServiceAdapter.ActivityViewHolder>() {
    class ActivityViewHolder(view: View):
        RecyclerView.ViewHolder(view){
        val image: ImageView
        val name: TextView

        init{
            image=view.findViewById(R.id.image)
            name=view.findViewById(R.id.name)


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
    }
    override fun getItemCount(): Int {
        return lstServise.size
    }
}