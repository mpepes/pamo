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
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.NavController

class Question(var answerResId: Int, var isAnswerTrue: Boolean)