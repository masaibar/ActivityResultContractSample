package com.masaibar.activityresultcontractsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val launcher: ActivityResultLauncher<Intent> =
            prepareCall(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                Log.d("MainActivity", activityResult.toString())
            }

    private val getContentLauncher = prepareCall(ActivityResultContracts.GetContent()) { uri ->
        Log.d("MainActivity", "uri: $uri")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_open.setOnClickListener {
            launcher.launch(SecondActivity.createIntent(this))
        }

        button_get_content.setOnClickListener {
            getContentLauncher.launch("image/*")
        }
    }
}
