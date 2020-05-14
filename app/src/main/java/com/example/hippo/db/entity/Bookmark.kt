package com.example.hippo.db.entity

import UserId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class Bookmark(
    @PrimaryKey
    @ColumnInfo(name = "user_id") val userId: UserId
)
