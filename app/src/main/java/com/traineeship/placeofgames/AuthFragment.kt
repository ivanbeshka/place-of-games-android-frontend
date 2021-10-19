package com.traineeship.placeofgames

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.placeofgames.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.traineeship.placeofgames.data.LoginData
import com.traineeship.placeofgames.utils.TokenUtil
import com.traineeship.placeofgames.viewmodels.AuthViewModel

class AuthFragment : Fragment() {

    private val authViewModel: AuthViewModel by viewModels()

    private lateinit var etLogin: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var btnLogin: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)
        initViews(view)

        btnLogin.setOnClickListener {
            val password = etPassword.text.toString()
            val login = etLogin.text.toString()
            val loginData = LoginData(login, password)

            authViewModel.getTokenLiveData(loginData).observe(viewLifecycleOwner) {
                val tokenUtil = TokenUtil(requireContext())
                tokenUtil.token = it.value
            }
        }

        return view
    }

    private fun initViews(view: View){
        etLogin = view.findViewById(R.id.et_login)
        etPassword = view.findViewById(R.id.et_password)
        btnLogin = view.findViewById(R.id.btn_login)
    }
}