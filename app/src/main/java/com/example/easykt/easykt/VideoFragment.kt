package com.example.easykt.easykt

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [VideoFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [VideoFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class VideoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_video, container, false)

        var listView = view.findViewById<ListView>(R.id.vidListView)

        var vidAdapter = VideoAdapter(this)
        listView.adapter = vidAdapter

        //to change vidAdapter.url[position] to get the url of the link.
        listView.setOnItemClickListener{ parent, view, position, id ->
            //Toast.makeText(this, "You Clicked: " + vidAdapter.url[position],Toast.LENGTH_SHORT).show()
            var goToUrl = vidAdapter.url[position]
            val uris = Uri.parse(goToUrl)
            val myIntent = Intent(Intent.ACTION_VIEW, uris)
            val b = Bundle()
            b.putBoolean("new_window", true)
            myIntent.putExtras(b)
            startActivity(myIntent)
        }

        return view
    }


    class VideoAdapter(private val context: Fragment) : BaseAdapter() {
        //Array of title
        var names = arrayOf(
                "Introduction to Kotlin Programming Language",
                "Kotlin Hello World Part 1",
                "Kotlin Hello World Part 2",
                "Kotlin Basic Syntax: Comments",
                "Kotlin Basic Syntax: Variables and Data Types",
                "Kotlin Basic Syntax: Function Class Part 1",
                "Kotlin Basic Syntax: Function Class Part 2",
                "Kotlin VAR vs VAL Part 1",
                "Kotlin VAR vs VAL Part 2",
                "Kotlin String Templates",
                "Kotlin Ranges",
                "Kotlin IF as Expression",
                "Kotlin WHEN as Expression",
                "Kotlin FOR Loop",
                "Kotlin WHILE Loop",
                "Kotlin DO-WHILE Loop",
                "Kotlin Functions",
                "Kotlin Named Parameters",
                "Kotlin Extension Function",
                "Kotlin Tailrec Function")

        //Array of timestamp
        var desc = arrayOf(
                "5:58",
                "10:02",
                "9:00",
                "1:57",
                "3:19",
                "7:53",
                "4:16",
                "6:15",
                "4:39",
                "7:01",
                "6:15",
                "3:41",
                "8:16",
                "4:40",
                "4:17",
                "4:17",
                "6:33",
                "3:43",
                "11:36",
                "6:48")

        //Array of images
        var image = intArrayOf(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10,
                R.drawable.image11,
                R.drawable.image12,
                R.drawable.image13,
                R.drawable.image14,
                R.drawable.image15,
                R.drawable.image16,
                R.drawable.image17,
                R.drawable.image18,
                R.drawable.image19,
                R.drawable.image20)

        //array of url
        var url = arrayOf(
                "https://www.youtube.com/watch?v=iC8LRjd67Ds",
                "https://www.youtube.com/watch?v=G6oVG5XetnE",
                "https://www.youtube.com/watch?v=MM1jRsXiWBg",
                "https://www.youtube.com/watch?v=LANjqm3Sfpw",
                "https://www.youtube.com/watch?v=TGYehzj_NFI",
                "https://www.youtube.com/watch?v=KQbVF-GVDU0",
                "https://www.youtube.com/watch?v=5GyB6Ndy818",
                "https://www.youtube.com/watch?v=qAJTqI_aKJU",
                "https://www.youtube.com/watch?v=SItGASY92HE",
                "https://www.youtube.com/watch?v=EXPZqS8UBrk",
                "https://www.youtube.com/watch?v=jNRbbMKOd-E",
                "https://www.youtube.com/watch?v=CkvYXSpXS2s",
                "https://www.youtube.com/watch?v=2V6et2FdS8I",
                "https://www.youtube.com/watch?v=ugz2W_yF208",
                "https://www.youtube.com/watch?v=FSHjROeqT38",
                "https://www.youtube.com/watch?v=cWuVrCxtRqM",
                "https://www.youtube.com/watch?v=YxixgkS_B1s",
                "https://www.youtube.com/watch?v=X8K4eNgzk1s",
                "https://www.youtube.com/watch?v=6oFvZKF6KKg",
                "https://www.youtube.com/watch?v=J2We4LfGZhc"
        )

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var inflater = context.layoutInflater
            var view1 = inflater.inflate(R.layout.row_data, null)

            var fName = view1.findViewById<TextView>(R.id.fname)
            var fDesc = view1.findViewById<TextView>(R.id.fdesc)
            var fImage = view1.findViewById<ImageView>(R.id.fImage)


            fName.setText(names[position])
            fDesc.setText(desc[position])
            fImage.setImageResource(image[position])


            return view1
        }

        override fun getItem(position: Int): Any {
            return image[position]
        }

        override fun getItemId(position: Int): Long {
            return image[position].toLong()
        }

        override fun getCount(): Int {
            return image.size
        }
    }
}
