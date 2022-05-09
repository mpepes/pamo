package com.example.lab2.ui.receipts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.lab2.databinding.FragmentReceiptsBinding;
import com.example.lab2.ui.receipts.ReceiptsViewModel;
import com.example.lab2.R;

public class ReceiptsFragment extends Fragment {

    private ReceiptsViewModel receiptsViewModel;
    private FragmentReceiptsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        receiptsViewModel =
                new ViewModelProvider(this).get(ReceiptsViewModel.class);

        binding = FragmentReceiptsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        ImageView imageView = binding.imageView;
        receiptsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}