package com.example.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quizapp.databinding.FragmentSigninBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentSigninBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)


        binding.createNewAccountButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }


        return binding.root
    }

}