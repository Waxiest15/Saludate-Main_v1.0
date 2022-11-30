package com.example.saludate.ui.editUserProfile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EditUserViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public EditUserViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}