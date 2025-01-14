package br.com.gitpush.vilapp.features.home.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.gitpush.vilapp.features.home.presentation.components.ExitIcon
import br.com.gitpush.vilapp.features.home.presentation.components.Loading
import br.com.gitpush.vilapp.features.home.presentation.components.MainCardHome
import br.com.gitpush.vilapp.features.home.presentation.components.ShortCutCard
import br.com.gitpush.vilapp.ui.components.topbar.MainTopBar
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_name_app

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = koinViewModel(), onRedirectAction: (String) -> Unit = {}
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    viewModel.getData()

    HomeScreen(state = state, onAction = { action ->
        when (action) {
            is HomeContract.Event.OnRedirectAction -> {
                onRedirectAction(action.route)
            }

            else -> Unit
        }
        viewModel.handleEvent(action)
    })
}

@Composable
fun HomeScreen(
    state: HomeContract.State = HomeContract.State(),
    onAction: (HomeContract.Event) -> Unit = {}
) {
    AnimatedContent(state.loading) { isLoading ->
        if (!isLoading) {
            Scaffold(topBar = {
                MainTopBar(title = stringResource(Res.string.vila_app_name_app),
                    actionIcon = { ExitIcon(onAction) })
            }) {

                MainCardHome(
                    condominiumName = state.success.name,
                    residentName = state.success.user,
                    residentType = state.success.function,
                )

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(200.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    items(items = state.success.list, key = { it.name }) {
                        ShortCutCard(
                            item = it
                        )
                    }
                }
            }
        } else {
            Loading()
        }
    }
}
