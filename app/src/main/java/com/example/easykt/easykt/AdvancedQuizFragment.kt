package com.example.easykt.easykt


import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.easykt.easykt.R.id.*
import kotlinx.android.synthetic.main.fragment_advanced_quiz.*
import kotlinx.android.synthetic.main.fragment_beginner_quiz.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONException
import java.util.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AdvancedQuizFragment : Fragment() {
    var Questionlist: MutableList<Question> = ArrayList()
    lateinit var context: Fragment
    lateinit var btn_next: Button

    var index = -1
    var score = 0


    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_advanced_quiz, container, false)

        context = this
        btn_next = view.findViewById<Button>(R.id.btn_next_advanced)

        btn_next.isEnabled = false
        btn_next.alpha = 0.5.toFloat()
        getQuestion().execute()

        return view
    }


    fun UpdateQuestion() {
        val selected = adv_rg_choice.checkedRadioButtonId
        if (selected == -1) {
            Toast.makeText(activity, "Please select an option.", Toast.LENGTH_SHORT).show()
            return
        }
        if (index < Questionlist.size) {
            when (selected) {
                adv_rb_choice1.id -> {
                    if (Questionlist[index].Answer == 1)
                        score++
                }
                adv_rb_choice2.id -> {
                    if (Questionlist[index].Answer == 2)
                        score++
                }
                adv_rb_choice3.id -> {
                    if (Questionlist[index].Answer == 3)
                        score++
                }
                adv_rb_choice4.id -> {
                    if (Questionlist[index].Answer == 4)
                        score++
                }
            }
            index++
            if (index < Questionlist.size) {
                tvQnsAdv.text = Questionlist[index].Question
                adv_rb_choice1.text = Questionlist[index].Option1
                adv_rb_choice2.text = Questionlist[index].Option2
                adv_rb_choice3.text = Questionlist[index].Option3
                adv_rb_choice4.text = Questionlist[index].Option4
                adv_rg_choice.clearCheck()
                if ((index + 1) == Questionlist.size)
                    btn_next_advanced.text = "Finish"
            } else {
                Toast.makeText(this.context.context, "You have score " + score + "/10. ", Toast.LENGTH_LONG).show()
                val i = Intent(context.context, ActivityDisplay::class.java)
                i.putExtra("FragmentToPass", "quiz")
                startActivity(i)
            }
        }
    }


    internal inner class getQuestion : AsyncTask<Void, Void, String>() {

        lateinit var progressDialog: ProgressDialog
        var hasInternet = false

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(context.context)
            progressDialog.setMessage("Downloading Questions...")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun doInBackground(vararg params: Void?): String {
            if (isNetworkAvailable()) {
                hasInternet = true
                val client = OkHttpClient()
                val url = "https://houseofcasesg.website/image-upload/advancedquiz.json"
                val request = Request.Builder().url(url).build()
                val response = client.newCall(request).execute()
                return response.body()?.string().toString()
            } else {
                return ""
            }
        }

        override fun onPostExecute(result: String?) {
            progressDialog.dismiss()
            if (hasInternet) {
                try {
                    val resultArray = JSONArray(result)
                    for (i in 0..(resultArray.length() - 1)) {
                        val currentObject = resultArray.getJSONObject(i)
                        val obj = Question()
                        obj.Question = currentObject.getString("Question")
                        obj.Option1 = currentObject.getString("Option1")
                        obj.Option2 = currentObject.getString("Option2")
                        obj.Option3 = currentObject.getString("Option3")
                        obj.Option4 = currentObject.getString("Option4")
                        obj.Answer = currentObject.getInt("Answer")
                        Questionlist.add(obj)
                    }
                    if (index == -1) {
                        index++
                        Log.d("result", "Question : " + Questionlist[index].Question)
                        tvQnsAdv.text = Questionlist[index].Question
                        adv_rb_choice1.text = Questionlist[index].Option1
                        adv_rb_choice2.text = Questionlist[index].Option2
                        adv_rb_choice3.text = Questionlist[index].Option3
                        adv_rb_choice4.text = Questionlist[index].Option4
                    } else {
                        Log.d("result", "index : " + index)
                        UpdateQuestion()
                    }
                    btn_next.isEnabled = true
                    btn_next.alpha = 1.toFloat()
                    btn_next.setOnClickListener({
                        if (index == -1) {
                            index++
                            tvQnsAdv.text = Questionlist[index].Question
                            adv_rb_choice1.text = Questionlist[index].Option1
                            adv_rb_choice2.text = Questionlist[index].Option2
                            adv_rb_choice3.text = Questionlist[index].Option3
                            adv_rb_choice4.text = Questionlist[index].Option4
                        } else {
                            UpdateQuestion()
                        }
                    })
                    Log.d("result", "result : " + result)
                } catch (e: JSONException) {
                }
            }
        }
    }
}

