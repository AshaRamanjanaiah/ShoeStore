package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnboardingBinding
import com.udacity.shoestore.utils.LOGGED_OUT
import com.udacity.shoestore.utils.ONBOARDING_DISPLAY
import com.udacity.shoestore.utils.setPrefBoolean

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding, container, false)
        binding.nextButton.setOnClickListener {
            findNavController().navigate(OnboardingFragmentDirections.actionOnboardingFragmentToShoeListingFragment())
        }

        setPrefBoolean(this.requireContext(), ONBOARDING_DISPLAY, true)
        setPrefBoolean(this.requireContext(), LOGGED_OUT, false)
        return binding.root
    }

}