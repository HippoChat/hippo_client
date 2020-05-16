package com.example.hippo.db.dao

import UserId
import androidx.room.*
import com.example.hippo.db.entity.User
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): Flowable<List<User>>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): Single<List<User>>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun loadById(userId: UserId): Single<Optional<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: User): Completable

    @Delete
    fun delete(user: User): Completable
}
