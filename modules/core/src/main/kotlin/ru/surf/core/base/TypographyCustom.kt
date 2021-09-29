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
package ru.surf.core.base

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

/**
 * Typography custom for [MaterialThemeCustom]
 *
 * @property title typography for title, example
 *
 * @author Vitaliy Zarubin
 */
class TypographyCustom(
    val title: TextStyle,
) {
    companion object {
        val default: @Composable () -> TypographyCustom by lazy {
            { TypographyCustom(title = MaterialTheme.typography.h1) }
        }
    }
}
