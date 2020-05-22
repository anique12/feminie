package com.example.handyman.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.handyman.R

/**
 * A simple [Fragment] subclass.
 */
class JobSeekerAbout : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_job_seeker_about, container, false)
    }


}
