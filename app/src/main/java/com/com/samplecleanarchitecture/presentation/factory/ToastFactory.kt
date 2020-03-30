package com.com.samplecleararchitecture.presentation.factory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.com.samplecleanarchitecture.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToastFactory @Inject constructor(private var context: Context) {

    private lateinit var toast: Toast
    private lateinit var view: View

    fun create(message: String) {

        if (::toast.isInitialized && toast.view?.isShown!!) toast.cancel()

        toast = Toast(context)

        if (!::view.isInitialized)
            view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null)

        toast.view = view
        toast.duration = Toast.LENGTH_LONG
        toast.view.findViewById<TextView>(R.id.message).setText(message)
        toast.show()


    }
}