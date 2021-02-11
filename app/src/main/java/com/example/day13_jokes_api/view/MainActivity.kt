package com.example.day13_jokes_api.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
     lateinit var binding : ActivityMainBinding
     //lateinit var context :
     //lateinit  val context = itemView.context



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initViews()


    }

    private fun initViews() {
        intent = Intent(this, SecondActivity::class.java)

        binding.radioGroup.setOnClickListener(this)
        binding.anyRadioButton.setOnClickListener(this)
        binding.miscRadioButton.setOnClickListener(this)
        binding.programmingRadioButton.setOnClickListener(this)
        binding.spookyRadioButton.setOnClickListener(this)
        binding.xmasRadioButton.setOnClickListener(this)
        binding.darkRadioButton.setOnClickListener(this)
        binding.anyRadioButton.setOnClickListener(this)
        binding.button.setOnClickListener(this)
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.anyRadioButton -> {
                    intent.putExtra("anyCategory", binding.anyRadioButton.text)
                    Toast.makeText(this,binding.anyRadioButton.text,Toast.LENGTH_SHORT).show()
                }
                R.id.miscRadioButton -> {
                    intent.putExtra("miscCategory", binding.miscRadioButton.text)
                    Toast.makeText(this,binding.miscRadioButton.text,Toast.LENGTH_SHORT).show()

                }
                R.id.programmingRadioButton -> {
                    intent.putExtra("programmingCategory", binding.programmingRadioButton.text)
                    Toast.makeText(this,binding.programmingRadioButton.text,Toast.LENGTH_SHORT).show()

                }
                R.id.spookyRadioButton -> {
                    intent.putExtra("spookyCategory", binding.spookyRadioButton.text)
                    Toast.makeText(this,binding.spookyRadioButton.text,Toast.LENGTH_SHORT).show()

                }
                R.id.xmasRadioButton -> {
                    intent.putExtra("xmasCategory", binding.xmasRadioButton.text)
                    Toast.makeText(this,binding.xmasRadioButton.text,Toast.LENGTH_SHORT).show()

                }
                R.id.darkRadioButton -> {
                    intent.putExtra("darkCategory", binding.darkRadioButton.text)
                    Toast.makeText(this,binding.darkRadioButton.text,Toast.LENGTH_SHORT).show()

                }
                R.id.punRadioButton -> {
                    intent.putExtra("punCategory", binding.punRadioButton.text)
                    Toast.makeText(this,binding.punRadioButton.text,Toast.LENGTH_SHORT).show()

                }
                else -> {
                    intent.putExtra("amount", binding.amountText.text)
                    Toast.makeText(this,binding.amountText.text,Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }


        }




    }


}