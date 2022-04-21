package com.example.lab2.ui.quiz;

import android.os.Bundle;
import android.util.Log;
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
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentQuizBinding;

public class QuizFragment extends Fragment {
    private Button trueButton;
    private Button falseButton;
    private TextView questionTextView;
    private ImageButton prevButton;
    private ImageButton nextButton;

    private QuizViewModel quizViewModel;
    private FragmentQuizBinding binding;

    private int currentQuestionIndex = 0;
    private Question[] questionBank = new Question[]{
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_temp, true),
            new Question(R.string.question_body, false),
            new Question(R.string.question_human, false),
            new Question(R.string.question_physics, true),
            new Question(R.string.question_spider, false)
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        quizViewModel =
                new ViewModelProvider(this).get(QuizViewModel.class);

        binding = FragmentQuizBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        questionTextView = root.findViewById(R.id.question);
        falseButton = root.findViewById(R.id.false_button);
        trueButton = root.findViewById(R.id.ture_buttoon);

        prevButton = root.findViewById(R.id.prev_button);
        nextButton = root.findViewById(R.id.next_button);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                    updateQuestion();
                }
            }
        });

        quizViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void updateQuestion() {
        Log.d("Current", "Onclick" + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean userChoosenCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();

        int toastMessageId = 0;
        if (userChoosenCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }
//        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}
