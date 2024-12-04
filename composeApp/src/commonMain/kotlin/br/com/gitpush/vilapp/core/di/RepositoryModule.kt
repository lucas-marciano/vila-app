package br.com.gitpush.vilapp.core.di

import br.com.gitpush.vilapp.home.data.HomeRepository
import br.com.gitpush.vilapp.home.data.HomeRepositoryImpl
import br.com.gitpush.vilapp.login.domain.LoginRepository
import br.com.gitpush.vilapp.login.data.repository.LoginRepositoryImpl
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single<HomeRepository> { HomeRepositoryImpl() }
}
