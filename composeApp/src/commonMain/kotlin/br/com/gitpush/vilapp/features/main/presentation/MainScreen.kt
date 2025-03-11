package br.com.gitpush.vilapp.features.main.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.gitpush.vilapp.core.routing.Home
import br.com.gitpush.vilapp.core.routing.LogOut
import br.com.gitpush.vilapp.core.routing.Search
import br.com.gitpush.vilapp.core.routing.bottomMenuList
import br.com.gitpush.vilapp.features.home.presentation.HomeRoute
import br.com.gitpush.vilapp.features.home.presentation.HomeViewModel
import br.com.gitpush.vilapp.ui.components.topbar.MainTopBar
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.koin.compose.viewmodel.koinViewModel

val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route

    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold(modifier = Modifier.fillMaxSize(),
            topBar = {
                MainTopBar(
                    title = "VilApp",
                )
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    windowInsets = WindowInsets.navigationBars,
                    containerColor = VilaTheme.colors.background,
                    contentColor = VilaTheme.colors.onBackground
                ) {
                    bottomMenuList.forEachIndexed { index, item ->
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = when (selectedIndex) {
                                index -> VilaTheme.colors.primary
                                else -> VilaTheme.colors.primary.copy(alpha = 0.6f)
                            }
                        )
                    }
                }
            }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = navController,
                    startDestination = Home,
                    enterTransition = {
                        fadeIn(animationSpec = tween(300))
                    },
                    exitTransition = {
                        fadeOut(animationSpec = tween(300))
                    },
                    builder = {
                        composable<Home> {
                            selectedIndex = bottomMenuList.find { it.screen == Home }?.position ?: 0
                            val viewModel = koinViewModel<HomeViewModel>()
                            HomeRoute(viewModel)
                        }

                        composable<Search> {
                            selectedIndex =
                                bottomMenuList.find { it.screen == Search }?.position ?: 0
                        }

                        composable<LogOut> {
                            selectedIndex =
                                bottomMenuList.find { it.screen == LogOut }?.position ?: 0
                        }
                    })
            }
        }
    }
}
