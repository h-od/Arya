package com.hughod.aryatest.ui.data

import androidx.annotation.DrawableRes

data class User(
    val name: String,
    @DrawableRes val avatar: Int,
)
