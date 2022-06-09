package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.databinding.FragmentAudioBinding
import com.techun.twitterui.domain.SpaceModel
import com.techun.twitterui.ui.bottomNavigationView.adapters.spaces.SpacesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AudioFragment : Fragment() {
    private var _binding: FragmentAudioBinding? = null
    private val binding get() = _binding!!

    private val lista = listOf(
        SpaceModel(
            0,
            "Tomorrow ata 1:00 PM",
            "How long should a relationship last before marriage? #Lifeissues",
            "American footbal NCAA Football",
            null,
            "ILLZ NFT",
            "NFT lover || Crypto King Tech genius|| Buying BTC ETH NFT SHIB."
        ),
        SpaceModel(
            0,
            "Tomorrow ata 1:00 PM",
            "Live commitment with IPC",
            "American footbal NCAA Football",
            null,
            "Josh",
            "An official Twitter account of 'LonelyPop' by @bushrobins y @OxSutdio | Join our discord."
        ),
        SpaceModel(
            0,
            "Tomorrow ata 1:00 PM",
            "Tell us a petty reason you refused to date someone? #NaijaConversations",
            "American footbal NCAA Football",
            null,
            "Naija",
            "An official Twitter account of 'LonelyPop' by @bushrobins y @OxSutdio | Join our discord."
        )
    )

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
        spacesAdapter.submitList(lista.shuffled())
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