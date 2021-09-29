/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.other.data.responses

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

/**
 * Response after registration
 *
 * @property user_id user identifier
 * @property token for authorization
 *
 * @author Vitaliy Zarubin
 */
@Immutable
@Serializable
data class SignUpResponse(
    val user_id: String,
    val token: String,
)
