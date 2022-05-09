package com.example.lab2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {
    private EditText height;
    private EditText weight;
    private TextView result;
    private Spinner gender;
    private EditText age;
    private Button button;

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        height = root.findViewById(R.id.height);
        weight = root.findViewById(R.id.weight);
        result = root.findViewById(R.id.result);
        button = root.findViewById(R.id.calc);
        age = root.findViewById(R.id.age);
        gender = root.findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.gender, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();

                if (heightStr != null && !"".equals(heightStr)
                        && weightStr != null  &&  !"".equals(weightStr)) {
                    float heightValue = Float.parseFloat(heightStr);
                    float weightValue = Float.parseFloat(weightStr);
                    int ageValue = Integer.parseInt(age.getText().toString());
                    String genderValue = gender.getSelectedItem().toString();
                    double result;

                    if (genderValue.equals("Mezczyzna")) {
                        result = 66.5 + (13.75 * weightValue) + (5.003 * heightValue) - (6.775 * ageValue);
                    } else {
                        result = 655.1 + (9.563 * weightValue) + (1.85 * heightValue) - (4.676 * ageValue);
                    }

                    displayResult(result);
                }
            }
        });

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    public void displayResult(double bmi) {
        String bmiLabel = bmi + "";
        result.setText(bmiLabel);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}