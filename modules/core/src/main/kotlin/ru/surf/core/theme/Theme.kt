/**
 * Copyright 2021 Surf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.surf.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.surf.core.base.ColorsCustom
import ru.surf.core.base.MaterialThemeCustom

/**
 * Custom palette dark colors
 *
 * @author Vitaliy Zarubin
 */
val DarkColorCustomPalette: @Composable () -> ColorsCustom by lazy {
    { parseConfigCustomPalette(false) }
}

/**
 * Custom palette light colors
 *
 * @author Vitaliy Zarubin
 */
val LightColorCustomPalette: @Composable () -> ColorsCustom by lazy {
    { parseConfigCustomPalette(true) }
}

/**
 * System palette dark colors
 *
 * @author Vitaliy Zarubin
 */
val DarkColorPalette: @Composable () -> Colors by lazy {
    { parseConfigPalette(false) }
}

/**
 * System palette light colors
 *
 * @author Vitaliy Zarubin
 */
val LightColorPalette: @Composable () -> Colors by lazy {
    { parseConfigPalette(true) }
}

/**
 * Main theme app
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun MainAppTheme(content: @Composable() () -> Unit) {

    val colorsCustom = if (isSystemInDarkTheme()) {
        DarkColorCustomPalette.invoke()
    } else {
        LightColorCustomPalette.invoke()
    }

    val colors = if (isSystemInDarkTheme()) {
        DarkColorPalette.invoke()
    } else {
        LightColorPalette.invoke()
    }

    MaterialThemeCustom(
        colors = colorsCustom,
        typography = TypographyCustom,
        shapes = ShapesCustom,
    )

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )

    // Set NavigationBarColor and StatusBarColor
    rememberSystemUiController().let {
        it.setStatusBarColor(
            color = colors.primaryVariant,
            darkIcons = isSystemInDarkTheme()
        )
        it.setNavigationBarColor(
            color = colors.primaryVariant,
            darkIcons = false
        )
    }
}
