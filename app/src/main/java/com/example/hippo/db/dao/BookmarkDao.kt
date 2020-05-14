package com.example.hippo.db.dao

import UserId
import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks")
    fun loadAll(): Single<List<UserId>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg userIds: UserId): Completable

    @Delete
    fun delete(userId: UserId): Completable
}
