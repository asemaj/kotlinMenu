//package com.example.assignment1
//
//import android.os.Parcel
//import android.os.Parcelable
//
//data class FoodItem(val name: String, val image: Int, val price: Double) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readString() ?: "",
//        parcel.readInt(),
//        parcel.readDouble()
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeInt(image)
//        parcel.writeDouble(price)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<FoodItem> {
//        override fun createFromParcel(parcel: Parcel): FoodItem {
//            return FoodItem(parcel)
//        }
//
//        override fun newArray(size: Int): Array<FoodItem?> {
//            return arrayOfNulls(size)
//        }
//    }
//}
