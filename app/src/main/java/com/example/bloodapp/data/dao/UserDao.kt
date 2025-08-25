package com.example.bloodapp.data.dao

// app/src/main/java/com/example/bloodapp/data/dao/UserDao.kt

// app/src/main/java/com/example/bloodapp/data/dao/UserDao.kt


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bloodapp.data.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun getUserByEmailAndPassword(email: String, password: String): User?

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: Int): User?
}