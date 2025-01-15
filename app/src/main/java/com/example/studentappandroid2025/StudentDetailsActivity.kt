package com.example.studentappandroid2025

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentId = intent.getStringExtra("studentId")
        val student = StudentsRepository.getStudentById(studentId ?: return)

        val nameTextView: TextView = findViewById(R.id.nameText)
        val idTextView: TextView = findViewById(R.id.idText)
        val phoneTextView: TextView = findViewById(R.id.phoneText)
        val addressTextView: TextView = findViewById(R.id.addressText)
        val checkBox: CheckBox = findViewById(R.id.checkbox)
        val editButton: Button = findViewById(R.id.btnEdit)
        val backButton: Button = findViewById(R.id.btnBack)

        student?.let {
            nameTextView.text = "Name: ${it.name}"
            idTextView.text = "ID: ${it.id}"
            phoneTextView.text = "Phone: ${it.phone}"
            addressTextView.text = "Address: ${it.address}"
            checkBox.isChecked = it.isChecked
        }

        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentId", studentId)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}