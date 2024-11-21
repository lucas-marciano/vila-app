package br.com.gitpush.vilapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigator(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues = PaddingValues(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN_ROUTE.name,
        modifier = modifier.fillMaxSize().padding(innerPadding)
    ) {
        composable(route = Routes.LOGIN_ROUTE.name) {}
        composable(route = Routes.HOME_ROUTE.name) {}
    }
}
