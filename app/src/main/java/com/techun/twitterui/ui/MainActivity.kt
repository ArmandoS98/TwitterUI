package com.techun.twitterui.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.techun.twitterui.R
import com.techun.twitterui.databinding.ActivityMainBinding
import com.techun.twitterui.ui.drawerNavigationView.ClickListener
import com.techun.twitterui.ui.drawerNavigationView.NavigationItemModel
import com.techun.twitterui.ui.drawerNavigationView.NavigationRVAdapter
import com.techun.twitterui.ui.drawerNavigationView.RecyclerTouchListener
import com.techun.twitterui.utils.toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // drawer
    private lateinit var myToggle: ActionBarDrawerToggle
    private lateinit var myDrawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var adapter: NavigationRVAdapter

    //Inits
    private var items = arrayListOf(
        NavigationItemModel(R.drawable.ic_profile, "Profile"),
        NavigationItemModel(R.drawable.ic_lists, "Lists"),
        NavigationItemModel(R.drawable.ic_topics, "Topics"),
        NavigationItemModel(R.drawable.ic_bookmark, "Bookmarks"),
        NavigationItemModel(R.drawable.ic_moments, "Moments"),
        NavigationItemModel(R.drawable.ic_monetization, "Monitization")
    )
    private var items2 = arrayListOf(
        NavigationItemModel(R.drawable.ic_professionals, "Twitter for Professionals")
    )
    private var items3 = arrayListOf(
        NavigationItemModel(title = "Settings and privacy"),
        NavigationItemModel(title = "Help Center")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // Setup Recyclerview's Layout
        binding.navigationRv.layoutManager = LinearLayoutManager(this)
        binding.navigationRv.setHasFixedSize(true)
/*
        binding.navigationRv2.layoutManager = LinearLayoutManager(this)
        binding.navigationRv2.setHasFixedSize(true)

        binding.navigationRv3.layoutManager = LinearLayoutManager(this)
        binding.navigationRv3.setHasFixedSize(true)*/

        myDrawerLayout = binding.drawerLayout
        navigationView = binding.navigationView

        updateAdapter()
        // Add Item Touch Listener
        binding.navigationRv.addOnItemTouchListener(





            RecyclerTouchListener(
                this,
                object : ClickListener {
                    override fun onClick(view: View, position: Int) {
                        when (position) {
                            0 -> {
                                toast("holis")
//                                goToActivity<ProfileActivity>(finish = false)
                            }
                            1 -> {
//                                goToActivity<ListActivity>()
                            }
                            2 -> {
//                                goToActivity<TopicsActivity>()
                            }
                            3 -> {
//                                goToActivity<BookmarksActivity>()
                            }
                            4 -> {
//                                goToActivity<MomentsActivity>()
                            }
                            5 -> {
//                                goToActivity<MonetizationActivity>()
                            }
                        }
                        updateAdapter()
                        myDrawerLayout.closeDrawer(navigationView)
                    }
                })
        )
    /*    binding.navigationRv2.addOnItemTouchListener(
            RecyclerTouchListener(
                this,
                object : ClickListener {
                    override fun onClick(view: View, position: Int) {
                        when (position) {
                            0 -> {
                                goToActivity<TwitterForProfessionalsActivity>()
                            }
                        }
                        updateAdapter(position)
                        myDrawerLayout.closeDrawer(navigationView)
                    }
                })
        )
        binding.navigationRv3.addOnItemTouchListener(
            RecyclerTouchListener(
                this,
                object : ClickListener {
                    override fun onClick(view: View, position: Int) {
                        when (position) {
                            0 -> {
                                goToActivity<SettingsAndPrivacyActivity>()
                            }
                            1 -> {
                                goToActivity<HelpCenterActivity>()
                            }
                        }
                        updateAdapter(position)
                        myDrawerLayout.closeDrawer(navigationView)
                    }
                })
        )*/
        myToggle = ActionBarDrawerToggle(this, myDrawerLayout, R.string.open, R.string.close)
        myDrawerLayout.addDrawerListener(myToggle)
        myToggle.syncState()

        binding.civDrawerUserPhotoToolbar.setOnClickListener {
            if (myDrawerLayout.isDrawerOpen(navigationView)) {
                myDrawerLayout.closeDrawer(navigationView)
            } else {
                myDrawerLayout.openDrawer(navigationView)
            }
        }

        val navView: BottomNavigationView = binding.navView
        navView.itemIconTintList = null
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_home -> {
                    binding.imgIcon.visibility = View.VISIBLE
                    binding.tvToolbar.visibility = View.GONE
                    binding.etToolbar.visibility = View.GONE
                }
                R.id.nav_reconding -> {
                    binding.imgIcon.visibility = View.GONE
                    binding.etToolbar.visibility = View.GONE
                    binding.tvToolbar.visibility = View.VISIBLE
                    binding.tvToolbar.text = getString(R.string.twitter)
                }
                R.id.nav_notification -> {
                    binding.imgIcon.visibility = View.GONE
                    binding.etToolbar.visibility = View.GONE
                    binding.tvToolbar.visibility = View.VISIBLE
                    binding.tvToolbar.text = getString(R.string.notification)
                }
                R.id.nav_search -> {
                    binding.imgIcon.visibility = View.GONE
                    binding.tvToolbar.visibility = View.GONE
                    binding.etToolbar.visibility = View.VISIBLE
                    binding.etToolbar.text = "Search Twitter"
                }
                R.id.nav_inbox -> {
                    binding.imgIcon.visibility = View.GONE
                    binding.tvToolbar.visibility = View.GONE
                    binding.etToolbar.visibility = View.VISIBLE
                    binding.etToolbar.text = "Search Direct Messages"
                }
                else -> {
                    binding.imgIcon.visibility = View.GONE
                    binding.tvToolbar.visibility = View.GONE
                    binding.etToolbar.visibility = View.GONE
                }
            }
        }
    }

    private fun updateAdapter() {
        adapter = NavigationRVAdapter(items)
        binding.navigationRv.adapter = adapter
       /* adapter = NavigationRVAdapter(items2, highlightItemPos)
        binding.navigationRv2.adapter = adapter
        adapter = NavigationRVAdapter(items3, highlightItemPos)
        binding.navigationRv3.adapter = adapter*/
        adapter.notifyDataSetChanged()
    }
}