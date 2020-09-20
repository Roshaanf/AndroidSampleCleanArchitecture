package com.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.basepresentation.base.BaseActivity
import com.presentation.employees.EmployeesFragment


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(
                R.id.fragmentContainer,
                EmployeesFragment()
            )
            .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        // return true so that the menu pop up is opened
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.about -> {
                startActivity("com.aboutpresentation.AboutActivity")

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initiateInjection() {}

    override fun callAttachViewModel() {}

    override fun setObservers() {}

    override fun startObservingNavEvents() {}

    override fun showLoader() {}

    override fun hideLoader() {}


}