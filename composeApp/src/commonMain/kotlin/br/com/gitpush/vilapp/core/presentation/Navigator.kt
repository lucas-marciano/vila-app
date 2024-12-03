package br.com.gitpush.vilapp.core.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.gitpush.vilapp.core.domain.Routes
import br.com.gitpush.vilapp.home.presentation.HomeScreen
import br.com.gitpush.vilapp.login.presentation.LoginScreenRoute

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
        composable(route = Routes.LOGIN_ROUTE.name) {
            LoginScreenRoute()
        }
        composable(route = Routes.HOME_ROUTE.name) {
            HomeScreen()
        }
        composable(route = Routes.FORGOT_PASSWORD_ROUTE.name) {

        }
    }
}
