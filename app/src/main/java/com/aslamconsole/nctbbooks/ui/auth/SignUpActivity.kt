package com.aslamconsole.nctbbooks.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.aslamconsole.nctbbooks.databinding.ActivitySignupBinding
import com.aslamconsole.nctbbooks.ui.base.BaseActivity
import com.aslamconsole.nctbbooks.ui.category.CategoryActivity
import com.aslamconsole.nctbbooks.utils.startHomeActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@AndroidEntryPoint
class SignUpActivity : BaseActivity(), AuthListener {

    private val viewModel: AuthViewModel by viewModels()
    private lateinit var binding: ActivitySignupBinding
    override fun initViewBinding() {
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
        Intent(this, CategoryActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }

    override fun onSuccess() {
        binding.progressbar.visibility = View.GONE
        startHomeActivity()
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}