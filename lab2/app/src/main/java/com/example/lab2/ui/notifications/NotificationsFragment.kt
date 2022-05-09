package com.example.lab2.ui.notifications

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
import com.example.lab2.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private var height: EditText? = null
    private var weight: EditText? = null
    private var result: TextView? = null
    private var gender: Spinner? = null
    private var age: EditText? = null
    private var button: Button? = null
    private var notificationsViewModel: NotificationsViewModel? = null
    private var binding: FragmentNotificationsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel = ViewModelProvider(this).get(
            NotificationsViewModel::class.java
        )
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        height = root.findViewById(R.id.height)
        weight = root.findViewById(R.id.weight)
        result = root.findViewById(R.id.result)
        button = root.findViewById(R.id.calc)
        age = root.findViewById(R.id.age)
        gender = root.findViewById(R.id.spinner1)
        val adapter = ArrayAdapter.createFromResource(
            activity!!, R.array.gender, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gender.setAdapter(adapter)
        button.setOnClickListener(View.OnClickListener {
            val heightStr = height.getText().toString()
            val weightStr = weight.getText().toString()
            if (heightStr != null && "" != heightStr
                && weightStr != null && "" != weightStr
            ) {
                val heightValue = heightStr.toFloat()
                val weightValue = weightStr.toFloat()
                val ageValue = age.getText().toString().toInt()
                val genderValue = gender.getSelectedItem().toString()
                val result: Double
                result = if (genderValue == "Mezczyzna") {
                    66.5 + 13.75 * weightValue + 5.003 * heightValue - 6.775 * ageValue
                } else {
                    655.1 + 9.563 * weightValue + 1.85 * heightValue - 4.676 * ageValue
                }
                displayResult(result)
            }
        })
        notificationsViewModel.getText().observe(viewLifecycleOwner, { })
        return root
    }

    fun displayResult(bmi: Double) {
        val bmiLabel = bmi.toString() + ""
        result!!.text = bmiLabel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}