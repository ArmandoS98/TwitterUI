package com.techun.twitterui.ui.bottomNavigationView.notificationsviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.databinding.FragmentNotificationsAllBinding
import com.techun.twitterui.domain.NotificartionModel
import com.techun.twitterui.ui.bottomNavigationView.adapters.notifications.NotificationsAdapter
import com.techun.twitterui.ui.bottomNavigationView.adapters.spaces.SpacesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class NotificationsAllFragment : Fragment() {

    private var _binding: FragmentNotificationsAllBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var notificationsAdapter: NotificationsAdapter

    private val lista = listOf(
        NotificartionModel(
            0,
            "Daviixo",
            "WTF!",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Daviixo",
            "Kjjjjjj",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Netflix Latinoamérica",
            "Viaja a través de los recuerdos de Once y revive sus escenas más icónicas en Regreso a Hawkins, la ÚLTIMA parada de #StrangerFest. Aparta tu lugar en: http://strangerfest.mx",
            "https://pbs.twimg.com/profile_images/1322949452047491074/7pBE_7_i_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Netflix Latinoamérica",
            "😘",
            "https://pbs.twimg.com/profile_images/1322949452047491074/7pBE_7_i_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Pt0te",
            "https://pic.twitter.com/ejoR4UbqU3",
            "https://scontent.fgua1-2.fna.fbcdn.net/v/t1.6435-9/32289759_10210208347519799_8494273129013575680_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=VTV0bR_DG3UAX_4h36w&_nc_ht=scontent.fgua1-2.fna&oh=00_AT-Bf_PGqix_m-TdHqNWApt0t9ATDUna8AoWR4Wrl5tgIA&oe=62C61B8B",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        ), NotificartionModel(
            0,
            "Epic Games",
            "https://pic.twitter.com/ejoR4UbqU3",
            "https://pbs.twimg.com/profile_images/1527302450272579585/DzNWMvFI_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999)
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        recyclerInit()
    }

    private fun init() {
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
        notificationsAdapter.submitList(lista.shuffled())
    }

    private fun recyclerInit() = binding.rvNotifications.apply {
        adapter = notificationsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
    }
}