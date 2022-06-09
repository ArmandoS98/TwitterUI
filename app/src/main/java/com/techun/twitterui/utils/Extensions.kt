package com.techun.twitterui.utils

import android.app.Activity
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.techun.twitterui.R


fun ImageView.loadByResource(resource: Int) =
    Glide.with(this)
        .load(resource)
        .centerInside()
        .placeholder(R.drawable.ic_profile)
        .error(R.drawable.ic_profile)
        .fallback(R.drawable.ic_profile)
        .into(this)

fun ImageView.loadByResource(resource: String) =
    Glide.with(this)
        .load(resource)
        .centerCrop()
        .placeholder(R.drawable.ic_profile)
        .error(R.drawable.ic_profile)
        .fallback(R.drawable.ic_profile)
        .into(this)

inline fun <reified T : Activity> Activity.goToActivity(
    noinline init: Intent.() -> Unit = {},
    finish: Boolean = false
) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
    if (finish)
        finish()
}

fun Activity.toast(text: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}