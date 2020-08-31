package com.aboutpresentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aboutpresentation.databinding.ActivityAboutBinding
import com.aboutpresentation.di.PresentationInjector
import com.basepresentation.base.BaseActivity
import javax.inject.Inject

class AboutActivity : BaseActivity() {

    private lateinit var viewModel: AboutUsViewModel

    @Inject
    lateinit var viewModelFactory: AboutUsViewModelFactory

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_about)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


    }

    override fun initiateInjection() {
        PresentationInjector.create().inject(this)
    }

    override fun callAttachViewModel() {
        viewModel = attachViewModel(viewModelFactory)
    }

    override fun setObservers() {
    }

    override fun startObservingNavEvents() {
    }

    override fun showLoader() {
    }

    override fun hideLoader() {
    }
}