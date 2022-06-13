package com.techun.twitterui.ui.drawerNavigationView.ui.adapters.topics

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.techun.twitterui.ui.drawerNavigationView.ui.topicsUI.FollowedFragment
import com.techun.twitterui.ui.drawerNavigationView.ui.topicsUI.NotInterestedFragment
import com.techun.twitterui.ui.drawerNavigationView.ui.topicsUI.SuggestedFragment

class ViewPagerTopicsAdapter(fm: FragmentManager, var tabCount: Int) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FollowedFragment()
            1 -> SuggestedFragment()
            2 -> NotInterestedFragment()
            else -> FollowedFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "Tab " + (position + 1)
    }
}
