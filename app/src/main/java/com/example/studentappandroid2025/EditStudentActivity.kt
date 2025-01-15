package com.example.studentappandroid2025

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val nameEditText: EditText = findViewById(R.id.nameEdit)
        val idEditText: EditText = findViewById(R.id.idEdit)
        val phoneEditText: EditText = findViewById(R.id.phoneEdit)
        val addressEditText: EditText = findViewById(R.id.addressEdit)
        val checkBox: CheckBox = findViewById(R.id.checkbox)
        val saveButton: Button = findViewById(R.id.btnSave)
        val deleteButton: Button = findViewById(R.id.btnDelete)
        val cancelButton: Button = findViewById(R.id.btnCancel)

        val studentId = intent.getStringExtra("studentId")
        val student = StudentsRepository.getStudentById(studentId ?: return)

        student?.let {
            nameEditText.setText(it.name)
            idEditText.setText(it.id)
            phoneEditText.setText(it.phone)
            addressEditText.setText(it.address)
            checkBox.isChecked = it.isChecked
        }

        saveButton.setOnClickListener {
            student?.apply {
                name = nameEditText.text.toString()
                id = idEditText.text.toString()
                phone = phoneEditText.text.toString()
                address = addressEditText.text.toString()
                isChecked = checkBox.isChecked
                StudentsRepository.updateStudent(this)
            }
            finish()
        }

        deleteButton.setOnClickListener {
            student?.id?.let { StudentsRepository.deleteStudent(it) }
            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }
    }
}