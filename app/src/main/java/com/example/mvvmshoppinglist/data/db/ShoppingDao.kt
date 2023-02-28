package com.example.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem

/** DAO Interface with functions to access the ShoppingDatabase.
 * Suspend functions are used as coroutines is used to access the SQLite database. */
@Dao
interface ShoppingDao {

    /** Updates/Inserts an item in the table.
     * OnConflictStrategy.REPLACE is used to replace the item if it shares the same id. */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    /** Deletes item from table. */
    @Delete
    suspend fun delete(item: ShoppingItem)

    /** Gets all shopping items.
     * Return type of <List<ShoppingItem>> is placed inside a LiveData object.
     * LiveData is a life-cycle aware data holder class and makes it efficient to update RecyclerViews. */
    @Query("SELECT * FROM shopping_item") //@Query is used to make an SQL query
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}