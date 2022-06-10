package com.techun.twitterui.domain

data class NotificartionModel(
    var idNotification: Int? = null,
    var title: String? = null,
    var descriptions: String? = null,
    var userProfile: String? = null,
    var likes: Int? = null,
    var comments: Int? = null,
    var reTweets: Int? = null
)