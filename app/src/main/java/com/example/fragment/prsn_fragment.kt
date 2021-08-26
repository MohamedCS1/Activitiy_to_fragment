package com.example.fragment

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [prsn_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class prsn_fragment : Fragment() {


    var name:String? = null
    var prnm:String? = null
    var age:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val arg = arguments

        name = arg?.getString("prsn_name")
        prnm = arg?.getString("prsn_prnm")
        age = arg?.getInt("prsn_age")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val v:View = inflater.inflate(R.layout.fragment_prsn_fragment, container, false)

        val f_name = v.findViewById<TextView>(R.id.f_tv_name)
        val f_prnm = v.findViewById<TextView>(R.id.f_tv_prnm)
        val f_age = v.findViewById<TextView>(R.id.f_tv_age)

        if (name.isNullOrEmpty())
        {
            f_name.setTextColor(Color.parseColor("#FF03DAC5"))
            f_prnm.setTextColor(Color.parseColor("#FF03DAC5"))
            f_age.setTextColor(Color.parseColor("#FF03DAC5"))
        }

        f_name.text = name.toString()
        f_prnm.text = prnm.toString()
        f_age.text = age.toString()

        return v

    }

}