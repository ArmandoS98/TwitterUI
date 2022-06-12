package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentSearchBinding
import com.techun.twitterui.domain.MessageModel
import com.techun.twitterui.domain.TrendModel
import com.techun.twitterui.domain.WhoToFollowModel
import com.techun.twitterui.ui.MainActivity
import com.techun.twitterui.ui.bottomNavigationView.adapters.message.MessageAdapter
import com.techun.twitterui.ui.bottomNavigationView.adapters.search.trending.TrendAdapter
import com.techun.twitterui.ui.bottomNavigationView.adapters.search.whoToFollow.WhoToFollowAdapter
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

    private val lista = listOf(
        TrendModel(
            0,
            "Trending in Guatemala",
            "San Lucas",
            null
        ),
        TrendModel(
            0,
            "Trending in Guatemala",
            "#RatchetPS5",
            "1,506 Tweets"
        ),
        TrendModel(
            0,
            "Trending in Guatemala",
            "Portillo",
            "1,451 Tweets"
        ),
        TrendModel(
            0,
            "Gaming Trending",
            "Fable",
            "2,155 Tweets"
        ),
        TrendModel(
            0,
            "Trending in Guatemala",
            "Xela",
            "1,499 Tweets"
        )
    )

    private val listWhoToFollows = listOf(
        WhoToFollowModel(
            0,
            "Smartemboser",
            "@ArmandoS98",
            "Humano Indecente follows",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t39.30808-6/275484369_146707454487942_4691892398623405253_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=ZNpDKAsO5nMAX-QwYUE&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT_HkbgxS1Gj40GosmXs8SRXMef7VgwgE3diHYpqVL2Qbw&oe=62A6BE62"
        ),
        WhoToFollowModel(
            0,
            "Smartemboser",
            "@ArmandoS98",
            "Humano Indecente follows",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t39.30808-6/275484369_146707454487942_4691892398623405253_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=ZNpDKAsO5nMAX-QwYUE&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT_HkbgxS1Gj40GosmXs8SRXMef7VgwgE3diHYpqVL2Qbw&oe=62A6BE62"
        ),
        WhoToFollowModel(
            0,
            "Smartemboser",
            "@ArmandoS98",
            "Humano Indecente follows",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t39.30808-6/275484369_146707454487942_4691892398623405253_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=ZNpDKAsO5nMAX-QwYUE&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT_HkbgxS1Gj40GosmXs8SRXMef7VgwgE3diHYpqVL2Qbw&oe=62A6BE62"
        ),
        WhoToFollowModel(
            0,
            "Smartemboser",
            "@ArmandoS98",
            "Humano Indecente follows",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t39.30808-6/275484369_146707454487942_4691892398623405253_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=ZNpDKAsO5nMAX-QwYUE&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT_HkbgxS1Gj40GosmXs8SRXMef7VgwgE3diHYpqVL2Qbw&oe=62A6BE62"

        ),
        WhoToFollowModel(
            0,
            "Smartemboser",
            "@ArmandoS98",
            "Humano Indecente follows",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t39.30808-6/275484369_146707454487942_4691892398623405253_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=ZNpDKAsO5nMAX-QwYUE&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT_HkbgxS1Gj40GosmXs8SRXMef7VgwgE3diHYpqVL2Qbw&oe=62A6BE62"
        )
    )

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
        init()
        recyclerInit()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun init() {
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
        trendingAdapter.submitList(lista.shuffled())
        whoToFollows.submitList(listWhoToFollows.shuffled())
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
    }

}