package com.example.hippo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hippo.db.dao.BookmarkDao
import com.example.hippo.db.dao.MessageDao
import com.example.hippo.db.dao.UserDao
import com.example.hippo.db.entity.Bookmark
import com.example.hippo.db.entity.Message
import com.example.hippo.db.entity.User

@Database(entities = [User::class, Message::class, Bookmark::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun messageDao(): MessageDao
    abstract fun bookmarkDao(): BookmarkDao
}

fun Context.getAppDatabaseInstance(): AppDatabase {
    return Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "hippo"
    )
        .allowMainThreadQueries()
        .addMigrations(
            // reserved for future use
        )
        .fallbackToDestructiveMigration()
        .build()
}
