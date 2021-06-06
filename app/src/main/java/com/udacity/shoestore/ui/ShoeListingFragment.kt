package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe


class ShoeListingFragment : Fragment() {

    lateinit var binding: FragmentShoeListingBinding
    lateinit var sharedViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        // Inflate the layout for this fragment

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        sharedViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        sharedViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            updateUI(inflater, it)
        })

        return binding.root
    }

    private fun updateUI(inflater: LayoutInflater, shoeList: List<Shoe>) {
        val myLayout: LinearLayout = binding.shoesListLayout
        myLayout.removeAllViews()
        for (shoe in shoeList) {
            val bindingChildLayout: ShoeListItemBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_item, myLayout, false)
            bindingChildLayout.companyText.text = shoe.company
            bindingChildLayout.nameText.text = shoe.name
            bindingChildLayout.descriptionText.text = shoe.description
            bindingChildLayout.sizeText.text = shoe.size.toString()

            myLayout.addView(bindingChildLayout.root)
        }

    }

}