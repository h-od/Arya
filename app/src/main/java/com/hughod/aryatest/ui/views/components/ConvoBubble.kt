package com.hughod.aryatest.ui.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hughod.aryatest.R
import com.hughod.aryatest.ui.data.Message
import com.hughod.aryatest.ui.theme.AryaTheme
import com.hughod.aryatest.ui.theme.BluePrimary

@Composable
fun ConvoBubbleView(
    message: Message,
) {
    val paddingStart: Dp
    val paddingEnd: Dp
    val backgroundColor: Color
    val textColor: Color
    val labelColor: Color

    if (message.self) {
        paddingStart = 100.dp
        paddingEnd = 16.dp
        backgroundColor = MaterialTheme.colorScheme.tertiary
        textColor = Color.Black
        labelColor = BluePrimary
    } else {
        paddingStart = 16.dp
        paddingEnd = 100.dp
        backgroundColor = Color.Transparent.copy(0.1F)
        textColor = Color.White
        labelColor = Color.White
    }

    Column(
        modifier = Modifier
            .padding(start = paddingStart, top = 16.dp, end = paddingEnd)
            .background(backgroundColor, RoundedCornerShape(16.dp))
    ) {
        Text(
            text = message.text,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp),
        )

        Row(
            modifier = Modifier
                .padding(bottom = 8.dp, end = 8.dp)
                .align(Alignment.End)
                .wrapContentHeight(Alignment.CenterVertically)
        ) {

            Text(
                text = message.time,
                color = labelColor,
                style = MaterialTheme.typography.labelSmall,
            )

            if (message.seen) Image(
                painter = painterResource(R.drawable.ic_chat_read),
                contentDescription = stringResource(R.string.content_description_seen),
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(14.dp)
                    .wrapContentHeight(Alignment.CenterVertically),
            )
        }
    }
}

@Preview
@Composable
private fun ConvoBubblePreview() = AryaTheme {
    ConvoBubbleView(
//        Message(
//            text = "Hey John, let's get together and discuss the job proposal. Does Monday Work?",
//            time = "11:48 AM",
//            self = false,
//        ),
        Message(
            text = "That would be great. Yes, I will see you on Monday.",
            time = "11:54 AM",
            seen = true,
            self = true,
        )
    )
}
