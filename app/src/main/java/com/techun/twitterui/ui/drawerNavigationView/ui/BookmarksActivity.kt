package com.techun.twitterui.ui.drawerNavigationView.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techun.twitterui.databinding.ActivityBookmarksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookmarksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookmarksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.iToolbar.topAppBar)
        supportActionBar?.title = "Bookmarks"
        binding.iToolbar.topAppBar.setNavigationOnClickListener { finish() }
    }
}