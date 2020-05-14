package com.example.hippo.db.entity

import AgeGroup
import UserId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Public information about users.
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: UserId,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age_group") val ageGroup: AgeGroup,
    @ColumnInfo(name = "language") val language: String,
    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB) val image: ByteArray
)
