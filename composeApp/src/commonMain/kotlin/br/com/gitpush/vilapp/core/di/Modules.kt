package br.com.gitpush.vilapp.core.di

import br.com.gitpush.vilapp.core.data.HttpClientFactory
import br.com.gitpush.vilapp.features.login.data.api.RemoteLoginDataSource
import br.com.gitpush.vilapp.features.login.data.api.RemoteLoginDataSourceImpl
import br.com.gitpush.vilapp.features.login.domain.LoginRepository
import br.com.gitpush.vilapp.features.login.data.repository.LoginRepositoryImpl
import br.com.gitpush.vilapp.features.login.presentation.acess.LoginViewModel
import br.com.gitpush.vilapp.features.login.presentation.forgot_pass.ForgotPassViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }

    // Login feature
    singleOf(::RemoteLoginDataSourceImpl).bind<RemoteLoginDataSource>()
    singleOf(::LoginRepositoryImpl).bind<LoginRepository>()
    viewModelOf(::LoginViewModel)
    viewModelOf(::ForgotPassViewModel)
}
