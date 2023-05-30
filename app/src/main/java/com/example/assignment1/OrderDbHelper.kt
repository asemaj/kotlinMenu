package com.example.assignment1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri

class OrderDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "order"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "Order"
        private const val ID = "id"
        private const val ORDER_PRICE = "OrderPrice"
        private const val ORDER_DETAILS = "OrderDetail"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Create the orders table
        val create_table = "CREATE TABLE '$TABLE_NAME' ($ID INTEGER PRIMARY KEY, $ORDER_PRICE INTEGER, $ORDER_DETAILS TEXT);"
        db?.execSQL(create_table)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database upgrades if necessary
        // You can implement logic here to migrate data from older versions to newer versions
    }

}




object OrderContract {
    // Table name
    object OrderEntry {
        const val TABLE_NAME = "orders"
        const val COLUMN_ORDER_ID = "_id"
        const val COLUMN_CUSTOMER_NAME = "customer_name"
        const val COLUMN_ORDER_ITEMS = "order_items"
        const val COLUMN_ORDER_QUANTITY = "order_quantity"

        // Content URI for the orders table
        val CONTENT_URI: Uri = Uri.withAppendedPath(
            Uri.parse("com.example.assignment1"),
            TABLE_NAME
        )
    }
}
