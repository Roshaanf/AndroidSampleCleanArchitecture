package com.basepresentation.base


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.basepresentation.R
import com.basepresentation.util.exhaustive

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
abstract class BaseFragment : Fragment() {

    val TAG = "BaseFragment ${this.javaClass.simpleName}"

    init {
        Log.d(TAG, "init")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "OnCreateView")

        return TextView(context).apply {
            setText(R.string.hello_blank_fragment)
        }
    }

    override fun onAttach(context: Context) {
        initiateInjection()
        super.onAttach(context)
        Log.d(TAG, "OnAttach")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeComponents()
        setObservers()

        Log.d(TAG, "OnViewCreated")
    }

    /*
     * override this function and initate dependency injection
     **/
    abstract protected fun initiateInjection()

    /*
     * Override this function and perform UI operations call observeUiEvents in this function
     **/
    abstract fun initializeComponents()

    /*
     * Override thisfunction to observe viwmodel obervalbles
     **/
    abstract fun setObservers()

    protected inline fun <reified V : ViewModel> attachViewModel(viewModelFactory: ViewModelProvider.Factory): V =
        ViewModelProvider(this, viewModelFactory).get(V::class.java)


    //    call this inside initialize components and pass viewmodel
    fun observeUIEvents(viewModel: BaseViewModel) {
        viewModel.obUiEvent.observe(viewLifecycleOwner, Observer {
            var event = it.getEventIfNotHandled()
            if (event != null)
                when (event) {
                    UIEvents.ShowLoader -> showLoader()

                    UIEvents.HideLoader ->
                        hideLoader()
                    is UIEvents.Error ->
                        showError(event.message)

                    is UIEvents.Toast -> showToast(event.message)
                }.exhaustive
        })
    }


    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    protected fun showError(message: String) {
        showToast(message)
    }

    abstract protected fun showLoader()
    abstract protected fun hideLoader()


    fun startActivity(className: String) {
        val intent = Intent(
            requireContext(),
            Class.forName(className)
        )
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
    }
}
