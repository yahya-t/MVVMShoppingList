package com.example.mvvmshoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem

/** Class representing the database "ShoppingDatabase"  */
@Database(
    entities = [ShoppingItem::class], //declare database entities in this array
    version = 1 //declare database version
)
abstract class ShoppingDatabase : RoomDatabase() {

    /** Allows access to the ShoppingDao interface functions */
    abstract fun getShoppingDao(): ShoppingDao

    /** Companion object to ensure there is only one instance of the database at a time.
     *  The @Volatile annotation means any writes to this instance of the ShoppingDatabase
     *  variable will be instantly made visible to other threads. */
    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        /** "operator fun invoke" is a function that executes whenever the ShoppingDatabase
         * class is instantiated.
         * Returns the "instance" of the ShoppingDatabase.
         * If it is null, then use a "synchronized block" (to make sure no other threads
         * accesses the ShoppingDatabase instance at the same time) and create
         * a new instance of ShoppingDatabase using another null-check. */
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        /** Creates the ShoppingDatabase */
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}