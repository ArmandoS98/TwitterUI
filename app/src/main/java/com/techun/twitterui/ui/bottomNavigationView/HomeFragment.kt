package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentHomeBinding
import com.techun.twitterui.ui.bottomNavigationView.adapters.tweets.TweetsAdapter
import com.techun.twitterui.utils.FakeData.RockListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var tweetsAdapter: TweetsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun init() {
        tweetsAdapter.submitList(RockListData.shuffled())
    }

    private fun recyclerInit() = binding.recyclerviewTweets.apply {
        adapter = tweetsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
    }
}