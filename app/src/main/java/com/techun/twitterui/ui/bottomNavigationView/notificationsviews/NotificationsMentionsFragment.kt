package com.techun.twitterui.ui.bottomNavigationView.notificationsviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.techun.twitterui.databinding.FragmentNotificationsMentionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsMentionsFragment : Fragment() {
    private var _binding: FragmentNotificationsMentionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsMentionsBinding.inflate(inflater, container, false)
        return binding.root
    }
}