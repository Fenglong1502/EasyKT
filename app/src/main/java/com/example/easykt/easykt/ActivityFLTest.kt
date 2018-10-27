package com.example.easykt.easykt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.Menu
import android.widget.Button
import android.widget.Toolbar
import com.google.android.youtube.player.internal.e
import kotlinx.android.synthetic.main.activity_fltest2.*

class ActivityFLTest : AppCompatActivity() {

    lateinit var fragmentManager: FragmentManager
    lateinit var transaction: FragmentTransaction
    lateinit var fragmentToGo: Fragment



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_Tutorial -> {
//                val newIntent = Intent(this, ActivityTutorial :: class.java)
//                startActivity(newIntent)
                transaction = fragmentManager.beginTransaction()
                fragmentToGo = TutorialListFragment()
                transaction.replace(R.id.frameLayout,fragmentToGo)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Quiz -> {
//                val newIntent = Intent(this, ActivitQuiz :: class.java)
//                startActivity(newIntent)
                transaction = fragmentManager.beginTransaction()
                fragmentToGo = TutorialListFragment()
                transaction.replace(R.id.frameLayout,fragmentToGo)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Video -> {
//                val newIntent = Intent(this, ActivityVideo :: class.java)
//                startActivity(newIntent)
                transaction = fragmentManager.beginTransaction()
                fragmentToGo = VideoFragment()
                transaction.replace(R.id.frameLayout,fragmentToGo)
                transaction.commit()
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
        fragmentManager= supportFragmentManager
        transaction = fragmentManager.beginTransaction()
        fragmentToGo = TutorialListFragment()
        var FragmentToPass : String = intent.getStringExtra("FragmentToPass")
        var test = FragmentToPass == "video"
        if(test){
            fragmentToGo = VideoFragment()
        }

        if(FragmentToPass == "tutorial"){
            fragmentToGo = TutorialListFragment()
        }

        if(FragmentToPass == "quiz"){
            fragmentToGo = TutorialListFragment()
        }

        transaction.add(R.id.frameLayout,fragmentToGo)
        transaction.commit()

    }
}



//
//        setSupportActionBar(findViewById(R.id.my_toolbar))

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
