package com.techun.twitterui.ui.bottomNavigationView.notificationsviews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import javax.inject.Inject

class ViewPagerAdapter(fm: FragmentManager, var tabCount: Int) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NotificationsAllFragment()
            1 -> NotificationsMentionsFragment()
            else -> NotificationsAllFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Tab " + (position + 1)
    }
}
