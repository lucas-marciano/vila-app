package br.com.gitpush.vilapp.features.home.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.gitpush.vilapp.features.home.presentation.components.ExitIcon
import br.com.gitpush.vilapp.features.home.presentation.components.Loading
import br.com.gitpush.vilapp.features.home.presentation.components.MainCardHome
import br.com.gitpush.vilapp.features.home.presentation.components.MenuList
import br.com.gitpush.vilapp.features.home.presentation.components.ShortCutMenuCard
import br.com.gitpush.vilapp.ui.components.topbar.MainTopBar
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_label_agendas
import vilapp.composeapp.generated.resources.vila_app_label_warning
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
    state: HomeContract.State = HomeContract.State(), onAction: (HomeContract.Event) -> Unit = {}
) {
    AnimatedContent(state.loading) { isLoading ->
        if (!isLoading) {
            Scaffold(topBar = {
                MainTopBar(title = stringResource(Res.string.vila_app_name_app), actionIcon = {
                    ExitIcon(onAction)
                })
            }) { padding ->
                Column(
                    modifier = Modifier.padding(top = padding.calculateTopPadding(), start = 8.dp)
                        .background(VilaTheme.colors.background),
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

                    MenuList(menus = state.success.warnings,
                        addAction = {
                            onAction(HomeContract.Event.OnRedirectAction("add"))
                        }
                    )

                    // sessão de agenda

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
            }
        } else {
            Loading()
        }
    }
}
