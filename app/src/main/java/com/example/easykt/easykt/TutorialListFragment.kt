package com.example.easykt.easykt

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ListView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TutorialListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TutorialListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TutorialListFragment : Fragment() {
    lateinit var expListView: ExpandableListView
    lateinit var levelList : MutableList<Level>
    var topicList : MutableList<Topic> = ArrayList()
    lateinit var Level_Name: Array<String>
    lateinit var Topic_Name:  Array<String>
    lateinit var l : Level
    lateinit var t : Topic
    lateinit var tutorialListAdapter: TutorialListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_tutorial_list, container, false)
        expListView = view.findViewById(R.id.tutorialExtListView) as ExpandableListView

        levelList = ArrayList()
        prepareListData()

       return view
    }

    private fun prepareListData(){
        Level_Name = resources.getStringArray(R.array.level)
        for (i in 0..Level_Name.size - 1){
            var k: String = Level_Name.get(i)
            var id: Int = resources.getIdentifier(k,"array", this.activity?.packageName)
            try{
                Topic_Name = resources.getStringArray(id)
            }
            catch(e: Exception){
                Topic_Name = arrayOf()
            }
            for (j in 0..Topic_Name.size - 1){
                l = Level(Topic_Name[j])
                levelList.add(l)
            }
            t = Topic(Level_Name[i],levelList)
            topicList.add(t)
            levelList = ArrayList()
        }
        displayList()
    }

    private fun displayList(){

        tutorialListAdapter = TutorialListAdapter(this, topicList)
        expListView.setAdapter(tutorialListAdapter)
    }

}
