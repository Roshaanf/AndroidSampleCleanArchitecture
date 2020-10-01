package com.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Employee constructor(
    var id: Int? = null,
    var name: String? = null,
    var salary: String? = null,
    var age: String? = null,
    var image: String? = null
) : Parcelable