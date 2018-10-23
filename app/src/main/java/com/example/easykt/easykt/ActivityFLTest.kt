package com.example.easykt.easykt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.Menu
import android.widget.Button
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_fltest2.*

class ActivityFLTest : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_Tutorial -> {
                val newIntent = Intent(this, ActivityTutorial :: class.java)
                startActivity(newIntent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Quiz -> {
                val newIntent = Intent(this, ActivitQuiz :: class.java)
                startActivity(newIntent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Video -> {
                val newIntent = Intent(this, ActivityVideo :: class.java)
                startActivity(newIntent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fltest)
        setSupportActionBar(findViewById(R.id.my_toolbar))


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


//        val btnAc2 = findViewById<Button>(R.id.btnAc2)
//        btnAc2.setOnClickListener {
//            val newIntent = Intent(this, ActivityFLTest2 :: class.java)
//            startActivity(newIntent)
//        }

    }

}



//
//        setSupportActionBar(findViewById(R.id.my_toolbar))

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
