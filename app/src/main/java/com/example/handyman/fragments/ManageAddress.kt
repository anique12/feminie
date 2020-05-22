package com.example.handyman.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.handyman.R
import com.example.handyman.databinding.FragmentManageAddressBinding

/**
 * A simple [Fragment] subclass.
 */
class ManageAddress : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentManageAddressBinding>(inflater,R.layout.fragment_manage_address,container,false)
        return binding.root
        }


}
