package com.example.lab2.ui.home

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
import com.example.lab2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var homeViewModel: HomeViewModel? = null
    private var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

//        final TextView textView = binding.textHome;
        val imageView = binding!!.imageView
        homeViewModel.getText().observe(viewLifecycleOwner, { //                textView.setText(s);
            imageView.layoutParams.height = 150
            imageView.layoutParams.width = 150
            imageView.requestLayout()
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}