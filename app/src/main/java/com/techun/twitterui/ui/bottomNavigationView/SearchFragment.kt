package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.widget.ImageView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentSearchBinding
import com.techun.twitterui.ui.MainActivity

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}