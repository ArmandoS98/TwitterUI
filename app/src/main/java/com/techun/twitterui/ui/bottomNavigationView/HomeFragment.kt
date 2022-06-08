package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentHomeBinding
import com.techun.twitterui.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}