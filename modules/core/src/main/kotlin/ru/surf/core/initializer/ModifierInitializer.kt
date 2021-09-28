/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
@file:Suppress("unused")

package ru.surf.core.initializer

import android.content.Context
import androidx.compose.ui.unit.dp
import androidx.startup.Initializer
import com.keygenqt.modifier.ModifierConfiguration

/**
 * Initialization [ModifierConfiguration]
 *
 * @author Vitaliy Zarubin
 */
class ModifierInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        ModifierConfiguration.init(
            xSmall = 2.dp,
            small = 4.dp,
            medium = 8.dp,
            large = 16.dp,
            xLarge = 24.dp,
            xLarge2 = 48.dp,
            xLarge3 = 96.dp,
        )
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
