package com.techun.twitterui.ui.drawerNavigationView.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.techun.twitterui.databinding.ActivityTopicsBinding
import com.techun.twitterui.ui.drawerNavigationView.ui.adapters.topics.ViewPagerTopicsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopicsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.iToolbar.topAppBar)
        supportActionBar?.title = "Topics"
        binding.iToolbar.topAppBar.setNavigationOnClickListener { finish() }

        setupTabLayout()
        setupViewPager()

    }

    private fun setupViewPager() = binding.viewPager.apply {
        adapter = ViewPagerTopicsAdapter(supportFragmentManager, binding.tabLayout.tabCount)
        addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
    }

    private fun setupTabLayout() = binding.tabLayout.apply {
        addTab(this.newTab().setText("Followed"))
        addTab(this.newTab().setText("Suggested"))
        addTab(this.newTab().setText("Not Interested"))
        tabGravity = TabLayout.GRAVITY_FILL

        addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let {
                    binding.viewPager.currentItem = it
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

}