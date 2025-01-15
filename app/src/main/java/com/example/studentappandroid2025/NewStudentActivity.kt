package com.example.studentappandroid2025

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val saveButton: Button = findViewById(R.id.btnSave)
        val cancelButton: Button = findViewById(R.id.btnCancel)

        val nameEditText: EditText = findViewById(R.id.nameInput)
        val idEditText: EditText = findViewById(R.id.idInput)
        val phoneEditText: EditText = findViewById(R.id.phoneInput)
        val addressEditText: EditText = findViewById(R.id.addressInput)
        val checkBox: CheckBox = findViewById(R.id.checkbox)

        saveButton.setOnClickListener {
            val student = Student(
                id = idEditText.text.toString(),
                name = nameEditText.text.toString(),
                phone = phoneEditText.text.toString(),
                address = addressEditText.text.toString(),
                isChecked = checkBox.isChecked
            )
            StudentsRepository.addStudent(student)
            setResult(RESULT_OK)
            finish()
        }

        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}