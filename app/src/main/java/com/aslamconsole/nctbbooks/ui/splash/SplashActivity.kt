package com.aslamconsole.nctbbooks.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.aslamconsole.nctbbooks.databinding.ActivitySplashBinding
import com.aslamconsole.nctbbooks.ui.auth.AuthViewModel
import com.aslamconsole.nctbbooks.ui.auth.LoginActivity
import com.aslamconsole.nctbbooks.ui.base.BaseActivity
import com.aslamconsole.nctbbooks.ui.category.CategoryActivity
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Aslam Hossin on 6/28/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private val viewModel: AuthViewModel by viewModels()
    private lateinit var binding: ActivitySplashBinding

    override fun initViewBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.isLogin()
    }

    override fun observeViewModel() {
        super.observeViewModel()
        viewModel.isLogin.observe(this, {
            if (it == true) startActivity(Intent(this, CategoryActivity::class.java))
            else startActivity(Intent(this, LoginActivity::class.java))
        })
    }


}