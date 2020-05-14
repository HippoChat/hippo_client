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
    @PrimaryKey val id: MessageId,
    // TODO: convert to DateTime with type converters
    @ColumnInfo(name = "timestamp") val timestamp: String,
    @ColumnInfo(name = "incoming") val incoming: Boolean,
    // TODO: foreign key
    @ColumnInfo(name = "sender") val sender: UserId,
    @ColumnInfo(name = "receiver") val receiver: UserId,
    @ColumnInfo(name = "message") val message: String?,
    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB) val image: ByteArray?,
    // TODO: foreign key
    @ColumnInfo(name = "reply_to_message_id") val replyToMessageId: MessageId?
)
