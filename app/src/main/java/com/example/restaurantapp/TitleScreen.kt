package com.example.restaurantapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.Group
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        //var addressText : TextView = requireView().findViewById(R.id.Address)
        //var button1 : Button = requireView().findViewById(R.id.displayAddressButton)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Initiallizing Buttons and TextViews from fragment_title_screen
        val addressButton: Button = view.findViewById(R.id.displayAddressButton)
        val mapButton: Button = view.findViewById(R.id.sendToMap)
        val addressText: TextView = view.findViewById(R.id.Address)
        val hoursButton: Button = view.findViewById(R.id.displayHoursButton)
        val hourText: TextView = view.findViewById(R.id.Hours)

        addressButton.setOnClickListener {
            if (addressText.visibility == View.GONE) {
                addressText.visibility = View.VISIBLE
                mapButton.visibility = View.VISIBLE
            } else {
                addressText.visibility = View.GONE
                mapButton.visibility = View.GONE
            }
        }

        hoursButton.setOnClickListener {
            if (hourText.visibility == View.GONE) {
                hourText.visibility = View.VISIBLE
            } else {
                hourText.visibility = View.GONE
            }
        }

        mapButton.setOnClickListener{
            val gmmIntentUri = Uri.parse("geo:0,0?q=Stingers Dining Hall")
            //val gmmIntentUri = Uri.parse("geo:0,0?q=1100 South Marietta Pkwy SE, Marietta, GA")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TitleScreen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TitleScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}