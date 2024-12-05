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
import br.com.gitpush.vilapp.features.forgot_pass.presentation.ForgotPasswordRoute
import br.com.gitpush.vilapp.features.home.presentation.HomeScreen
import br.com.gitpush.vilapp.features.login.presentation.LoginScreenRoute
import br.com.gitpush.vilapp.features.login.presentation.LoginViewModel
import org.koin.compose.viewmodel.koinViewModel

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
            val viewModel = koinViewModel<LoginViewModel>()
            LoginScreenRoute(viewModel) { route ->
                if (route == Routes.FORGOT_PASSWORD_ROUTE.name) {
                    navController.navigate(route)
                } else {
                    navController.navigate(route) {
                        popUpTo(Routes.LOGIN_ROUTE.name) {
                            inclusive = true
                        }
                    }
                }
            }
        }
        composable(route = Routes.HOME_ROUTE.name) {
            HomeScreen()
        }
        composable(route = Routes.FORGOT_PASSWORD_ROUTE.name) {
            ForgotPasswordRoute()
        }
    }
}
