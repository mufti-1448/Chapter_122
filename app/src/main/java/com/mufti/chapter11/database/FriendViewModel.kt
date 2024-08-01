package com.mufti.chapter11.database

import androidx.lifecycle.ViewModel

class FriendViewModel(private val friendDao: FriendDao) : ViewModel() {

    fun getFriend() = friendDao.getAll()

    suspend fun insertFriend(data: Friend) {
        friendDao.Insert(data)
    }
}