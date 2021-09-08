package com.sudip.hotelaide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.GridLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.sudip.hotelaide.R
import com.sudip.hotelaide.adapter.ServiceAdapter
import com.sudip.hotelaide.entity.Service
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class DashboardActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private var lstActors=ArrayList<Service>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        toolbar = findViewById(R.id.toolbar)



        drawerLayout = findViewById(R.id.drawerLayout)
        navView=findViewById(R.id.navView)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.drawerArrowDrawable.setColor(getResources().getColor(R.color.white));
        recyclerView=findViewById(R.id.recyclerView)
        loadActors()
        val adapter=ServiceAdapter(lstActors,this)
        recyclerView.layoutManager= GridLayoutManager(this,2)
        recyclerView.adapter=adapter



        }
    private fun loadActors() {
        lstActors.add(Service( "Water",
            "https://www.bostonherald.com/wp-content/uploads/migration/2014/07/03/070414waterbottle.jpg?w=1024"))
        lstActors.add(
            Service("Shaving Kit",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/the-best-shave-kit-for-men-1574338820.jpg?crop=0.502xw:1.00xh;0.498xw,0&resize=640:*")
        )
        lstActors.add(Service("TV Accessories",
            "data:image/png;base64,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"))
        lstActors.add(
            Service("Dental Kit",
            "https://cpimg.tistatic.com/02938922/b/4/Hotel-Dental-Kit.jpg"))
        lstActors.add(Service( "Towel",
            "data:image/jpeg;base64,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"))
        lstActors.add(
            Service("Laundary Service",
                "https://image.flaticon.com/icons/png/512/100/100450.png")
        )
        lstActors.add(Service("Clean My Room",
            "https://img.flaticon.com/icons/png/512/66/66241.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF"))
        lstActors.add(
            Service("BathRoom Accessories",
                "https://cdn.iconscout.com/icon/premium/png-256-thumb/bathroom-accessories-2495089-2180448.png"))
        lstActors.add(Service("Call Taxi",
            "https://image.flaticon.com/icons/png/512/89/89131.png"))
        lstActors.add(
            Service("Others",
                "data:image/png;base64,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"))
    }

    }
