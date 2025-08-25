package com.example.bloodapp.data.repository
// app/src/main/java/com/example/bloodapp/data/repository/UserRepository.kt

// app/src/main/java/com/example/bloodapp/data/repository/UserRepository.kt


import com.example.bloodapp.data.dao.UserDao
import com.example.bloodapp.data.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun registerUser(user: User): Long {
        return userDao.insertUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.getUserByEmailAndPassword(email, password)
    }

    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }

    suspend fun getUserById(userId: Int): User? {
        return userDao.getUserById(userId)
    }
}