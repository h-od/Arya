package com.hughod.aryatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hughod.aryatest.ui.theme.AryaTheme
import com.hughod.aryatest.ui.views.ConversationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<ConversationViewModel>()

        enableEdgeToEdge()
        setContent {
            AryaTheme {
                val state by viewModel.state.collectAsStateWithLifecycle()

                ConversationScreen(state)
            }
        }
    }
}
