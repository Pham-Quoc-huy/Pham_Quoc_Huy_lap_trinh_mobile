package com.example.baithuchanh1


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener {
            val name = etName.text.toString()
            val ageText = etAge.text.toString()
            val age = ageText.toIntOrNull() ?: -1

            val category = when {
                age < 0 -> "Tuổi không hợp lệ"
                age <= 2 -> "Em bé"
                age in 3..6 -> "Trẻ em"
                age in 7..65 -> "Người lớn"
                else -> "Người già"
            }

            tvResult.text = "Tên: $name\nKết quả: $category"
        }
    }
}