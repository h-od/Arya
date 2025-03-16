package com.hughod.aryatest.ui.data

class ConversationRepository {
    fun getMessages(user: User): List<Message> = listOf(
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
}
