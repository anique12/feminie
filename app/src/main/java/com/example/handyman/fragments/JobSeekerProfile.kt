package com.example.handyman.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import com.example.handyman.Models.Review
import com.example.handyman.Models.jobSeeker.Seekers

import com.example.handyman.R
import com.example.handyman.databinding.FragmentJobSeekerProfileBinding
import com.google.android.material.tabs.TabLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.review_single_layout.*

/**
 * A simple [Fragment] subclass.
 */
class JobSeekerProfile : Fragment() {

    private lateinit var jobSeekerBindingProfile : FragmentJobSeekerProfileBinding
    private var list = ArrayList<Review>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        jobSeekerBindingProfile = DataBindingUtil.inflate(inflater,R.layout.fragment_job_seeker_profile,container,false)
        val seeker  = arguments?.getParcelable<Seekers>("seeker")
        if(seeker?.general_information?.profile_image != ""){
            Picasso.get().load(seeker?.general_information?.profile_image).into(jobSeekerBindingProfile.imageJSeekerProfile)
        }
        jobSeekerBindingProfile.hourlyRate.text = seeker!!.hourly_rate.toString()
        jobSeekerBindingProfile.name.text = seeker.general_information.name
        jobSeekerBindingProfile.service.text = seeker.main_service.title
        jobSeekerBindingProfile.bookNowProfile.setOnClickListener {
            findNavController().navigate(R.id.action_jobSeekerProfile_to_book)
        }
        return jobSeekerBindingProfile.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jobSeekerBindingProfile.tabLayoutProfile.addTab(jobSeekerBindingProfile.tabLayoutProfile.newTab().setText("About"))
        jobSeekerBindingProfile.tabLayoutProfile.addTab(jobSeekerBindingProfile.tabLayoutProfile.newTab().setText("Reviews"))
        val adapter = JobSeekerProfilePagerAdapter(childFragmentManager,jobSeekerBindingProfile.tabLayoutProfile.tabCount)
        jobSeekerBindingProfile.pagerProfile.adapter = adapter
        jobSeekerBindingProfile.pagerProfile.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(jobSeekerBindingProfile.tabLayoutProfile))
        jobSeekerBindingProfile.tabLayoutProfile.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                jobSeekerBindingProfile.pagerProfile.currentItem = p0!!.position
            }

        })

    }
}

class JobSeekerProfilePagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> JobSeekerAbout()
            1 -> JobSeekerOnReviews()
            else -> null!!
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
