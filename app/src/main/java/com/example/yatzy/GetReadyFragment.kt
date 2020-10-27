package com.example.yatzy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class GetReadyFragment : Fragment(){

    lateinit var getReadyTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.get_ready_fragment, container, false)

        getReadyTextView = view.findViewById(R.id.getReadyTextView)
        getReadyTextView.text = getString(R.string.getReady, ObjectManager.currentPlayer.name)
        return view
    }



}