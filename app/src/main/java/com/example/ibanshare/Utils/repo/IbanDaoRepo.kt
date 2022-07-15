package com.example.ibanshare.Utils.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.ibanshare.Utils.Ibans
import com.example.ibanshare.Utils.room.Db
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class IbanDaoRepo(var application: Application) {
    var ibanList = MutableLiveData<List<Ibans>>()
    var db: Db

    init {
        db = Db.getInstance(application)!!
        ibanList = MutableLiveData()
    }

    fun getIbans(): MutableLiveData<List<Ibans>> {
        return ibanList
    }

    fun getAllIbans() {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            ibanList.value = db.IbanDao().getAllIbans()
        }
    }

    fun addIban(ibanOwner: String, ibanBank: String, ibanNumber: String) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val newIban = Ibans(0, ibanOwner, ibanBank, ibanNumber)
            db.IbanDao().addIban(newIban)
        }
    }

    fun deleteIban(ibanId: Int) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val deletedIban = Ibans(ibanId, "", "", "")
            db.IbanDao().deleteIban(deletedIban)
            getAllIbans()
        }
    }


}