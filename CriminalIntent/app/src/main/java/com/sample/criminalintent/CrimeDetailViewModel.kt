package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.sample.criminalintent.Crime
import com.sample.criminalintent.CrimeRepository
import java.util.*

class CrimeDetailViewModel() : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> =
        crimeIdLiveData.switchMap { crimeId ->
            crimeRepository.getCrime(crimeId)
        }

    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId
    }

    fun saveCrime(crime: Crime) {
        crimeRepository.updateCrime(crime)
    }
}