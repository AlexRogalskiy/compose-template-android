/**
 * Copyright 2021 Surf LLC
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
package ru.surf.settings.services.apiService

import ru.surf.settings.services.api.SettingsApi
import ru.surf.settings.services.apiService.impl.*

/**
 * Base services for query separate by HTTP methods
 *
 * @author Vitaliy Zarubin
 */
class SettingsApiService(
    override val api: SettingsApi,
) :
    ApiServiceDelete,
    ApiServiceGet,
    ApiServicePatch,
    ApiServicePost,
    ApiServicePut
