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
package ru.surf.core.services.api.impl

import retrofit2.Response
import retrofit2.http.GET
import ru.surf.core.data.responses.SettingsResponse

/**
 * The GET method requests a representation of the specified resource. Requests using GET should only retrieve data.
 *
 * @author Vitaliy Zarubin
 */
interface ApiGet {
    @GET("settings")
    suspend fun getListSettings(): Response<List<SettingsResponse>>
}
