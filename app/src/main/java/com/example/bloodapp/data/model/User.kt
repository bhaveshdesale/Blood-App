package com.example.bloodapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fullName: String,
    val age: Int,
    val contactNumber: String,
    val email: String,
    val password: String
)