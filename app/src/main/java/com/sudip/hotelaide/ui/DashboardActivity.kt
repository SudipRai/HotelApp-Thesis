package com.sudip.hotelaide.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.RelativeLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.sudip.hotelaide.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class DashboardActivity : AppCompatActivity() {

    private lateinit var navView: NavigationView
    private lateinit var drawerLayout: DrawerLayout
    public lateinit var toogle: ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar
    private var sampleImage = intArrayOf(R.drawable.slide, R.drawable.slide1, R.drawable.slide2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        navView=findViewById(R.id.navView)
        drawerLayout = findViewById(R.id.drawerLayout)
        toolbar=findViewById(R.id.toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout,toolbar, 0, 0
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home->{
                    startActivity(
                        Intent(this,
                            DashboardActivity::class.java)
                    )
                }
                R.id.nav_Profile->{
                    startActivity(
                        Intent(this,
                            DashboardActivity::class.java)
                    )
                }
                R.id.nav_viewmytickets->{
                    startActivity(
                        Intent(this,
                            DashboardActivity::class.java)
                    )
                }
                R.id.nav_addticket->{
                    startActivity(
                        Intent(this,
                            DashboardActivity::class.java)
                    )
                }
                R.id.nav_logout->{
                    startActivity(
                        Intent(this,
                            LoginActivity::class.java)
                    )
                    finish()
                }
            }
            true
        }

        val carouselView = findViewById<CarouselView>(R.id.carouselView);
        carouselView.pageCount = sampleImage.size;
        carouselView.setImageListener(imageListener);
    }
    var imageListener: ImageListener =
        ImageListener { position, imageView ->
            imageView.setImageResource(sampleImage[position])
        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}