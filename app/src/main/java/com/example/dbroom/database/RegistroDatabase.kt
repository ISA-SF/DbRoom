package com.example.navegacion.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Registro::class], version = 1)
abstract class RegistroDatabase : RoomDatabase() {
    abstract fun registroDao(): RegistroDao


    companion object{
        private var INSTANCE: RegistroDatabase? = null
        fun getDataBase(context: Context) : RegistroDatabase?{
            if (INSTANCE == null){
                INSTANCE= Room.databaseBuilder<RegistroDatabase>(
                    context.applicationContext, RegistroDatabase::class.java, "DB"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

    }



}