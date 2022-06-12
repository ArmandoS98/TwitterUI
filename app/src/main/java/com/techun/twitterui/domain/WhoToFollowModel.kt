package com.techun.twitterui.domain

data class WhoToFollowModel(
    var idWhoToFollow: Int? = null,
    var userName: String? = null,
    var userNameTwitter: String? = null,
    var followBy: String? = null,
    var urlImage: String? = null
)
