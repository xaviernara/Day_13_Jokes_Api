package com.example.day13_jokes_api.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.day13_jokes_api.R
import com.example.day13_jokes_api.adaptor.SecondActivity
import com.example.day13_jokes_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
     lateinit var binding : ActivityMainBinding
    lateinit var context :
     //lateinit  val context = itemView.context
    lateinit var intent : Intent(MainActivity.this, SecondActivity::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initViews()


    }

    private fun initViews() {
        TODO("Not yet implemented")
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
            if(v.id == R.id.anyRadioButton){
                intent.putExtra("anyCategory", binding.anyRadioButton.text)

            }else if(v.id == R.id.miscRadioButton){
                intent.putExtra("miscCategory", binding.miscRadioButton.text)

            }else if(v.id == R.id.programmingRadioButton){
                intent.putExtra("programmingCategory", binding.programmingRadioButton.text)

            }else if(v.id == R.id.spookyRadioButton){
                intent.putExtra("spookyCategory", binding.spookyRadioButton.text)

            }else if(v.id == R.id.xmasRadioButton){
                intent.putExtra("xmasCategory", binding.xmasRadioButton.text)

            }else if(v.id == R.id.darkRadioButton){
                intent.putExtra("darkCategory", binding.darkRadioButton.text)

            }else{
                intent.putExtra("amount", binding.amountText.text)
                startActivity(intent)

            }


        }




    }


}