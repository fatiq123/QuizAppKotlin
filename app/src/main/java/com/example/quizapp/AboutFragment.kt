package com.example.quizapp

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)

        // Set your profile picture in a circular shape
        val profileImage: ImageView = binding.profileImage
        val profileImageDrawable: Drawable? = ContextCompat.getDrawable(requireContext(), R.drawable.profile_picture)
        if (profileImageDrawable != null) {
            profileImage.setImageDrawable(profileImageDrawable)
            profileImage.clipToOutline = true
        }

        // Set your name and developer title
        binding.tvName.text = "Fatiq Hussnain"
        binding.tvDeveloperTitle.text = "Mobile App Developer"

        // Set your contact details (phone number and email)
        binding.tvPhoneNumber.text = "Phone: 03229549909"
        binding.tvEmail.text = "Email: fatiqhussnain1@gmail.com"

        // Set your app description
        binding.tvAppDescription.text = "Hi there! I'm Fatiq Hussnain, a passionate and dedicated software developer with a strong interest in mobile app development and a love for coding. Ever since I discovered the fascinating world of programming, I've been on an exciting journey to explore the realms of technology and create meaningful solutions."

        // Set up social media links (e.g., LinkedIn and GitHub)
        binding.btnLinkedIn.setOnClickListener {
            openLinkInBrowser("https://www.linkedin.com/in/fatiq-hussnain-7aa393201/")
        }

        binding.btnGitHub.setOnClickListener {
            openLinkInBrowser("https://github.com/fatiq123")
        }


        return binding.root
    }



    // Function to open links in a browser
    private fun openLinkInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}