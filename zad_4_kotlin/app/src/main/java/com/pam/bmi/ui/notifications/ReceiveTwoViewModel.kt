package com.pam.bmi.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReceiveTwoViewModel : ViewModel() {
    private val mText: MutableLiveData<String?>

    init {
        mText = MutableLiveData()
        mText.value = "Place eggs in a medium pot and cover with cold water by 1 inch. Bring to a boil, then cover the pot and turn the heat off. Let the eggs cook, covered, for 9 to 12 minutes, depending on your desired done-ness (see photo). Transfer the eggs to a bowl of ice water and chill for 14 minutes."
    }

    val text: LiveData<String?>
        get() = mText
}