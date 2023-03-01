package com.example.mateirialtimepickerdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mateirialtimepickerdialog.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDialog.setOnClickListener {
            val materialTimePicker = MaterialTimePicker.Builder()
                .setHour(Calendar.HOUR_OF_DAY)
                .setMinute(Calendar.MINUTE)
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .build()

            materialTimePicker.addOnPositiveButtonClickListener {
                val newHour: Int = materialTimePicker.hour
                val newMinute: Int = materialTimePicker.minute
                Toast.makeText(this@MainActivity, "Time------------$newHour-----------$newMinute", Toast.LENGTH_SHORT).show()
            }
            materialTimePicker.show(supportFragmentManager, "fragment_tag")
        }


    }
}