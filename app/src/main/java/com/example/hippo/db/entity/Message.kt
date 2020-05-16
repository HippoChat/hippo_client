package com.example.hippo.db.entity

import MessageId
import UserId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Public information about users.
 */
@Entity(tableName = "messages")
data class Message(
    // TODO: foreign key
    @ColumnInfo(name = "sender") val sender: UserId,
    @ColumnInfo(name = "receiver") val receiver: UserId,
    @ColumnInfo(name = "message") val message: String?,
    @PrimaryKey(autoGenerate = true) val id: MessageId = 0
)
