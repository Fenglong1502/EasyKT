package com.example.easykt.easykt

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.startActivity
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class TutorialListAdapter : BaseExpandableListAdapter{
    lateinit var context : Fragment
    lateinit var topicList: MutableList<Topic>
    lateinit var levelList: MutableList<Level>

    constructor(context: Fragment, topicList: MutableList<Topic>) : super() {
        this.context = context
        this.topicList = mutableListOf()
        this.topicList.addAll(topicList)
    }

    override fun getGroup(groupPosition: Int): Any {
        return topicList.get(groupPosition)
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var t : Topic = getGroup(groupPosition)as Topic
        var inflater : LayoutInflater = context.activity!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rv: View = if(convertView == null){
            inflater.inflate(R.layout.tutorial_list_group,null)

        }
        else{
            convertView
        }
        var tv: TextView = rv.findViewById(R.id.tvTutorialListHeader) as TextView
        tv.setText(t.getName().trim())
        if(isExpanded){}
        return rv
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        levelList = topicList.get(groupPosition).getLevelList()
        return levelList.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        levelList = topicList.get(groupPosition).getLevelList()
        return levelList.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        var l : Level = getChild(groupPosition, childPosition) as Level
        var inflator : LayoutInflater = context.activity!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var rv: View = if(convertView == null)
        {
            inflator.inflate(R.layout.tutorial_list_item,null)
        }
        else{
            convertView
        }
        var tv: TextView = rv.findViewById(R.id.tvTutorialListItem) as TextView
        tv.setText(l.getName().trim())
        tv.setOnClickListener(object: View.OnClickListener{
                override fun onClick(v: View?){
                    //Toast.makeText(context.context, "You Clicked : ${tv.text.toString()}", Toast.LENGTH_LONG).show()
                    var myIntent = Intent(context.context, ActivityTutorial::class.java)
                    myIntent.putExtra("TutorialToGo", tv.text.toString())
                    context.startActivity(myIntent)
                }
        })
        return rv
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return topicList.size
    }


}