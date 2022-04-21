package com.example.lab2.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentQuizBinding;

public class QuizFragment extends Fragment {
    private TextView question;
    private Button button;

    private QuizViewModel quizViewModel;
    private FragmentQuizBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quizViewModel =
                new ViewModelProvider(this).get(QuizViewModel.class);

        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        question = binding.getRoot().findViewById(R.id.question);

        question.setText("lalala");
//        button = binding.getRoot().findViewById(R.id.calc);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String heightStr = height.getText().toString();
//                String weightStr = weight.getText().toString();
//
//                if (heightStr != null && !"".equals(heightStr)
//                        && weightStr != null  &&  !"".equals(weightStr)) {
//                    float heightValue = Float.parseFloat(heightStr) / 100;
//                    float weightValue = Float.parseFloat(weightStr);
//
//                    float bmi = weightValue / (heightValue * heightValue);
//
//                    displayBMI(bmi);
//                }
//            }
//        });

        quizViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}
