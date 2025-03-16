package com.hughod.aryatest.ui.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hughod.aryatest.ui.data.Message
import com.hughod.aryatest.ui.theme.AryaTheme
import com.hughod.aryatest.ui.theme.BackgroundGradient
import kotlinx.coroutines.launch

@Composable
fun MessagesView(
    modifier: Modifier,
    messages: List<Message>,
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize()
    ) {
        items(messages) {
            ConvoBubbleView(it)
        }
    }
    val rememberCoroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        rememberCoroutineScope.launch {
            listState.scrollToItem(messages.size)
        }
    }
}

@Preview
@Composable
private fun MessagesViewPreview() = AryaTheme {
    MessagesView(
        modifier = Modifier.background(BackgroundGradient),
        messages = listOf(
            Message(
                text = "Hey John, let's get together and discuss the job proposal. Does Monday Work?",
                time = "11:48 AM",
                self = false,
            ),
            Message(
                text = "That would be great. Yes, I will see you on Monday.",
                time = "11:54 AM",
                seen = true,
                self = true,
            ),
        )
    )
}
