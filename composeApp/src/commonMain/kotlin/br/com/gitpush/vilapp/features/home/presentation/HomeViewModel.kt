package br.com.gitpush.vilapp.features.home.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import br.com.gitpush.vilapp.core.presentation.BaseViewModel
import androidx.lifecycle.viewModelScope
import br.com.gitpush.vilapp.features.home.domain.HomeData
import br.com.gitpush.vilapp.features.home.domain.HomeMenus
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    fun getData() {
        viewModelScope.launch {
            delay(3000)
            setState {
                copy(
                    loading = false,
                    success = mockHomeData()
                )
            }
        }
    }

    private fun mockHomeData() = HomeData(
        name = "Vila bela",
        function = "Morador",
        user = "Lucas Marciano",
        list = listOf(
            HomeMenus("item 1", Icons.Default.Home),
            HomeMenus("item 2", Icons.Default.Home),
            HomeMenus("item 3", Icons.Default.Home),
            HomeMenus("item 4", Icons.Default.Home),
            HomeMenus("item 5", Icons.Default.Home),
        )
    )

    override fun createInitialState(): HomeContract.State {
        return HomeContract.State()
    }

    override fun handleEvent(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.OnRedirectAction -> {
                // do something
            }

            is HomeContract.Event.OnMenuAction -> {
                // do something
            }

//            is HomeContract.Event.On__Action -> {
//                setEffect { HomeContract.Effect.ShowToast }
//            }
        }
    }
}
