package com.com.samplecleanarchitecture.presentation

import com.com.samplecleanarchitecture.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.com.samplecleanarchitecture.presentation.itemdetail.ItemDetail
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, ItemDetail())
            .commit()
    }
}
