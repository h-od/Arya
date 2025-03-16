package com.hughod.aryatest.ui.views

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hughod.aryatest.ConversationViewModel.State
import com.hughod.aryatest.R
import com.hughod.aryatest.ui.data.Message
import com.hughod.aryatest.ui.data.User
import com.hughod.aryatest.ui.theme.AryaTheme
import com.hughod.aryatest.ui.theme.BackgroundGradient
import com.hughod.aryatest.ui.views.components.AttachMenuView
import com.hughod.aryatest.ui.views.components.ConversationTopBarView
import com.hughod.aryatest.ui.views.components.MessageBarView
import com.hughod.aryatest.ui.views.components.MessagesView
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun ConversationScreen(state: State) = Box {
    var showMenu by remember { mutableStateOf(false) }
    val hazeState = remember { HazeState() }

    BackHandler { if (showMenu) showMenu = false }

    Scaffold(
        topBar = { ConversationTopBarView(state.user.avatar, state.user.name) },
        bottomBar = { MessageBarView({}, { showMenu = true }) },
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .hazeSource(hazeState),
    ) { innerPadding ->
        MessagesView(
            modifier = Modifier
                .background(BackgroundGradient)
                .imePadding()
                .padding(innerPadding),
            messages = state.messages,
        )
    }

    AnimatedVisibility(
        showMenu,
        enter = fadeIn(animationSpec = tween(durationMillis = 500)),
        exit = fadeOut(animationSpec = tween(durationMillis = 500)),
    ) {
        AttachMenuView(
            modifier = Modifier
                .fillMaxSize()
                .hazeEffect(state = hazeState, style = HazeMaterials.ultraThin()),
            close = { showMenu = false },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ConversationContentPreview() = AryaTheme {
    ConversationScreen(
        state = State(
            user = User("Sarah", R.drawable.avatar_ph),
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
    )
}
