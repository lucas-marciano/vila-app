package br.com.gitpush.vilapp.core.routing

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import br.com.gitpush.vilapp.features.home.presentation.HomeRoute
import br.com.gitpush.vilapp.features.home.presentation.HomeViewModel
import br.com.gitpush.vilapp.features.login.presentation.acess.LoginScreenRoute
import br.com.gitpush.vilapp.features.login.presentation.acess.LoginViewModel
import br.com.gitpush.vilapp.features.login.presentation.forgot_pass.ForgotPassViewModel
import br.com.gitpush.vilapp.features.login.presentation.forgot_pass.ForgotPasswordRoute
import br.com.gitpush.vilapp.features.main.presentation.MainScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun Navigator(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Main.toString(),
        modifier = Modifier.fillMaxSize(),
    ) {
        composable(route = Login.toString()) {
            val viewModel = koinViewModel<LoginViewModel>()
            LoginScreenRoute(viewModel) { route ->
                if (route == Home.toString()) {
                    navController.navigate(route)
                } else {
                    navController.navigate(route) {
                        popUpTo(toString()) {
                            inclusive = true
                        }
                    }
                }
            }
        }
        composable(route = Main.toString()) {
            MainScreen()
        }
        composable(route = ForgotPassword.toString()) {
            val viewModel = koinViewModel<ForgotPassViewModel>()
            ForgotPasswordRoute(viewModel = viewModel)
        }
    }
}
