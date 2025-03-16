package com.hughod.aryatest.ui.views.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hughod.aryatest.R
import com.hughod.aryatest.ui.theme.AlloyGradient
import com.hughod.aryatest.ui.theme.AryaTheme
import com.hughod.aryatest.ui.theme.GreenBeachGradient
import com.hughod.aryatest.ui.theme.PlumGradient
import com.hughod.aryatest.ui.theme.SunshineGradient

@Composable
fun AttachMenuView(
    modifier: Modifier,
    close: () -> Unit,
) = Column(
    verticalArrangement = Arrangement.Bottom,
    modifier = modifier
        .clickable { close() }
        .padding(bottom = 80.dp, start = 32.dp, end = 32.dp, top = 32.dp)
) {
    MenuItem(
        iconRes = R.drawable.ic_camera,
        labelRes = R.string.label_camera,
        color = AlloyGradient,
    )
    MenuItem(
        iconRes = R.drawable.ic_photos,
        labelRes = R.string.label_photos,
        color = SunshineGradient,
    )
    MenuItem(
        iconRes = R.drawable.ic_files,
        labelRes = R.string.label_files,
        color = GreenBeachGradient,
    )
    MenuItem(
        iconRes = R.drawable.ic_audio,
        labelRes = R.string.label_audio,
        color = PlumGradient,
    )
}

@Composable
private fun MenuItem(
    @DrawableRes iconRes: Int,
    @StringRes labelRes: Int,
    color: Brush,
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.padding(bottom = 16.dp)
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(color)
    ) {

        Image(
            painter = painterResource(iconRes),
            contentDescription = "Camera icon",
            modifier = Modifier
                .size(40.dp)
                .padding(8.dp)
        )
    }
    Text(
        text = stringResource(labelRes),
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(start = 16.dp)
    )
}

@Preview
@Composable
private fun AttachMenuPreview() = AryaTheme { AttachMenuView(Modifier, {}) }
