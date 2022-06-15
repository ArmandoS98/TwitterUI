package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
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
    var isLoading = false

    @Inject
    lateinit var tweetsAdapter: TweetsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        loadData()
        recyclerInit()
        initListener()
    }

    private fun loadData() {
        tweetsAdapter.submitList(RockListData.shuffled())
    }

    private fun initListener() {
        tweetsAdapter.setImageTweetClickListener { tweet, imgPreview ->
            val extras =
                FragmentNavigator.Extras.Builder().addSharedElement(imgPreview, "image_tweet")
                    .build()
            val directions = HomeFragmentDirections.actionNavHomeToImageDetailsActivity(tweet)
            findNavController().navigate(
                directions,
                extras
            )
        }

        tweetsAdapter.setOptionsClickListener {

        }

        tweetsAdapter.setItemClickListener {
            Toast.makeText(requireContext(), "Complete", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun init() {
        binding.tweetsRefreshLayout.setColorSchemeColors(R.color.color_card_subthird)
        binding.tweetsRefreshLayout.setOnRefreshListener {
            tweetsAdapter.notifyDataSetChanged()
            init()
            tweetsAdapter.notifyDataSetChanged()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
    }

    private fun recyclerInit() = binding.recyclerviewTweets.apply {
        adapter = tweetsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        postponeEnterTransition()
        doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

}