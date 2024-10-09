package com.example.uts_android

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uts_android.databinding.ActivityMain2Binding
import com.example.uts_android.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("name")

        with(binding){
            txtName.text = name
            btnKeluar.setOnClickListener{
                val intentToThirdActivity =
                    Intent(this@MainActivity2, MainActivity3::class.java)
                intentToThirdActivity.putExtra("name", name)
                startActivity(intentToThirdActivity)
            }
        }
    }
}