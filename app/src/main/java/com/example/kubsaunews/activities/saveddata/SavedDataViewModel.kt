package com.example.kubsaunews.activities.saveddata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kubsaunews.datasourse.db.CharacterDB
import com.example.kubsaunews.datasourse.db.DataForDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import com.example.kubsaunews.repository.DbRepositoryImpl

class SavedDataViewModel(application: Application) :AndroidViewModel(application) {

    private val _liveDataListSavedData: MutableLiveData<List<DataForDb>> = MutableLiveData<List<DataForDb>>()
    val liveDataListSavedData:LiveData<List<DataForDb>> = _liveDataListSavedData

    private val db: CharacterDB = DbRepositoryImpl(application).characterDB
    var jobLoadAll: Job? = null
    var jobDeleteData:Job? = null

    fun getAllDataFromDb(){
        jobLoadAll = CoroutineScope(Dispatchers.IO).launch {
            val list = db.charactersDao().loadAllFromDb()
            if (list.isNotEmpty()){
                _liveDataListSavedData.postValue(list)
            }
            else{
                _liveDataListSavedData.postValue(emptyList())
                throw Exception("Db is Empty!!!")
            }
        }
    }

    fun deleteData(d:DataForDb){
        jobDeleteData = CoroutineScope(Dispatchers.IO).launch {
            db.charactersDao().deleteCharacter(d)
        }
    }



    override fun onCleared() {
        super.onCleared()

        jobLoadAll?.cancel()
        jobDeleteData?.cancel()
    }
}