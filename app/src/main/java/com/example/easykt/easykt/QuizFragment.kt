package com.example.easykt.easykt

import android.app.ProgressDialog
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.getSystemService
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import okhttp3.Request
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.easykt.easykt.R.id.*
import kotlinx.android.synthetic.main.fragment_quiz.*
import org.json.JSONArray
import org.json.JSONException
import okhttp3.OkHttpClient
import java.util.*

@Suppress("DEPRECIATION")
class QuizFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        val btnBeginnerQuiz = view.findViewById<Button>(R.id.btnBeginnerQuiz)
        btnBeginnerQuiz.setOnClickListener {
            val newIntent = Intent(this.context, ActivityQuiz :: class.java)
            newIntent.putExtra("QuizLevel", "Beginner")
            startActivity(newIntent)
        }

        val btnIntermediateQuiz = view.findViewById<Button>(R.id.btnIntermediateQuiz)
        btnIntermediateQuiz.setOnClickListener {
            val newIntent = Intent(this.context, ActivityQuiz :: class.java)
            newIntent.putExtra("QuizLevel", "Intermediate")
            startActivity(newIntent)
        }

        val btnAdvancedQuiz = view.findViewById<Button>(R.id.btnAdvancedQuiz)
        btnAdvancedQuiz.setOnClickListener {
            val newIntent = Intent(this.context, ActivityQuiz :: class.java)
            newIntent.putExtra("QuizLevel", "Advanced")
            startActivity(newIntent)
        }

        return view
    }





}
