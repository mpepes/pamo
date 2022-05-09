package com.example.lab2.ui.receipts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class ReceiptsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ReceiptsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is receipts");
    }

    public LiveData<String> getText() {
        return mText;
    }
}