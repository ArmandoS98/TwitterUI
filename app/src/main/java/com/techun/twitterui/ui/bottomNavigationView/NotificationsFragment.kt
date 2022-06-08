package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentNotificationsBinding
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.notification_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}