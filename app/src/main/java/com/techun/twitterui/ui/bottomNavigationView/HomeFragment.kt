package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentHomeBinding
import com.techun.twitterui.domain.TweetModel
import com.techun.twitterui.ui.bottomNavigationView.adapters.tweets.TweetsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val lista = listOf(
        TweetModel(
            0,
            1,
            "Smartemboser",
            "@Armando",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t39.30808-6/275484369_146707454487942_4691892398623405253_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=ZNpDKAsO5nMAX-QwYUE&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT_HkbgxS1Gj40GosmXs8SRXMef7VgwgE3diHYpqVL2Qbw&oe=62A6BE62",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "I have a TextView that I want to limit characters of it. Actually, I can do this but the thing that I'm looking for is how to add three dots (...) at the end of string. This one shows the text has continue. This is my XML but there is no dots although it limit my text.",
            0,
            "https://catalyst-ca.net/wp-content/uploads/2021/12/top-programing-languages.jpeg",
            false
        ),
        TweetModel(
            0,
            1,
            "Daviixo",
            "@David",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Python es un lenguaje de alto nivel de programación interpretado cuya filosofía hace hincapié en la legibilidad de su código, se utiliza para desarrollar aplicaciones de todo tipo, ejemplos: Instagram, Netflix, Spotify, Panda 3D, entre otros.\u200B",
            0,
            null,
            false
        ),
        TweetModel(
            0,
            1,
            "PtOte",
            "@Tote",
            "https://scontent.fgua1-2.fna.fbcdn.net/v/t1.6435-9/32289759_10210208347519799_8494273129013575680_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=VTV0bR_DG3UAX_4h36w&_nc_ht=scontent.fgua1-2.fna&oh=00_AT-Bf_PGqix_m-TdHqNWApt0t9ATDUna8AoWR4Wrl5tgIA&oe=62C61B8B",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "La ingeniería eléctrica es el campo de la ingeniería que se ocupa del estudio y la aplicación de la electricidad, electromagnetismo, electromecánica y la electrónica a sistemas eléctricos de potencia.",
            0,
            "https://images5.content-hci.com/commimg/myhotcourses/blog-inline/myhc_32056.jpg",
            false
        ),
        TweetModel(
            0,
            1,
            "Probner",
            "@Brodner",
            null,
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Hello World",
            0,
            null,
            false
        ),
        TweetModel(
            0,
            1,
            "Epic Games",
            "@epic_games",
            "https://pbs.twimg.com/profile_images/1527302450272579585/DzNWMvFI_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Epic Games, Inc. es una empresa de desarrollo de videojuegos estadounidense con sede en Cary, ahora asociada con la compañía china Tencent Holdings.​",
            0,
            "https://i.blogs.es/a4d480/epic-games-store/1366_521.jpg",
            false
        ),
        TweetModel(
            0,
            1,
            "Botman",
            "@botman",
            null,
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "Un robot es una entidad virtual o mecánica artificial. En la práctica, esto es por lo general un sistema electromecánico que, por su apariencia o sus movimientos, ofrece la sensación de tener un propósito propio. ",
            0,
            null,
            false
        ),
        TweetModel(
            0,
            1,
            "Netflix Latinoamérica",
            "@NetflixLAT",
            "https://pbs.twimg.com/profile_images/1322949452047491074/7pBE_7_i_400x400.jpg",
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            Random.nextInt(0, 999),
            "– Junio, sorpréndeme. 🙄\n– Qué bonito tu tatuaje, ¿qué significa? 🙄\n– Mijo, ¿Para cuándo un nieto? 🙄🙄🙄",
            0,
            "https://pbs.twimg.com/media/FUctQF5WUAAlvIz?format=jpg&name=medium",
            false
        )
    )

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
        tweetsAdapter.submitList(lista.shuffled())
    }

    private fun recyclerInit() = binding.recyclerviewTweets.apply {
        adapter = tweetsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
    }
}