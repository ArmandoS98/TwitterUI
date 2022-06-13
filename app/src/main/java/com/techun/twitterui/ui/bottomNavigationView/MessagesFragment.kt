package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentMessagesBinding
import com.techun.twitterui.ui.bottomNavigationView.adapters.message.MessageAdapter
import com.techun.twitterui.utils.FakeData.messageListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MessagesFragment : Fragment() {
    private var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var messagesAdapter: MessageAdapter

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
        messagesAdapter.submitList(messageListData.shuffled())
    }

    private fun recyclerInit() = binding.rvMessages.apply {
        adapter = messagesAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
    }
}