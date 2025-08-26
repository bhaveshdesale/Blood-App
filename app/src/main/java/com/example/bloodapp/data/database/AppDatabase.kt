package com.example.bloodapp.data.database
// app/src/main/java/com/example/bloodapp/data/database/AppDatabase.kt


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bloodapp.data.dao.UserDao
import com.example.bloodapp.data.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "blood_app_db"

        // For debugging, you can add .setJournalMode(JournalMode.TRUNCATE)
        // or .fallbackToDestructiveMigration() during development
    }
}