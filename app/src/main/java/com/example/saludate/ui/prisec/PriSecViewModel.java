package com.example.saludate.ui.prisec;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PriSecViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PriSecViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is Privacy and Security fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}