package com.techun.twitterui.ui.bottomNavigationView.notificationsviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techun.twitterui.databinding.FragmentNotificationsAllBinding
import com.techun.twitterui.ui.bottomNavigationView.adapters.notifications.NotificationsAdapter
import com.techun.twitterui.utils.FakeData.notificationListData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotificationsAllFragment : Fragment() {

    private var _binding: FragmentNotificationsAllBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var notificationsAdapter: NotificationsAdapter


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
        notificationsAdapter.submitList(notificationListData.shuffled())
    }

    private fun recyclerInit() = binding.rvNotifications.apply {
        adapter = notificationsAdapter
        layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
    }
}