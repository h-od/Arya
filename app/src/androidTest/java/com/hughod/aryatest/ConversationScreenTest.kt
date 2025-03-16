package com.hughod.aryatest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hughod.aryatest.ui.data.Message
import com.hughod.aryatest.ui.data.User
import com.hughod.aryatest.ui.theme.AryaTheme
import com.hughod.aryatest.ui.views.ConversationScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConversationScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val state = ConversationViewModel.State(
        user = User("Sarah Carter", R.drawable.avatar_ph),
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
            )
        )
    )

    @Test
    fun testSendButton() {
        composeTestRule.setContent {
            AryaTheme {
                ConversationScreen(state)
            }
        }

        composeTestRule.onNodeWithText("Message").performClick()

        composeTestRule.onNodeWithContentDescription("Send message").assertIsNotDisplayed()
    }

    @Test
    fun testSendButtonAppears() {
        composeTestRule.setContent {
            AryaTheme {
                ConversationScreen(state)
            }
        }

        composeTestRule.onNodeWithText("Message").performClick().performTextInput("This is a test")

        composeTestRule.onNodeWithContentDescription("Send message").assertIsDisplayed()
    }

    @Test
    fun testAttachMenuAppears() {
        composeTestRule.setContent {
            AryaTheme {
                ConversationScreen(state)
            }
        }

        composeTestRule.onNodeWithContentDescription("Attach media").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Camera").assertIsDisplayed()
    }
}
