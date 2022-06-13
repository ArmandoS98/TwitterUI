package com.techun.twitterui.ui.drawerNavigationView.ui.topicsUI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentSuggestedBinding
import com.techun.twitterui.utils.FakeData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuggestedFragment : Fragment() {
    private var _binding: FragmentSuggestedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuggestedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
        init()
    }

    private fun init() {
        setupTypeSelection()
    }

    private fun setupTypeSelection() {
        //For you
        binding.cgForYou.removeAllViews()
        FakeData.suggestedTopicsListData.shuffled().forEach { type ->
            val chip = layoutInflater.inflate(R.layout.chip_topics, binding.cgForYou, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.cgForYou.addView(chip)
        }

        //Music
        binding.cgMusic.removeAllViews()
        FakeData.suggestedTopicsListData.shuffled().forEach { type ->
            val chip = layoutInflater.inflate(R.layout.chip_topics, binding.cgMusic, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.cgMusic.addView(chip)
        }

        //Culture
        binding.cgCulture.removeAllViews()
        FakeData.suggestedTopicsListData.shuffled().forEach { type ->
            val chip =
                layoutInflater.inflate(R.layout.chip_topics, binding.cgCulture, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.cgCulture.addView(chip)
        }

        //Entertainment
        binding.cgEntertainment.removeAllViews()
        FakeData.suggestedTopicsListData.shuffled().forEach { type ->
            val chip =
                layoutInflater.inflate(R.layout.chip_topics, binding.cgEntertainment, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.cgEntertainment.addView(chip)
        }

        //Fashion
        binding.cgFashion.removeAllViews()
        FakeData.suggestedTopicsListData.shuffled().forEach { type ->
            val chip =
                layoutInflater.inflate(R.layout.chip_topics, binding.cgFashion, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.cgFashion.addView(chip)
        }

        //Travel
        binding.cgTravel.removeAllViews()
        FakeData.suggestedTopicsListData.shuffled().forEach { type ->
            val chip = layoutInflater.inflate(R.layout.chip_topics, binding.cgTravel, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.cgTravel.addView(chip)
        }

        //Outdoors
        binding.cgOutdoors.removeAllViews()
        FakeData.suggestedTopicsListData.shuffled().forEach { type ->
            val chip =
                layoutInflater.inflate(R.layout.chip_topics, binding.cgOutdoors, false) as Chip
            chip.text = type
            chip.id = View.generateViewId()
            binding.cgOutdoors.addView(chip)
        }
    }
}