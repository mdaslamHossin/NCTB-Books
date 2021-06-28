package com.aslamconsole.nctbbooks.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aslamconsole.nctbbooks.databinding.ActivityHomeBinding
import com.aslamconsole.nctbbooks.databinding.ActivityLoginBinding
import com.aslamconsole.nctbbooks.ui.base.BaseActivity
import com.aslamconsole.nctbbooks.utils.startHomeActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@AndroidEntryPoint
class LoginActivity : BaseActivity(), AuthListener {

    private val viewModel:AuthViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        binding.progressbar.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        binding.progressbar.visibility = View.GONE
        startHomeActivity()
    }

    override fun onFailure(message: String) {
        binding.progressbar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        viewModel.user?.let {
            startHomeActivity()
        }
    }
}