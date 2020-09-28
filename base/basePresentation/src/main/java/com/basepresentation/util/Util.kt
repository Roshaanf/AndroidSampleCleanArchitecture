package com.basepresentation.util

// return null if cant be typecasted or else typecasted
public inline fun <reified T> Any.safeCast(): T? {
    return this as? T
}