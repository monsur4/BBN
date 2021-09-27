package com.mon.bbn.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mon.bbn.entity.Contestant

class MainViewModel : ViewModel() {
    private val contestants : LiveData<List<Contestant>> = MutableLiveData()
    private var position: Int = 0

    fun getContestants() : LiveData<List<Contestant>> {
        return contestants
    }

    fun getPosition():Int{
        return position
    }

    fun setPosition(pos : Int){
        position = pos
    }

}