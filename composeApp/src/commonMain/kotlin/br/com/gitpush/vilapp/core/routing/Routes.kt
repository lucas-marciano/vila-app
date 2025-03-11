package br.com.gitpush.vilapp.core.routing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable


@Serializable
object Main

@Serializable
object Home

@Serializable
object Search

@Serializable
object Login


@Serializable
object LogOut

@Serializable
object ForgotPassword

data class BottomNavRoutes<T : Any>(
    val name: String,
    val icon: ImageVector,
    val screen: T,
    val position: Int
)

val bottomMenuList = listOf(
    BottomNavRoutes<Any>("Home", Icons.Filled.Home, Home, 0),
    BottomNavRoutes<Any>("Pesquisar", Icons.Default.FindInPage, Search, 1),
    BottomNavRoutes<Any>("Sair", Icons.AutoMirrored.Filled.ExitToApp, LogOut, 2),
)
