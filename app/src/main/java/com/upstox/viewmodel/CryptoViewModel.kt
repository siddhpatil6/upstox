package com.upstox.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upstox.data.CryptoItem
import com.upstox.usecase.CryptoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CryptoViewModel @Inject constructor(private val forthCodeListUseCase: CryptoUseCase):
    ViewModel() , LifecycleObserver {

    var photosItem = MutableLiveData<List<CryptoItem>>()

    fun getListOfPhotos(){
        viewModelScope.launch {
            val data = forthCodeListUseCase.getListOfPhotos()
            photosItem.postValue(data)
        }
    }
}