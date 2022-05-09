package com.example.lab2.ui.quiz

import androidx.lifecycle.ViewModelProvider.get
import androidx.navigation.ui.AppBarConfiguration.Builder.build
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.lab2.ui.home.HomeViewModel
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import android.widget.Button
import android.widget.TextView
import com.example.lab2.ui.quiz.QuizViewModel
import com.example.lab2.ui.quiz.Question
import com.example.lab2.R
import android.util.Log
import com.example.lab2.ui.graph.GraphViewModel
import java.util.concurrent.ThreadLocalRandom
import com.example.lab2.ui.receipts.ReceiptsViewModel
import android.widget.EditText
import com.example.lab2.ui.dashboard.DashboardViewModel
import android.widget.Spinner
import com.example.lab2.ui.notifications.NotificationsViewModel
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.NavController
import com.example.lab2.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    private var trueButton: Button? = null
    private var falseButton: Button? = null
    private var questionTextView: TextView? = null
    private var score = 0
    private var quizViewModel: QuizViewModel? = null
    private var binding: FragmentQuizBinding? = null
    private var currentQuestionIndex = 0
    private val questionBank = arrayOf(
        Question(R.string.question_declaration, true),
        Question(R.string.question_temp, true),
        Question(R.string.question_body, false),
        Question(R.string.question_human, false),
        Question(R.string.question_physics, true),
        Question(R.string.question_spider, false)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        questionTextView = root.findViewById(R.id.question)
        falseButton = root.findViewById(R.id.false_button)
        trueButton = root.findViewById(R.id.ture_buttoon)
        questionTextView.setText(R.string.question_declaration)
        trueButton.setOnClickListener(View.OnClickListener {
            checkAnswer(true)
            nextQuestion
        })
        falseButton.setOnClickListener(View.OnClickListener {
            checkAnswer(false)
            nextQuestion
        })
        quizViewModel.getText().observe(viewLifecycleOwner, { })
        return root
    }

    private val nextQuestion: Unit
        private get() {
            if (currentQuestionIndex == questionBank.size - 1) {
                questionTextView!!.text = "Your score: " + score + "/" + questionBank.size
            } else {
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.size
                updateQuestion()
            }
        }

    private fun updateQuestion() {
        Log.d("Current", "Onclick$currentQuestionIndex")
        questionTextView.setText(questionBank[currentQuestionIndex].answerResId)
    }

    private fun checkAnswer(userChoosenCorrect: Boolean) {
        val answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue
        if (userChoosenCorrect == answerIsTrue) {
            score += 1
        }
    }
}