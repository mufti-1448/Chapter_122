package com.mufti.chapter11.database

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.mufti.chapter11.R
import com.mufti.chapter11.databinding.ActivityListFriendBinding
import kotlinx.coroutines.launch

class ListTemanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFriendBinding

    private var friendList = ArrayList<Friend>()

    private lateinit var viewModel: FriendViewModel
    private lateinit var adapter: AdapterRVFriend

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_friend)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_list_friend)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewModelFactory = FriendVMFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[FriendViewModel::class.java]

        adapter = AdapterRVFriend(this) { position, data ->
            val destination = Intent(this, AddFriendActivity::class.java).apply {
                putExtra("id", data.id)
            }
            startActivity(destination)
        }

        binding.rvShowData.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.getFriend().collect { friends ->
                        friendList.clear()
                        friendList.addAll(friends)
                        adapter.setData(friendList)
                    }
                }
            }
        }

        binding.ftbnAdd.setOnClickListener {
            val destination = Intent(this, AddFriendActivity::class.java)
            startActivity(destination)
        }

    }

}