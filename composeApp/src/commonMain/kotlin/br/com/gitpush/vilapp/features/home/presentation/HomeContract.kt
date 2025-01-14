package br.com.gitpush.vilapp.features.home.presentation

import br.com.gitpush.vilapp.core.presentation.UiEffect
import br.com.gitpush.vilapp.core.presentation.UiEvent
import br.com.gitpush.vilapp.core.presentation.UiState
import br.com.gitpush.vilapp.features.home.domain.HomeData

class HomeContract {
    sealed class Event : UiEvent {
        data object OnMenuAction : Event()
        data class OnRedirectAction(val route: String) : Event()
    }

    data class State(
        val success: HomeData = HomeData(),
        val loading: Boolean = true,
    ) : UiState

    sealed class Effect : UiEffect {
        data object ShowToast : Effect()
        data class RouteTo(val route: String) : Effect()
    }
}
