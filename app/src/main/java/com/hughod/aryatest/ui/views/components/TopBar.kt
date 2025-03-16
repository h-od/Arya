package com.hughod.aryatest.ui.views.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hughod.aryatest.R
import com.hughod.aryatest.ui.theme.AryaTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ConversationTopBarView(
    @DrawableRes avatar: Int,
    userName: String,
) = TopAppBar(
    colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.Transparent,
        navigationIconContentColor = Color.White,
    ),
    navigationIcon = {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = stringResource(R.string.content_description_back_button),
            modifier = Modifier.padding(start = 16.dp)
        )
    },
    title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxHeight()
        ) {
            Image(
                painter = painterResource(avatar),
                contentDescription = stringResource(R.string.content_description_users_avatar),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Text(
                text = userName,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 8.dp),
            )
        }
    }
)

@Preview
@Composable
private fun ConversationTopBarPreview() = AryaTheme {
    ConversationTopBarView(R.drawable.avatar_ph, "Sarah Carter")
}
