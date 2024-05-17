package com.upstox.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.upstox.usecase.CryptoUseCase
import com.upstox.viewmodel.CryptoViewModel
import javax.inject.Inject

class CryptoListViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var cryptoUseCase: CryptoUseCase


    init {
        DaggerCryptoListComponent.builder().build().inject(this)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CryptoViewModel::class.java)) {
            return CryptoViewModel(cryptoUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}