package com.basepresentation.factory

import android.text.SpannableString
import com.basepresentation.di.scope.BasePresentationScope
import javax.inject.Inject

@BasePresentationScope
class SpannableStringFactory @Inject constructor() {

    fun create(string: String): SpannableString = SpannableString(string)
}