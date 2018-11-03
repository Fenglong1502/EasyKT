package com.example.easykt.easykt


import android.app.SearchManager
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.getSystemService
import android.support.v4.content.ContextCompat.startActivity
import android.view.*
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_note.*
import kotlinx.android.synthetic.main.row_note.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NoteFragment : Fragment() {

    var listNotes = ArrayList<Note>()
    lateinit var notesLv : ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout fori this fragment
        val note = inflater.inflate(R.layout.fragment_note, container, false)
        notesLv = note.findViewById(R.id.notesLv)

        val btnAddNote = note.findViewById<Button>(R.id.btnAddNote)
        btnAddNote.setOnClickListener {
            val newIntent = Intent(this.context, ActivityAddNote :: class.java)
            startActivity(newIntent)
        }

        LoadQuery("%")
        return note
    }

    override fun onResume() {
        super.onResume()
        LoadQuery("%")
    }

    private fun LoadQuery(title: String) {
        var dbManager = DbManager(this.context!!)
        val projections = arrayOf("ID", "Title", "Description")
        val selectionArgs = arrayOf(title)
        val cursor = dbManager.Query(projections, "Title like ?", selectionArgs, "Title")
        listNotes.clear()
        if (cursor.moveToFirst()) {

            do {
                val ID = cursor.getInt(cursor.getColumnIndex("ID"))
                val Title = cursor.getString(cursor.getColumnIndex("Title"))
                val Description = cursor.getString(cursor.getColumnIndex("Description"))

                listNotes.add(Note(ID, Title, Description))

            } while (cursor.moveToNext())
        }

        //adapter
        var myNotesAdapter = MyNotesAdapter(this.context!!, listNotes)
        //set adapter
        notesLv.adapter = myNotesAdapter

        //get total number of tasks from ListView
        val total = notesLv.count
    }


    inner class MyNotesAdapter : BaseAdapter {
        var listNotesAdapter = ArrayList<Note>()
        var context: Context? = null

        constructor(context: Context, listNotesAdapter: ArrayList<Note>) : super() {
            this.listNotesAdapter = listNotesAdapter
            this.context = context
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            //inflate layout row.xml
            var myView = layoutInflater.inflate(R.layout.row_note, null)
            val myNote = listNotesAdapter[position]
            myView.titleTv.text = myNote.nodeName
            myView.descTv.text = myNote.nodeDes
            //delete button click
            myView.deleteBtn.setOnClickListener {
                var dbManager = DbManager(this.context!!)
                val selectionArgs = arrayOf(myNote.nodeID.toString())
                dbManager.delete("ID=?", selectionArgs)
                LoadQuery("%")
            }
            //edit//update button click
            myView.editBtn.setOnClickListener {
                GoToUpdateFun(myNote)
            }

            return myView
        }

        override fun getItem(position: Int): Any {
            return listNotesAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listNotesAdapter.size
        }

    }

    private fun GoToUpdateFun(myNote: Note) {
        var intent = Intent(this.context, ActivityAddNote::class.java)
        intent.putExtra("ID", myNote.nodeID) //put id
        intent.putExtra("name", myNote.nodeName) //ut name
        intent.putExtra("des", myNote.nodeDes) //put description
        startActivity(intent) //start activity
    }

}