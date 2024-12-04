package br.com.gitpush.vilapp.core.di

import br.com.gitpush.vilapp.features.login.presentation.LoginViewModel
import org.koin.dsl.module

val provideViewModelModule = module {
    single {
        LoginViewModel(get())
    }
}
