/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.core.navigation.nav.impl

import com.keygenqt.routing.NavScreen

/**
 * Routing for [StatusScreen]
 *
 * @author Vitaliy Zarubin
 */
object StatusScreen {
    val StatusScreen = object : NavScreen {
        override val route: String = "StatusScreen"
    }
}
