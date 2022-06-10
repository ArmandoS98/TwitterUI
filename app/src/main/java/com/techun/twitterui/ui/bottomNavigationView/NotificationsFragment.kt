package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentNotificationsBinding
import com.techun.twitterui.ui.bottomNavigationView.notificationsviews.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private var _bindign: FragmentNotificationsBinding? = null
    private val binding get() = _bindign!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindign = FragmentNotificationsBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabLayout()
        setupViewPager()
    }

    private fun setupViewPager() = binding.viewPager.apply {
        adapter = ViewPagerAdapter(childFragmentManager, binding.tabLayout.tabCount)
        addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
    }

    private fun setupTabLayout() = binding.tabLayout.apply {
        addTab(this.newTab().setText("All"))
        addTab(this.newTab().setText("Mentions"))
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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.notification_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}