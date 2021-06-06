package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailBinding
    lateinit var sharedViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.lifecycleOwner = this

        sharedViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.viewmodel = sharedViewModel

        sharedViewModel.eventNavigateToShoeList.observe(viewLifecycleOwner, Observer { it ->
            if (it) {
                findNavController().navigateUp()
                sharedViewModel.onNavigationComplete()
            }
        })

        return binding.root
    }

}