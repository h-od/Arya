package com.hughod.aryatest.ui.views.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hughod.aryatest.R
import com.hughod.aryatest.ui.theme.WhitePrimary
import com.hughod.aryatest.ui.theme.composeMessageFieldColors

@Composable
fun MessageBarView(
    send: (String) -> Unit,
    attach: () -> Unit,
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp),
) {
    var text by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    Image(
        painter = painterResource(R.drawable.ic_attach),
        contentDescription = stringResource(R.string.content_description_attach_media),
        modifier = Modifier
            .wrapContentHeight(Alignment.CenterVertically)
            .size(16.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) { attach() },
    )

    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(stringResource(R.string.placeholder_message), style = MaterialTheme.typography.bodyMedium) },
        textStyle = TextStyle(color = WhitePrimary),
        shape = RoundedCornerShape(32.dp),
        colors = composeMessageFieldColors(),
        maxLines = 2,
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Sentences,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Send,
        ),
        keyboardActions = KeyboardActions(onSend = {
            send(text).also { text = "" }
        }),
        trailingIcon = {
            AnimatedVisibility(
                visible = text.isNotBlank(),
                enter = scaleIn(),
                exit = scaleOut(),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_send),
                    contentDescription = stringResource(R.string.content_description_send),
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end = 8.dp)
                        .clickable { send(text).also { text = "" } }
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview
@Composable
private fun MessageBarPreview() = MessageBarView({}, {})
