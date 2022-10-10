package com.example.navegacion.DB

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RegistroDao {

    @Insert
    fun insert(registro: Registro)

    @Update
    fun update(registro: Registro)

    @Delete
    fun delete(registro: Registro)

    @Query("SELECT * FROM registro")
    fun getRegistros() : List<Registro>



}