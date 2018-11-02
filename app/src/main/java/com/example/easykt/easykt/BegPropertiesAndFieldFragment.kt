package com.example.easykt.easykt

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BegPropertiesAndFieldFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BegPropertiesAndFieldFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BegPropertiesAndFieldFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beg_properties_and_field, container, false)

        val myWebView = view.findViewById<WebView>(R.id.tutorialWebview)
        myWebView.setInitialScale(1)
        myWebView.settings.useWideViewPort = true
        myWebView.settings.loadWithOverviewMode = true
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.builtInZoomControls = true


        myWebView.loadUrl("file:///android_asset/beg_propertiesandfields.html")


        return view

    }
}
