package com.mufti.chapter11.database

import android.util.Log
import androidx.lifecycle.ViewModel


class FriendViewModel(private val friendDao: FriendDao) : ViewModel() {

    fun getFriend() = friendDao.getAll()

    fun getFriendById(id: Int) = friendDao.getItemById(id)

    suspend fun insertFriend(data: Friend) {
        friendDao.insert(data)
    }

    suspend fun editFriend(data: Friend) {
        Log.d("DataNew", "TestViewModel 1")
        friendDao.editFriend(data)
        Log.d("DataNew", "TestViewModel 2")
    }

    suspend fun deleteFriend(data: Friend) {
        friendDao.delete(data)
    }
}