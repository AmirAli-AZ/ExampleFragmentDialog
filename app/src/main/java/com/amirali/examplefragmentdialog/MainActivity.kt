package com.amirali.examplefragmentdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amirali.examplefragmentdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ExampleDialogFragment.Listener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            val dialog = ExampleDialogFragment()
            dialog.show(supportFragmentManager, "ExampleDialogFragment")
        }
    }

    override fun onResult(selectedItem: String) {
        binding.result.text = "You selected \"$selectedItem\""
    }
}