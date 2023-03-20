package com.pam.bmi.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecipeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecipeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Prick the sausages and place them in a microwave safe dish – they need a bit of space round them, so don't pile them high. Cover the sausages with a lid, or some cling film, or a sheet of kitchen towel. Microwave on high power (800 watts) for 1½ minutes, turn the sausages over and microwave for a further 1-1½ minutes.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}