package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentMessagesBinding
import com.techun.twitterui.domain.MessageModel
import com.techun.twitterui.domain.NotificartionModel
import com.techun.twitterui.ui.bottomNavigationView.adapters.message.MessageAdapter
import com.techun.twitterui.ui.bottomNavigationView.adapters.tweets.TweetsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class MessagesFragment : Fragment() {
    private var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var messagesAdapter: MessageAdapter

    private val lista = listOf(
        MessageModel(
            0,
            "Daviixo",
            "@David",
            "Python es un lenguaje de alto nivel de programación interpretado cuya filosofía hace hincapié en la legibilidad de su código, se utiliza para desarrollar aplicaciones de todo tipo, ejemplos: Instagram, Netflix, Spotify, Panda 3D, entre otros.",
            "https://scontent.fgua1-3.fna.fbcdn.net/v/t1.18169-9/10175985_10151898488311706_416913463_n.jpg?_nc_cat=101&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=28n1k_d8UIUAX8fP98k&tn=a8phIsuWM6XkW9N0&_nc_ht=scontent.fgua1-3.fna&oh=00_AT-K00Z8T08t5LSUMJITUg8QVCe8sKUBVCDERZNkNjF5tQ&oe=62C7FBED"
        ),
        MessageModel(
            0,
            "PtOte",
            "@Tote",
            "La ingeniería eléctrica es el campo de la ingeniería que se ocupa del estudio y la aplicación de la electricidad, electromagnetismo, electromecánica y la electrónica a sistemas eléctricos de potencia.",
            "https://scontent.fgua1-2.fna.fbcdn.net/v/t1.6435-9/32289759_10210208347519799_8494273129013575680_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=VTV0bR_DG3UAX_4h36w&_nc_ht=scontent.fgua1-2.fna&oh=00_AT-Bf_PGqix_m-TdHqNWApt0t9ATDUna8AoWR4Wrl5tgIA&oe=62C61B8B",
        ),
        MessageModel(
            0, "Probner",
            "@Brodner",
            "Hello World",
            null
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMessagesBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        recyclerInit()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.messages_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun init() {
        binding.tweetsRefreshLayout.setOnRefreshListener {
            init()
            binding.tweetsRefreshLayout.isRefreshing = false
        }
        messagesAdapter.submitList(lista.shuffled())
    }

    private fun recyclerInit() = binding.rvMessages.apply {
        adapter = messagesAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
    }
}