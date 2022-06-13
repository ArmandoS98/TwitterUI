package com.techun.twitterui.ui.drawerNavigationView.ui.topicsUI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentNotInterestedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotInterestedFragment : Fragment() {
    private var _binding: FragmentNotInterestedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotInterestedBinding.inflate(inflater, container, false)
        return binding.root
    }
}