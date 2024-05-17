package com.upstox.di

import com.upstox.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, CryptoModule::class])
interface CryptoListComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(forthCodeListViewModelFactory: CryptoListViewModelFactory)

}