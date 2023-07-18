package com.example.quizapp.authentication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentSigninBinding
    private lateinit var auth: FirebaseAuth

    companion object {
        var result = 0
        var totalQuestions = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)


        auth = Firebase.auth



        binding.loginButton.setOnClickListener {
            loginWithEmailAndPassword(
                binding.emailEditText.text.toString().trim(),
                binding.passwordEditText.text.toString().trim()
            )
        }


        binding.createNewAccountButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }



        return binding.root
    }

    private fun loginWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)

            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // User creation successful, retrieve the user
                    val user: FirebaseUser? = auth.currentUser
                    // Proceed with further actions
                } else {
                    Toast.makeText(
                        context,
                        "Authentication failed: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
    }


    override fun onStart() {
        super.onStart()
    }
}