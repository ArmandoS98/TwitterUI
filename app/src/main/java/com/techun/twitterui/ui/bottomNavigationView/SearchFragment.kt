package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentSearchBinding
import com.techun.twitterui.ui.bottomNavigationView.adapters.search.trending.TrendAdapter
import com.techun.twitterui.ui.bottomNavigationView.adapters.search.whoToFollow.WhoToFollowAdapter
import com.techun.twitterui.ui.bottomNavigationView.adapters.tweets.TweetsAdapter
import com.techun.twitterui.utils.FakeData.RockListData
import com.techun.twitterui.utils.FakeData.trendingListData
import com.techun.twitterui.utils.FakeData.whoToFollowListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var trendingAdapter: TrendAdapter

    @Inject
    lateinit var whoToFollows: WhoToFollowAdapter

    @Inject
    lateinit var tweetsAdapter: TweetsAdapter

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
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
     /*   Handler(Looper.getMainLooper()).postDelayed({
            init()
            recyclerInit()
        }, 1000)*/
        init()
        recyclerInit()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun init() {
        trendingAdapter.submitList(trendingListData.shuffled())
        whoToFollows.submitList(whoToFollowListData.shuffled())
        tweetsAdapter.submitList(RockListData.shuffled())
    }

    private fun recyclerInit() {
        binding.rvTrends.apply {
            adapter = trendingAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        }

        binding.rvWhoToFollow.apply {
            adapter = whoToFollows
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false)
        }

        binding.rvRock.apply {
            adapter = tweetsAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        }
    }

}