package com.example.quizapp.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_signup, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)




        binding.alreadyAccountButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }


        // redirect to home screen
        binding.signupButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_signupFragment_to_homeFragment)
        }

        return binding.root
    }

}