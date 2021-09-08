package com.sudip.hotelaide.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sudip.hotelaide.R
import com.sudip.hotelaide.adapter.FragmentAdapter
import com.sudip.hotelaide.fragments.CheckoutFragment
import com.sudip.hotelaide.fragments.DashboardFragment


class TabActivity : AppCompatActivity() {

    private lateinit var lstTitle: ArrayList<String>
    private lateinit var lstFragments:ArrayList<Fragment>

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val tabIcons = intArrayOf(
        R.drawable.ic_home,
        R.drawable.ic_home,
        R.drawable.ic_logout
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        viewPager=findViewById(R.id.viewPager)
        tabLayout=findViewById(R.id.tabLayout)

        setupTabIcons()

        populateList()



        val adapter= FragmentAdapter(lstFragments,supportFragmentManager,lifecycle)
        viewPager.adapter=adapter
        TabLayoutMediator(tabLayout,viewPager){tab,position ->



        }.attach()
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_home)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_logout)


    }
    private fun populateList() {
        lstTitle = ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Streaming")
        lstTitle.add("Checkout")


        lstFragments = ArrayList<Fragment>()
        lstFragments.add(DashboardFragment())
//        lstFragments.add(StreamingFragment())
        lstFragments.add(CheckoutFragment())

    }
    private fun setupTabIcons() {

    }



}