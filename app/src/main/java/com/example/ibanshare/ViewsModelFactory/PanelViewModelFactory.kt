package com.example.ibanshare.viewsmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ibanshare.viewsmodel.PanelViewModel

class PanelViewModelFactory(var application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PanelViewModel(application) as T
    }
}