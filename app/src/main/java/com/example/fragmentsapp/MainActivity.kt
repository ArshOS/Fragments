package com.example.fragmentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragmentsapp.fragments.FragmentOne
import com.example.fragmentsapp.fragments.FragmentTwo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1 = findViewById<Button>(R.id.displayFrag1)
        val button2 = findViewById<Button>(R.id.displayFrag2)

        button1.setOnClickListener {
            val fragment1 = FragmentOne()
            loadFragment(fragment1)
        }

        button2.setOnClickListener {
            val fragment2 = FragmentTwo()
            loadFragment(fragment2)
        }
    }

    fun loadFragment(fragment: Fragment) {

        // 1. Fragment manager
        val fragmentManager = supportFragmentManager

        // 2. Fragment transaction - Begin the transaction
        val fragmentTransaction = fragmentManager.beginTransaction()

        // 3. Replace the frame layout with the passed fragment and commit the transaction
        fragmentTransaction.replace(R.id.framelayout, fragment).commit()
    }

}