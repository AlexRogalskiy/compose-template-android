/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.paddingXLarge
import ru.surf.core.R
import ru.surf.core.theme.MainAppTheme

/**
 * Animation for page
 *
 * @param modifier Modifier to be applied to the layout
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun EmptyPageAnimation(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.empty_page))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = modifier
    )
}

/**
 * Block for show info about page is empty
 *
 * @param modifier Modifier to be applied to the layout
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun EmptyPage(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .paddingLarge()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .paddingXLarge()
                .fillMaxSize()
        ) {
            EmptyPageAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            EmptyPage()
        }
    }
}
