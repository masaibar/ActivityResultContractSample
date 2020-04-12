package com.masaibar.activityresultcontractsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val launcher: ActivityResultLauncher<Intent> =
            prepareCall(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                Log.d("MainActivity", activityResult.toString())
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_open.setOnClickListener {
            launcher.launch(SecondActivity.createIntent(this))
        }
    }
}
