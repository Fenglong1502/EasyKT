package com.example.easykt.easykt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_display.*

class ActivityQuiz : AppCompatActivity() {
    lateinit var fragmentManager: FragmentManager
    lateinit var transaction: FragmentTransaction
    lateinit var fragmentToDisplay: Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        fragmentManager= supportFragmentManager
        transaction = fragmentManager.beginTransaction()
        fragmentToDisplay = TutorialListFragment()

        var QuizLevel : String = intent.getStringExtra("QuizLevel")

        if(QuizLevel == "Beginner"){
            transaction = fragmentManager.beginTransaction()
            fragmentToDisplay = BeginnerQuizFragment()
            transaction.replace(R.id.quizFrameLayout,fragmentToDisplay)
            transaction.commit()
        }

        if(QuizLevel == "Intermediate"){
            transaction = fragmentManager.beginTransaction()
            fragmentToDisplay = IntermediateQuizFragment()
            transaction.replace(R.id.quizFrameLayout,fragmentToDisplay)
            transaction.commit()
        }

        if( QuizLevel == "Advanced"){
            transaction = fragmentManager.beginTransaction()
            fragmentToDisplay = AdvancedQuizFragment()
            transaction.replace(R.id.quizFrameLayout,fragmentToDisplay)
            transaction.commit()
        }
    }

    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Are you sure !")
        dialog.setMessage("Do you want to exit quiz? \nAll your current progress will be lost.")
        dialog.setPositiveButton("Yes") { dialog, which ->
            dialog?.dismiss()
            super.onBackPressed()
        }
        dialog.setNegativeButton("No") { dialog, which -> dialog?.dismiss() }
        dialog.show()
    }
}
