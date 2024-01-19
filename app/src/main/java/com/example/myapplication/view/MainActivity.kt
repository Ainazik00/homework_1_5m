package com.example.myapplication.view

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    private lateinit var binding: ActivityMainBinding
    private var presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()
            }
            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun showNewCount(number: Int) {
        binding.resultTv.text = number.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.resultTv.setTextColor(ContextCompat.getColor(this, R.color.holo_green_dark))
    }

}