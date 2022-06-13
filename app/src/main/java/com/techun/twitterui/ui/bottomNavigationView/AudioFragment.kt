package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.databinding.FragmentAudioBinding
import com.techun.twitterui.ui.bottomNavigationView.adapters.spaces.SpacesAdapter
import com.techun.twitterui.utils.FakeData.audioListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AudioFragment : Fragment() {
    private var _binding: FragmentAudioBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var spacesAdapter: SpacesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAudioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        recyclerInit()
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
    }

    private fun init() {
        spacesAdapter.submitList(audioListData.shuffled())
    }

    private fun recyclerInit() {
        binding.rvHappeningNow.apply {
            adapter = spacesAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        }

        binding.rvGetCalendar.apply {
            adapter = spacesAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        }
    }
}