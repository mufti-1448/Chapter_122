package com.mufti.chapter11.database

import com.mufti.chapter11.R
import com.mufti.chapter11.databinding.ActivityListTemanBinding


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListTemanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListTemanBinding

    @SuppressLint("UseSwitchCompatOrMaterialCode")


    private val data = ArrayList<Friend>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTemanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        initView()
    }

    private fun initView() {
        val friends = arrayOf(
            Friend("Mufti Ali", "SMK Syafii Akrom", "memancing", ),
            Friend("Fakih", "SMK Nurul Umah", "menyanyi" ),
            Friend("Ulil", "SMAN 1 Paninggaran", "Berenang" )
        )

        data.addAll(friends)

        val adapter = RvFriendAdapter(this) { position, data ->
            val destination = Intent(this@ListTemanActivity, DetailTemanActivity::class.java).apply {
                putExtra("nama", data.name)
                putExtra("sekolah", data.school)
                putExtra("Hobby", data.hobby)
            }
            startActivity(destination)
        }
        adapter.setData(data)

        binding.rvFriend.adapter = adapter
    }

}
