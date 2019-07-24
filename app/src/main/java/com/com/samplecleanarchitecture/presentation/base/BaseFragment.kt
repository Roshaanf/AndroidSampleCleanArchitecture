package com.com.samplecleanarchitecture.presentation.base


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aapa.base.UIEvents
import com.com.samplecleanarchitecture.R
import com.com.samplecleanarchitecture.presentation.util.exhaustive

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return TextView(context).apply {
            setText(R.string.hello_blank_fragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initializeComponents()
        setObservers()
    }


    abstract fun initializeComponents()
    abstract fun setObservers()


    protected inline fun <reified V : ViewModel> attachViewModel(viewModelFactory: ViewModelProvider.Factory): V =
        ViewModelProviders.of(this, viewModelFactory).get(V::class.java)


    fun observeUIEvents(viewModel: BaseViewModel) {
        viewModel.obUiEvent.observe(viewLifecycleOwner, Observer {
            var event = it.getEventIfNotHandled()
            if (event != null)
                when (event) {
                    UIEvents.ShowLoader -> showLoader()

                    UIEvents.HideLoader ->
                        hideLoader()
                    is UIEvents.Exception ->
                        showException(event.message)

                    is UIEvents.Error ->
                        showError(event.message)

                    is UIEvents.Toast -> showToast(event.message)
                }.exhaustive
        })
    }


    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    protected fun showException(message: String) {
        showToast(message)
    }

    protected fun showError(message: String) {
        showToast(message)
    }

    abstract protected fun showLoader()
    abstract protected fun hideLoader()


}
