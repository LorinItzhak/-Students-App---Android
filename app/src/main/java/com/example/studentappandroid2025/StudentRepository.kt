package com.example.studentappandroid2025

object StudentsRepository {
    private val students = mutableListOf<Student>()

    fun getAllStudents(): List<Student> = students

    fun getStudentById(id: String): Student? = students.find { it.id == id }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(updatedStudent: Student) {
        val index = students.indexOfFirst { it.id == updatedStudent.id }
        if (index != -1) {
            students[index] = updatedStudent
        }
    }

    fun deleteStudent(id: String) {
        students.removeAll { it.id == id }
    }
}