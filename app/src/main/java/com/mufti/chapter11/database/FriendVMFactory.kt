package com.mufti.chapter11.database

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FriendVMFactory(private var context: Context) :   ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FriendViewModel(AppDatabase.getInstance(context).friendDao()) as T
    }
}