package com.example.ibanshare.viewsmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ibanshare.viewsmodel.AddIbanViewModel

class AddIbanViewModelFactory(var application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddIbanViewModel(application) as T
    }
}