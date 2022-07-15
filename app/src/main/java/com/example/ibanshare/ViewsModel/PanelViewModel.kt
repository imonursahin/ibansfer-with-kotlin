package com.example.ibanshare.ViewsModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.ibanshare.Utils.Ibans
import com.example.ibanshare.Utils.repo.IbanDaoRepo

class PanelViewModel(application: Application) : AndroidViewModel(application) {

    var ibanRepo = IbanDaoRepo(application)
    var ibanList = MutableLiveData<List<Ibans>>()

    init {
        loadData()
        ibanList = ibanRepo.getIbans()
    }

    fun loadData() {
        ibanRepo.getAllIbans()
    }

    fun deleteData(ibanId: Int) {
        ibanRepo.deleteIban(ibanId)
    }
}