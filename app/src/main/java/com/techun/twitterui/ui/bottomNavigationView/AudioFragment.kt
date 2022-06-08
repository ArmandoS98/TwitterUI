package com.techun.twitterui.ui.bottomNavigationView

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.techun.twitterui.R
import com.techun.twitterui.databinding.FragmentAudioBinding

class AudioFragment : Fragment() {
    private var _binding: FragmentAudioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAudioBinding.inflate(inflater, container, false)
        return binding.root
    }
}