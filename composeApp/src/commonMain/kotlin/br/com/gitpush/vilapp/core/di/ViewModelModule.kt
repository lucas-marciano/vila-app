package br.com.gitpush.vilapp.core.di

import br.com.gitpush.vilapp.login.presentation.LoginViewModel
import org.koin.dsl.module

val provideViewModelModule = module {
    single {
        LoginViewModel(get())
    }
}
