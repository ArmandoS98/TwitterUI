package com.techun.twitterui.ui.drawerNavigationView.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ActivityMomentsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MomentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMomentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMomentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.iToolbar.topAppBar)
        supportActionBar?.title = getString(R.string.moments_text)
        binding.iToolbar.topAppBar.setNavigationOnClickListener { finish() }
    }
}