package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment() {
    private var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMessagesBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.messages_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}