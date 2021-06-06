package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class MainViewModel: ViewModel() {

    private var _shoeList  = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
            get() = _shoeList
    var company = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var size = MutableLiveData<Double>()
    var description = MutableLiveData<String>()
    private var _eventNavigateToShoeList = MutableLiveData<Boolean>()
    val eventNavigateToShoeList: LiveData<Boolean>
        get() = _eventNavigateToShoeList

    private var shoeArray: ArrayList<Shoe> = arrayListOf(
        Shoe("Air max", 12.5, "NiKe", "Mens AIR MAX VG-R"),
        Shoe("Running shoes", 13.0, "Reebok", "Classic Leather Shoes"),
        Shoe("Sneaker black", 14.5, "Skechers", "Sure Track Erath 76576 Sneaker")
    )

    init {
        _shoeList.value = shoeArray
        _eventNavigateToShoeList.value = false
    }

   fun addShoe() {
       shoeArray.add(Shoe(company = company.value?:"", name = name.value?:"", size = size.value?:0.0, description = description.value?:""))
       _shoeList.value = shoeArray
       _eventNavigateToShoeList.value = true
   }

    fun onNavigationComplete() {
        _eventNavigateToShoeList.value = false
    }

}
