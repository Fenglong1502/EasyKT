package com.example.easykt.easykt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_display.*

class ActivityDisplay : AppCompatActivity() {

    lateinit var fragmentManager: FragmentManager
    lateinit var transaction: FragmentTransaction
    lateinit var fragmentToGo: Fragment


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_Tutorial -> {
                transaction = fragmentManager.beginTransaction()
                fragmentToGo = TutorialListFragment()
                transaction.replace(R.id.frameLayout,fragmentToGo)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Quiz -> {
                transaction = fragmentManager.beginTransaction()
                fragmentToGo = QuizFragment()
                transaction.replace(R.id.frameLayout,fragmentToGo)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Video -> {
                transaction = fragmentManager.beginTransaction()
                fragmentToGo = VideoFragment()
                transaction.replace(R.id.frameLayout,fragmentToGo)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_Note -> {
                transaction = fragmentManager.beginTransaction()
                fragmentToGo = NoteFragment()
                transaction.replace(R.id.frameLayout,fragmentToGo)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fragmentManager= supportFragmentManager
        transaction = fragmentManager.beginTransaction()
        fragmentToGo = TutorialListFragment()

        var FragmentToPass : String = intent.getStringExtra("FragmentToPass")

        if(FragmentToPass == "tutorial"){
            navigation.setSelectedItemId(R.id.navigation_Tutorial);
        }

        if(FragmentToPass == "quiz"){
            navigation.setSelectedItemId(R.id.navigation_Quiz);
        }

        if( FragmentToPass == "video"){
            navigation.setSelectedItemId(R.id.navigation_Video);
        }

        if( FragmentToPass == "note"){
            navigation.setSelectedItemId(R.id.navigation_Note);
        }

        // transaction.add(R.id.frameLayout,fragmentToGo)
      // transaction.commit()

    }
}
