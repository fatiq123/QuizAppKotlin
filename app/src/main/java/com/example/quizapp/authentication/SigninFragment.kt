package com.example.quizapp.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentSigninBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentSigninBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth    // initializing the firebase auth

        // getting email and password from text fields
        binding.loginButton.setOnClickListener {

            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginWithEmailAndPassword(email = email, password = password)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please enter valid email and password.",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }


        binding.createNewAccountButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }


    }



    private fun loginWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)

            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign-in successful, navigate to the next screen or perform other actions
//                    Toast.makeText(
//                        requireContext(),
//                        "Sign in successful!",
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                    // Navigate to the next screen, for example, the HomeFragment
//                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)


                    // Sign-in successful, navigate to the HomeFragment
                    gotoHomeScreen()

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


    // if the user already exists we will check it onStart
    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser

        if (currentUser != null) {
            gotoHomeScreen()
        }

    }

    private fun gotoHomeScreen() {
        // code for fragment to home screen if user already exists
        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        findNavController().navigate(action)
    }
}