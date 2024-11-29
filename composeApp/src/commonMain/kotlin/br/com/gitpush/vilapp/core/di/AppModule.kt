package br.com.gitpush.vilapp.core.di

fun appModule() = listOf(
    provideHttpClientModule,
    provideRepositoryModule,
    provideViewModelModule
)
