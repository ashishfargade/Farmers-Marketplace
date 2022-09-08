package com.example.farmersmarket.userDatabase

import android.util.Log
import com.example.farmersmarket.marketDB.MarketDao

class RegisterRepository(private val dao: RegisterDatabaseDao) {
    val users = dao.getAllUsers()
    suspend fun insert(user: RegisterEntity) {
        return dao.insert(user)
    }

    suspend fun getUserName(userName: String):RegisterEntity?{
        return dao.getUsername(userName)
    }
}