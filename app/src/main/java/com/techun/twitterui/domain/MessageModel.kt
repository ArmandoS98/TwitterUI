package com.techun.twitterui.domain

data class MessageModel(
    var idMessage: Int? = null,
    var userName: String? = null,
    var userNameTwitter: String?,
    var message: String? = null,
    var userImageProfile: String? = null
)