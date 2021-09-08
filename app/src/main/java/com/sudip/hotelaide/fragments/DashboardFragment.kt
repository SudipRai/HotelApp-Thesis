package com.sudip.hotelaide.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sudip.hotelaide.R
import com.sudip.hotelaide.ui.DashboardActivity
import com.sudip.hotelaide.ui.LoginActivity
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.sudip.hotelaide.ui.FoodActivity
import com.sudip.hotelaide.ui.StreamActivity


class DashboardFragment : Fragment() {
    private lateinit var navView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var food:CardView
    private lateinit var service:CardView
    private lateinit var stream:CardView

    private var sampleImage = intArrayOf(R.drawable.slide, R.drawable.slide1, R.drawable.slide2)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_dashboard, container, false)
        navView=view.findViewById(R.id.navView)
        food=view.findViewById(R.id.food)
        service=view.findViewById(R.id.service)
        stream=view.findViewById(R.id.stream)

        food.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    FoodActivity::class.java
                )
            )
        }
        stream.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    StreamActivity::class.java
                )
            )
        }
        service.setOnClickListener {
            startActivity(
                Intent(
                    context,
                    DashboardActivity::class.java
                )
            )
        }

        drawerLayout = view.findViewById(R.id.drawerLayout)

        val carouselView = view.findViewById<CarouselView>(R.id.carouselView);
        carouselView.pageCount = sampleImage.size;
        carouselView.setImageListener(imageListener);

       return view
    }
    var imageListener: ImageListener =
        ImageListener { position, imageView ->
            imageView.setImageResource(sampleImage[position])
        }





}