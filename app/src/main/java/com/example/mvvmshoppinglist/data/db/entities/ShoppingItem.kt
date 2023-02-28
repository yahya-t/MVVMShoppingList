package com.example.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/** ShoppingItem table */
@Entity(tableName = "shopping_item") //annotate that this is a database entity
data class ShoppingItem(
    @ColumnInfo(name = "item_name") //annotate column with name
    var name: String,
    @ColumnInfo(name = "item_amount") //annotate column with name
    var amount: Int,
) {
    @PrimaryKey(autoGenerate = true) //autogenerate PrimaryKeys
    var id: Int? = null
}