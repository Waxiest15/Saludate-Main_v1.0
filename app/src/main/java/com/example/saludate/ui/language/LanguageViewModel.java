package com.example.saludate.ui.language;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LanguageViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LanguageViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is language fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}