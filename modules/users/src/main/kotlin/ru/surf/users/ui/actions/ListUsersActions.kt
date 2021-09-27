/*
 * Copyright Surf - All Rights Reserved
 * September 2021
 */
package ru.surf.users.ui.actions

sealed class ListUsersActions {
    object OpenMenu : ListUsersActions()
    class Search(val text: String?) : ListUsersActions()
    class ToViewUser(val userId: String) : ListUsersActions()
}
