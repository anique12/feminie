package com.example.handyman.fragments


import RequestAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.handyman.Models.Request

import com.example.handyman.R
import com.example.handyman.databinding.FragmentRequestCompletedBinding

/**
 * A simple [Fragment] subclass.
 */
class RequestCompleted : Fragment() {

    private lateinit var requestComBinding : FragmentRequestCompletedBinding
    private var list = ArrayList<Request>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        requestComBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_request_completed,container,false)
        addData()
        requestComBinding.recyclerViewCompletedRequest.adapter = RequestAdapter(list)
        return requestComBinding.root
    }
    private fun addData() {
        list.add(Request(resources.getString(R.string.person_image),"Aliza Smith","Plumber","200","Rejected","21 jan,09:00-11:00"))
        list.add(Request(resources.getString(R.string.person_image),"Aliza Smith","Plumber","200","Rejected","21 jan,09:00-11:00"))
    }

}
