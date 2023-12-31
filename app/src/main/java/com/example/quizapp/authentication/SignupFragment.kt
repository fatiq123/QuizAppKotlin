package com.example.quizapp.authentication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlin.IllegalArgumentException

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_signup, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth


        binding.alreadyAccountButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }


        // redirect to home screen
        binding.signupButton.setOnClickListener {
//            it.findNavController().navigate(R.id.action_signupFragment_to_homeFragment)

            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val retypedPassword = binding.retypePasswordEditText.text.toString()
            createNewUser(email = email, password = password, retypedPassword = retypedPassword)
        }

    }

    private fun createNewUser(email: String, password: String, retypedPassword: String) {

//        try {
//
//            if (email.isEmpty() || password.isEmpty() || userName.isEmpty()) {
//                Toast.makeText(
//                    requireContext(),
//                    "Email and password cannot be empty.",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//                return
//            }
//            auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(requireActivity()) { task ->
//                    if (task.isSuccessful) {
//                        // Sign-up successful, navigate to the next screen or perform other actions
//                        Toast.makeText(
//                            requireContext(),
//                            "Sign up successful!",
//                            Toast.LENGTH_SHORT
//                        ).show()
//
//
//                        // Save user details to Firestore
//                        val currentUser = auth.currentUser
//                        if (currentUser != null) {
//                            val newUser = hashMapOf(
//                                "email" to email,
//                                "username" to userName // Save the username along with other user details
//                            )
//
//                            // Assuming you have a "users" collection in Firestore
//                            val db = FirebaseFirestore.getInstance()
//                            db.collection("users").document(currentUser.uid)
//                                .set(newUser)
//                                .addOnSuccessListener {
//                                    // User details saved to Firestore
//                                    // Navigate to the next screen, for example, the HomeFragment
//                                    findNavController().navigate(R.id.action_signupFragment_to_homeFragment)
//                                }
//                                .addOnFailureListener { e ->
//                                    // Error saving user details to Firestore
//                                    Toast.makeText(
//                                        requireContext(),
//                                        "Error saving user details: ${e.message}",
//                                        Toast.LENGTH_SHORT
//                                    ).show()
//                                }
//                        } else {
//                            // Handle the case where currentUser is null
//                            Toast.makeText(
//                                requireContext(),
//                                "Error: User is not signed in.",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
////
////                        // Navigate to the next screen, for example, the HomeFragment
////                        findNavController().navigate(R.id.action_signupFragment_to_homeFragment)
//                    } else {
//
//
//                        // Sign-up failed, display an error message and log the exception
//                        Log.e("SignupFragment", "Error creating user: ${task.exception?.message}")
//
//
//
//
//                        // Sign-up failed, display an error message
//                        Toast.makeText(
//                            requireContext(),
//                            "Sign up failed. Please try again later.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//        } catch (e: IllegalArgumentException) {
//            // Handle the IllegalArgumentException here, e.g., display an error toast
//            Toast.makeText(
//                requireContext(),
//                "IllegalArgumentException: ${e.message}",
//                Toast.LENGTH_SHORT
//            ).show()
//        }


//        try {
//
//            if (email.isEmpty() || password.isEmpty() || userName.isEmpty()) {
//                Toast.makeText(
//                    requireContext(),
//                    "email, password and username cannot be empty",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//                return
//            }
//
//
//            // Check if the email is already registered
//            FirebaseFirestore.getInstance().collection("users")
//                .whereEqualTo("email", email)
//                .get()
//                .addOnSuccessListener { querySnapshot ->
//                    if (!querySnapshot.isEmpty) {
//                        // Email is already registered, show an error message to the user
//                        Toast.makeText(
//                            requireContext(),
//                            "The email address is already in use by another account.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    } else {
//                        // Email is not registered, proceed with user creation
//                        auth.createUserWithEmailAndPassword(email, password)
//                            .addOnCompleteListener(requireActivity()) { task ->
//                                if (task.isSuccessful) {
//                                    // Sign-up successful, navigate to the next screen or perform other actions
//                                    Toast.makeText(
//                                        requireContext(),
//                                        "Sign up successful!",
//                                        Toast.LENGTH_SHORT
//                                    ).show()
//
//                                    // Navigate to the next screen, for example, the HomeFragment
//                                    findNavController().navigate(R.id.action_signupFragment_to_homeFragment)
//                                } else {
//                                    // Sign-up failed, display an error message
//                                    val exception = task.exception
//                                    if (exception is FirebaseAuthUserCollisionException) {
//                                        // The email address is already in use by another account
//                                        Toast.makeText(
//                                            requireContext(),
//                                            "The email address is already in use by another account.",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    } else {
//                                        // Some other error occurred during sign up
//                                        Toast.makeText(
//                                            requireContext(),
//                                            "Sign up failed. Please try again later.",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    }
//                                }
//                            }
//                    }
//                }
//
//        } catch (e: IllegalArgumentException) {
////             Handle the IllegalArgumentException here, e.g., display an error toast
//            Toast.makeText(
//                requireContext(),
//                "IllegalArgumentException: ${e.message}",
//                Toast.LENGTH_SHORT
//            ).show()
//        }


        try {

            if (email.isEmpty() || password.isEmpty() || retypedPassword.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Sign up failed. Please try again later.",
                    Toast.LENGTH_SHORT
                ).show()
            }


            if (password != retypedPassword) {
                // Password and retyped password don't match, show an error message to the user
                Toast.makeText(
                    requireContext(),
                    "Password and retyped password don't match.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Passwords match, proceed with user creation
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            // Sign-up successful, navigate to the next screen or perform other actions
                            Toast.makeText(
                                requireContext(),
                                "Sign up successful!",
                                Toast.LENGTH_SHORT
                            ).show()

                            // Navigate to the next screen, for example, the HomeFragment
                            findNavController().navigate(R.id.action_signupFragment_to_homeFragment)
                        } else {
                            // Sign-up failed, display an error message
                            val exception = task.exception
                            if (exception is FirebaseAuthUserCollisionException) {
                                // The email address is already in use by another account
                                Toast.makeText(
                                    requireContext(),
                                    "The email address is already in use by another account.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                // Some other error occurred during sign up
                                Toast.makeText(
                                    requireContext(),
                                    "Sign up failed. Please try again later.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
            }

        } catch (e: IllegalArgumentException) {
            // Handle the IllegalArgumentException here, e.g., display an error toast
            Toast.makeText(
                requireContext(),
                "IllegalArgumentException: ${e.message}",
                Toast.LENGTH_SHORT
            ).show()
        }


    }



    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    private fun reload() {

    }

}