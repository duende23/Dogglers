package com.villadevs.dogglers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.villadevs.dogglers.const.Layout

class DogViewModel:ViewModel() {

    private val _buttonState = MutableLiveData(Layout.VERTICAL )
    val buttonState: LiveData<Int> = _buttonState

    fun clickButtonSelect(status: Int) {
        when (status) {
            Layout.VERTICAL -> { _buttonState.value = Layout.VERTICAL }

            Layout.HORIZONTAL -> {_buttonState.value = Layout.HORIZONTAL }

            Layout.GRID -> { _buttonState.value = Layout.GRID }

        }
    }


}