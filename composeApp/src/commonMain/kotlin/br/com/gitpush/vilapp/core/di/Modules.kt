package br.com.gitpush.vilapp.core.di

import br.com.gitpush.vilapp.core.data.HttpClientFactory
import br.com.gitpush.vilapp.features.login.data.api.RemoteLoginDataSource
import br.com.gitpush.vilapp.features.login.data.api.RemoteLoginDataSourceImpl
import br.com.gitpush.vilapp.features.login.domain.LoginRepository
import br.com.gitpush.vilapp.features.login.data.repository.LoginRepositoryImpl
import br.com.gitpush.vilapp.features.login.presentation.LoginViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::RemoteLoginDataSourceImpl).bind<RemoteLoginDataSource>()
    singleOf(::LoginRepositoryImpl).bind<LoginRepository>()

    viewModelOf(::LoginViewModel)
}
