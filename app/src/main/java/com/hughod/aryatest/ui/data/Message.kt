package com.hughod.aryatest.ui.data

data class Message(
    val text: String,
    val time: String,
    val seen: Boolean = false,
    val self: Boolean,
)
