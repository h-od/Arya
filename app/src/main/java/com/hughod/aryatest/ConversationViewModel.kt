package com.hughod.aryatest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hughod.aryatest.ui.data.ConversationRepository
import com.hughod.aryatest.ui.data.User
import com.hughod.aryatest.ui.data.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ConversationViewModel(
    user: User = User("Sarah Carter", R.drawable.avatar_ph),
    private val repository: ConversationRepository = ConversationRepository(),
) : ViewModel() {

    private val _state = MutableStateFlow(State(user))
    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(messages = repository.getMessages(user))
            }
        }
    }

    data class State(
        val user: User,
        val messages: List<Message> = listOf(),
    )
}
