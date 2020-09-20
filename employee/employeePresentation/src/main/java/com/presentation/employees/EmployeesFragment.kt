package com.presentation.employees

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.basepresentation.base.BaseFragment
import com.basepresentation.util.exhaustive
import com.presentation.EMPLOYEE_ID
import com.presentation.R
import com.presentation.databinding.FragmentEmployeesBinding
import com.presentation.di.PresentationInjector
import com.presentation.employee_detail.EmployeeDetail
import com.presentation.employees.adapter.EmployeesAdapter
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [EmployeesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
internal class EmployeesFragment : BaseFragment() {

    private lateinit var binding: FragmentEmployeesBinding

    private lateinit var viewModel: EmployeesViewModel

    @Inject
    lateinit var viewModelFactory: EmployeesViewModelFactory

    @Inject
    lateinit var adapter: EmployeesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmployeesBinding.inflate(inflater)


        return binding.root
    }


    override fun initializeComponents() {


        PresentationInjector
            .buildEmployeesComponent()
            .inject(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel = attachViewModel(viewModelFactory)

        observeUIEvents(viewModel)

    }

    override fun setObservers() {
        viewModel.events
            .observe(this, Observer {
                val event = it.getEventIfNotHandled()
                if (event != null)
                    when (event) {
                        is EmployeesEvents.EMPLOYEES_FETCHED -> {
                            adapter.addItems(event.list)
                        }
                        is EmployeesEvents.OPEN_EMPLOYEE_DETAIL -> {
                            requireFragmentManager()
                                .beginTransaction()
                                .replace(
                                    R.id.fragmentContainer,
                                    EmployeeDetail().apply {
                                        arguments = Bundle().apply {
                                            putInt(
                                                EMPLOYEE_ID, event.employeeId
                                            )
                                        }
                                    })
                                .addToBackStack(null)
                                .commit()
                        }
                    }.exhaustive
            })
    }

    override fun showLoader() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        binding.progressBar.visibility = View.GONE
    }
}