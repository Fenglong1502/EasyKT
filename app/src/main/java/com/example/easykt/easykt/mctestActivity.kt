package com.example.easykt.easykt

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayerView
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_mctest.*

class mctestActivity : YouTubeBaseActivity() {

    companion object {
        val api = "AIzaSyAJ6Y8zXeAQTj30tfNtbQpsuzrw4xs5Ifs"
        val vidID = "dQw4w9WgXcQ"
    }


    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mctest)

        initUI()

    }

    private fun initUI() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayerView: YouTubePlayer?, p2: Boolean) {
                youtubePlayerView?.loadVideo(vidID)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                Toast.makeText(applicationContext, "Something wrong", Toast.LENGTH_SHORT).show()
            }
        }

        btn_play.setOnClickListener(View.OnClickListener { v ->
           youtubePlayerView.initialize(api, youtubePlayerInit)
        })

    }
}
