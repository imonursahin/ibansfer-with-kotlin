package com.example.ibanshare.viewsmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.ibanshare.utils.repo.IbanDaoRepo

class AddIbanViewModel(application: Application) : AndroidViewModel(application) {

    var ibanRepo = IbanDaoRepo(application)

    fun addData(ibanOwner: String, ibanBank: String, ibanNumber: String) {
        ibanRepo.addIban(ibanOwner, ibanBank, ibanNumber)
    }
}