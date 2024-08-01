package com.mufti.chapter11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mufti.chapter11.databinding.SaveMyNameActivityBinding

class SaveMyNameActivity : AppCompatActivity() {

    private lateinit var binding: SaveMyNameActivityBinding

    private lateinit var myPref : MySharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SaveMyNameActivityBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myPref = MySharedPref(this)
        binding.tvName.text = myPref.getName()

        binding.btnSave.setOnClickListener{
            val name = binding.etName.text.toString().trim()
            myPref.saveName(name)
            binding.tvName.text = myPref.getName()
        }
    }
}