package com.example.bloodapp.data.model

// app/src/main/java/com/example/vitalconnect/data/model/User.kt
// app/src/main/java/com/example/bloodapp/data/entity/User.kt
// app/src/main/java/com/example/bloodapp/data/entity/User.kt

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
    val password: String,
    val bloodType: String? = null,
    val weight: Int? = null,
    val address: String? = null
)