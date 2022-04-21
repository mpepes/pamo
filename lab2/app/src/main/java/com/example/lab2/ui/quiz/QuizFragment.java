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
    private int score = 0;

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


        questionTextView.setText(R.string.question_declaration);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                getNextQuestion();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                getNextQuestion();
            }
        });

        quizViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void getNextQuestion() {
        if (currentQuestionIndex == (questionBank.length - 1)) {
            questionTextView.setText("Your score: " + score + "/" + questionBank.length);
        } else {
            currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
            updateQuestion();
        }
    }

    private void updateQuestion() {
        Log.d("Current", "Onclick" + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean userChoosenCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();

        if (userChoosenCorrect == answerIsTrue) {
            score += 1;
        }
    }
}
