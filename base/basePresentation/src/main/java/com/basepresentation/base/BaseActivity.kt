package com.basepresentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.basepresentation.util.exhaustive
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initiateInjection()
        callAttachViewModel()
        startObservingNavEvents()
        setObservers()
    }

    /*
    * override this function and initate dependency injection
    **/
    abstract protected fun initiateInjection()

    /*
    * overirde this method and call attachViewModel inside this function
    * */
    abstract protected fun callAttachViewModel()

    /*
    * Override thisfunction to observe viwmodel obervalbles
    * */
    abstract protected fun setObservers()

    /*
    * Override this function to oberve navigation listener
    * */
    abstract protected fun startObservingNavEvents()

    protected inline fun <reified V : ViewModel> attachViewModel(viewModelFactory: ViewModelProvider.Factory): V =
        ViewModelProvider(this, viewModelFactory).get(V::class.java)

    fun observeDataEvents(viewModel: BaseViewModel) {
        viewModel.obUiEvent.observe(this, Observer {
            var event = it.getEventIfNotHandled()
            if (event != null)
                when (event) {
                    UIEvents.ShowLoader -> showLoader()
                    UIEvents.HideLoader -> hideLoader()
                    is UIEvents.Error -> showError(event.message)
                    is UIEvents.Toast -> showToast(event.message)
                }.exhaustive
        })
    }

    open protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }

    open protected fun showError(message: String) {
        showToast(message)
    }

    abstract protected fun showLoader()
    abstract protected fun hideLoader()


}