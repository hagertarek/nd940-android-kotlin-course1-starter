package com.udacity.shoestore.screens.shoelist

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel() : ViewModel(), Observable {

    private var shoeListMutableLiveDate = MutableLiveData<MutableList<Shoe>>()
    var shoeList: LiveData<MutableList<Shoe>> = shoeListMutableLiveDate
    private var _eventItemSaved = MutableLiveData<Boolean>()
    var eventItemSaved: LiveData<Boolean> = _eventItemSaved

    var name = MutableLiveData<String>()

    @Bindable("name")
    fun getName(): String = name.value!!

    var size = MutableLiveData<String>()

    @Bindable("size")
    fun getSize(): String = size.value!!

    var company = MutableLiveData<String>()

    @Bindable("company")
    fun getCompany(): String = company.value!!

    var description = MutableLiveData<String>()

    @Bindable("description")
    fun getDescription(): String = description.value!!

    init {
        initShoesList()
    }

    private fun initShoesList() {
        //initial value for list
        shoeListMutableLiveDate.value = mutableListOf(
            Shoe(
                "first Shoe",
                40.0,
                "Company1",
                "this shoes is great"
            )
        )

    }

    fun saveToList() {
        shoeListMutableLiveDate.value?.add(
            Shoe(
                name.value!!,
                size.value!!.toDouble(),
                company.value!!,
                description.value!!
            )
        )
        _eventItemSaved.value = true
    }

    fun onItemSaveComplete() {
        _eventItemSaved.value = false
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}