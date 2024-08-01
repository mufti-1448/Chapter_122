package com.mufti.chapter11.database

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.mufti.chapter11.R
import com.mufti.chapter11.databinding.ActivityDetailTemanBinding


class DetailTemanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTemanBinding
    private lateinit var foto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_teman)
        initView()
        setupEdgeToEdge()
    }

    private fun initView() {
        val namaTeman = intent.getStringExtra("nama")
        val sekolahTeman = intent.getStringExtra("sekolah")
        val hobbyTeman = intent.getStringExtra("hobby")

        Log.d("DetailTemanActivity", "Received data: nama=$namaTeman, sekolah=$sekolahTeman, hobby=$hobbyTeman")

        binding.namaTeman = namaTeman ?: "Nama tidak tersedia"
        binding.sekolahTeman = sekolahTeman ?: "Sekolah tidak tersedia"
        binding.hobbyTeman = hobbyTeman ?: "Nama hobby tidak tersedia"

    }

    private fun setupEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
