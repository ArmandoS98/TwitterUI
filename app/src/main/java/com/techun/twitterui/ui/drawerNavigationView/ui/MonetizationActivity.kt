package com.techun.twitterui.ui.drawerNavigationView.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.databinding.ActivityMonetizationBinding
import com.techun.twitterui.ui.drawerNavigationView.ui.adapters.monetization.MonetizationAdapter
import com.techun.twitterui.utils.FakeData.monetizationGetHelpListData
import com.techun.twitterui.utils.FakeData.monetizationOptionsListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MonetizationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMonetizationBinding

    @Inject
    lateinit var monetizationAdapter: MonetizationAdapter

    @Inject
    lateinit var monetizationGetHelpAdapter: MonetizationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMonetizationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.iToolbar.topAppBar)
        supportActionBar?.title = "Monetization"
        binding.iToolbar.topAppBar.setNavigationOnClickListener { finish() }

        init()
        recyclerInit()
    }

    private fun init() {
        monetizationAdapter.submitList(monetizationOptionsListData.shuffled())
        monetizationGetHelpAdapter.submitList(monetizationGetHelpListData.shuffled())
    }

    private fun recyclerInit() {
        binding.rvMonetizationOptions.apply {
            adapter = monetizationAdapter
            layoutManager =
                LinearLayoutManager(this@MonetizationActivity, LinearLayout.VERTICAL, false)
        }

        binding.rvGetHelp.apply {
            adapter = monetizationGetHelpAdapter
            layoutManager =
                LinearLayoutManager(this@MonetizationActivity, LinearLayout.VERTICAL, false)
        }
    }
}