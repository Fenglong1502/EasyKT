package com.example.easykt.easykt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityTutorial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        setSupportActionBar(findViewById(R.id.my_toolbar))

    }
}
