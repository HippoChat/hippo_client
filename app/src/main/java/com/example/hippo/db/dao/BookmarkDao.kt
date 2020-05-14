package com.example.hippo.db.dao

import androidx.room.*
import com.example.hippo.db.entity.Bookmark
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks")
    fun loadAll(): Single<List<Bookmark>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg bookmark: Bookmark): Completable

    @Delete
    fun delete(bookmark: Bookmark): Completable
}
