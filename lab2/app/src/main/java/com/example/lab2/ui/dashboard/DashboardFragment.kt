package com.example.lab2.ui.dashboard

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
import com.example.lab2.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var height: EditText? = null
    private var weight: EditText? = null
    private var result: TextView? = null
    private var button: Button? = null
    private var dashboardViewModel: DashboardViewModel? = null
    private var binding: FragmentDashboardBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        height = binding!!.root.findViewById(R.id.height)
        weight = binding!!.root.findViewById(R.id.weight)
        result = binding!!.root.findViewById(R.id.result)
        button = binding!!.root.findViewById(R.id.calc)
        button.setOnClickListener(View.OnClickListener {
            val heightStr = height.getText().toString()
            val weightStr = weight.getText().toString()
            if (heightStr != null && "" != heightStr
                && weightStr != null && "" != weightStr
            ) {
                val heightValue = heightStr.toFloat() / 100
                val weightValue = weightStr.toFloat()
                val bmi = weightValue / (heightValue * heightValue)
                displayBMI(bmi)
            }
        })
//        dashboardViewModel.getText().observe(viewLifecycleOwner, { })
        return root
    }

    fun displayBMI(bmi: Float) {
        val bmiLabel = bmi.toString() + ""
        result!!.text = bmiLabel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}