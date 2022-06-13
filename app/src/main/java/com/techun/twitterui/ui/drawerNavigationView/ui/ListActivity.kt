package com.techun.twitterui.ui.drawerNavigationView.ui

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.databinding.ActivityListBinding
import com.techun.twitterui.ui.drawerNavigationView.ui.adapters.list.DiscoverAdapter
import com.techun.twitterui.utils.FakeData
import com.techun.twitterui.utils.FakeData.discoverListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    @Inject
    lateinit var discoversAdapter: DiscoverAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.iToolbar.topAppBar)
        supportActionBar?.title = "List"
        binding.iToolbar.topAppBar.setNavigationOnClickListener { finish() }

        init()
        recyclerInit()
    }

    private fun init() {
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
        discoversAdapter.submitList(discoverListData.shuffled())
    }

    private fun recyclerInit() = binding.rvTopics.apply {
        adapter = discoversAdapter
        layoutManager = LinearLayoutManager(this@ListActivity, LinearLayout.VERTICAL, false)
    }
}