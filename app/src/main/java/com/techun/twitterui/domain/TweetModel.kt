package com.techun.twitterui.domain

data class TweetModel(
    var tweetId: Int? = null,
    var tweetBy: Int? = null,
    var name: String? = null,
    var username: String? = null,
    var text: String? = null,
    var time: Int? = null,
    var image: String? = null,
    var edited: Boolean? = null
)