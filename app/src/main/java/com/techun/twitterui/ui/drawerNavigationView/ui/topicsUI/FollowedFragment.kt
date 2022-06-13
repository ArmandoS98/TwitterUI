package com.techun.twitterui.ui.drawerNavigationView.ui.topicsUI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentFollowedBinding
import com.techun.twitterui.ui.drawerNavigationView.ui.adapters.topic.TopicAdapter
import com.techun.twitterui.utils.FakeData.suggestedTopicsListData
import com.techun.twitterui.utils.FakeData.topicsListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FollowedFragment : Fragment() {
    private var _binding: FragmentFollowedBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var topicAdapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowedBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
        init()
        recyclerInit()
    }

    private fun init() {

        setupTypeSelection()
        topicAdapter.submitList(topicsListData.shuffled())
    }

    private fun recyclerInit() = binding.rvTopics.apply {
        adapter = topicAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
    }


    private fun setupTypeSelection() {
        binding.chipGroup.removeAllViews()
        suggestedTopicsListData.shuffled().forEach { type ->
            val chip = layoutInflater.inflate(R.layout.chip_topics, binding.chipGroup, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.chipGroup.addView(chip)
        }
    }
}