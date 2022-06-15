package com.techun.twitterui.ui.bottomNavigationView.tweetImageDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.transition.MaterialContainerTransform
import com.techun.twitterui.databinding.ActivityImageDetailsBinding
import com.techun.twitterui.domain.TweetModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageDetailsBinding
    private lateinit var sportsArgs: TweetModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}