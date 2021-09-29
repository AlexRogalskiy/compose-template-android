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
package ru.surf.other.ui.screens.signIn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.surf.core.base.LocalBackPressedDispatcher
import ru.surf.other.ui.actions.SignInActions
import ru.surf.other.ui.viewModels.OtherViewModel

/**
 * Base page fun for initialization
 *
 * @param viewModel page model
 * @param onActions actions
 *
 * @author Vitaliy Zarubin
 */
@Composable
fun SignInScreen(
    viewModel: OtherViewModel,
    onActions: (SignInActions) -> Unit = {},
) {
    val loading: Boolean by viewModel.loading.collectAsState()
    val commonError: String? by viewModel.commonError.collectAsState(null)

    SignInBody(
        loading = loading,
        onActions = onActions,
        commonError = commonError,
        backDispatcher = LocalBackPressedDispatcher.current,
    )
}
