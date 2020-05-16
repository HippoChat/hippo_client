package com.example.hippo.db.dao

import MessageId
import UserId
import androidx.room.*
import com.example.hippo.db.entity.Message
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

@Dao
interface MessageDao {
    @Query("""
        SELECT *
        FROM messages
        WHERE (sender = :peerId OR receiver = :peerId)
        ORDER BY id ASC
    """)
    fun getChatHistory(peerId: UserId): Flowable<List<Message>>

    @Query("""
        SELECT *
        FROM messages
        WHERE (sender = :peerId OR receiver = :peerId)
        ORDER BY id DESC
        LIMIT 1
    """)
    fun getLastMessage(peerId: UserId): Flowable<Optional<Message>>

    @Query("SELECT * FROM messages WHERE id = :mid")
    fun getById(mid: MessageId): Single<Optional<Message>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(message: Message): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg messages: Message): Completable

    @Delete
    fun delete(message: Message): Completable

    @Delete
    fun deleteAll(vararg messages: Message): Completable

    @Query("""
        DELETE FROM messages
        WHERE (sender = :peerId OR receiver = :peerId)
    """)
    fun deleteChatHistory(peerId: UserId): Completable
}
