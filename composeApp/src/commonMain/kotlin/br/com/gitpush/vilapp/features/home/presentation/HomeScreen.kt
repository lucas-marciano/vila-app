package br.com.gitpush.vilapp.features.home.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.gitpush.vilapp.core.presentation.components.Loading
import br.com.gitpush.vilapp.features.home.presentation.components.MainCardHome
import br.com.gitpush.vilapp.features.home.presentation.components.MenuList
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_label_agendas
import vilapp.composeapp.generated.resources.vila_app_label_warning

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
            Column(
                modifier = Modifier
                    .background(VilaTheme.colors.background)
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    ),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                MainCardHome(
                    condominiumName = state.success.name,
                    residentName = state.success.user,
                    residentType = state.success.function,
                )

                // sessão de avisos

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(Res.string.vila_app_label_warning),
                    style = VilaTheme.typography.h1
                )

                MenuList(
                    menus = state.success.warnings,
                    addAction = {
                        onAction(HomeContract.Event.OnRedirectAction("add"))
                    }
                )

                // sessão de agenda

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = stringResource(Res.string.vila_app_label_agendas),
                    style = VilaTheme.typography.h1
                )

                MenuList(
                    menus = state.success.agenda,
                    addAction = {
                        onAction(HomeContract.Event.OnRedirectAction("agenda"))
                    }
                )
            }
        } else {
            Loading()
        }
    }
}
