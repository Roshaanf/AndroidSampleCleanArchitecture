package com.com.samplecleararchitecture.presentation.factory

import android.text.SpannableString
import com.com.samplecleararchitecture.presentation.di.screen.scope.ScreenScope
import javax.inject.Inject

@ScreenScope
class SpannableStringFactory @Inject constructor() {

    fun create(string: String): SpannableString = SpannableString(string)
}