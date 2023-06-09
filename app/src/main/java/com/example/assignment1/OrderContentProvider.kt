package com.example.assignment1

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri



class OrderContentProvider : ContentProvider() {

    private lateinit var dbHelper: OrderDbHelper

    override fun onCreate(): Boolean {
        dbHelper = OrderDbHelper(context!!)
        return true
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            OrderContract.OrderEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )
        cursor.setNotificationUri(context?.contentResolver, uri)
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val db = dbHelper.writableDatabase
        val orderId = db.insert(OrderContract.OrderEntry.TABLE_NAME, null, values)
        if (orderId > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return ContentUris.withAppendedId(OrderContract.OrderEntry.CONTENT_URI, orderId)
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        val db = dbHelper.writableDatabase
        val rowsUpdated = db.update(
            OrderContract.OrderEntry.TABLE_NAME,
            values,
            selection,
            selectionArgs
        )
        if (rowsUpdated > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return rowsUpdated
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val db = dbHelper.writableDatabase
        val rowsDeleted = db.delete(
            OrderContract.OrderEntry.TABLE_NAME,
            selection,
            selectionArgs
        )
        if (rowsDeleted > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return rowsDeleted
    }
}
