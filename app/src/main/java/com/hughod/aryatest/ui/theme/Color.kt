package com.hughod.aryatest.ui.theme

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val BackgroundGradientOne= Color(0xFF048DF5)
private val BackgroundGradientTwo= Color(0xFF14a8f6)
private val BackgroundGradientThree= Color(0xFF91aebb)
private val BackgroundGradientFour= Color(0xFFe9c39c)

private val SunshineGradientOne= Color(0xFFfbda89)
private val SunshineGradientTwo= Color(0xFFf38284)

private val GreenBeachGradientOne= Color(0xFF42e397)
private val GreenBeachGradientTwo= Color(0xFF35abae)

private val MorningGradientOne= Color(0xFFff8888)
private val MorningGradientTwo= Color(0xFFf6519e)

private val PlumGradientOne= Color(0xFFd6a7e3)
private val PlumGradientTwo= Color(0xFF5a81e8)

private val OceanGradientOne= Color(0xFF1de2db)
private val OceanGradientTwo= Color(0xFF5a81e8)

private val AlloyGradientOne= Color(0xFFbdbdbd)
private val AlloyGradientTwo= Color(0xFF676767)

val BackgroundGradient = Brush.linearGradient(
    listOf(
        BackgroundGradientOne,
        BackgroundGradientTwo,
        BackgroundGradientThree,
        BackgroundGradientFour,
    )
)
val SunshineGradient = Brush.linearGradient(
    listOf(
        SunshineGradientOne,
        SunshineGradientTwo,
    )
)
val GreenBeachGradient = Brush.linearGradient(
    listOf(
        GreenBeachGradientOne,
        GreenBeachGradientTwo,
    )
)
val MorningGradient  = Brush.linearGradient(
    listOf(
        MorningGradientOne,
        MorningGradientTwo,
    )
)
val PlumGradient  = Brush.linearGradient(
    listOf(
        PlumGradientOne,
        PlumGradientTwo,
    )
)
val OceanGradient = Brush.linearGradient(
    listOf(
        OceanGradientOne,
        OceanGradientTwo,
    )
)
val AlloyGradient = Brush.linearGradient(
    listOf(
        AlloyGradientOne,
        AlloyGradientTwo,
    )
)

val WhitePrimary = Color(0xFFFFFFFF)
val BlackPrimary = Color(0xFF1D1D1D)
val BluePrimary = Color(0xFF01A6FC)
val RedPrimary = Color(0xFFFF2800)
val GreenPrimary = Color(0xFF4FD35F)
val GrayPrimary = Color(0xFF818893)
val GraySecondary = Color(0xFFF6F6F8)
val GrayAccent = Color(0xFFD2D2D7)
val GoldPrimary = Color(0xFFEAC7A0)
val BlueRollover = Color(0xFF0189E6)

@Composable
fun composeMessageFieldColors() = TextFieldDefaults.colors().copy(
    focusedContainerColor = Color.Transparent.copy(alpha = 0.2F),
    unfocusedContainerColor = Color.Transparent.copy(alpha = 0.2F),
    cursorColor = WhitePrimary,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
)
