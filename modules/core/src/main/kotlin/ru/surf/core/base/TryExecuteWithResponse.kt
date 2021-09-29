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

import com.keygenqt.response.LocalTryExecuteWithResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.net.UnknownHostException

/**
 * Observe for specific exceptions
 *
 * @author Vitaliy Zarubin
 */
class TryExecuteWithResponse {
    companion object {
        fun observeUnknownHostException(scope: CoroutineScope, body: () -> Unit) {
            LocalTryExecuteWithResponse.current.onEach { exception ->
                if (exception is UnknownHostException) {
                    body.invoke()
                }
            }.launchIn(scope)
        }
    }
}
