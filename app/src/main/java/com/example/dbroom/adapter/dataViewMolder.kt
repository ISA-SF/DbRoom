package com.example.dbroom.adapter

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.navegacion.DB.Registro
import com.example.navegacion.DB.RegistroDatabase

class dataViewMolder(app: Application)  : AndroidViewModel(app) {
    lateinit var allRegistros: MutableLiveData<List<Registro>>

    val regDao= RegistroDatabase.getDataBase(getApplication())?.registroDao()

    init {
        allRegistros = MutableLiveData()
    }

    fun getAllRegistrosObserver() : MutableLiveData<List<Registro>> {
        return allRegistros
    }
    fun getReg(){
        val list = regDao?.getRegistros()
        allRegistros.postValue(list)
    }
    fun insert(registro: Registro){
        regDao?.insert(registro)
        getReg()
    }
    fun update(registro: Registro){
        regDao?.update(registro)
        getReg()


    }
    fun delete(registro: Registro){
        regDao?.delete(registro)
        getReg()
    }

}


