package com.example.uts_android

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.uts_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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

        with(binding){
            btnSubmit.setOnClickListener{
                checkFieldsAndShowAlert();
            }
        }
    }
    private fun checkFieldsAndShowAlert() {
        val name = binding.edtName.text.toString()

        if (name.isEmpty()) {
            Toast.makeText(this, "Enter your name first", Toast.LENGTH_SHORT).show()
        } else {
            val intentToThirdActivity =
                Intent(this@MainActivity, MainActivity2::class.java)
            intentToThirdActivity.putExtra("name", name)
            startActivity(intentToThirdActivity)
        }
    }
}