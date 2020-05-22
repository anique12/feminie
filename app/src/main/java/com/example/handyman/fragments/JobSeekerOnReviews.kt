package com.example.handyman.fragments


import ReviewAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.handyman.Models.Review
import com.example.handyman.R
import com.example.handyman.databinding.FragmentJobSeekerOnReviewsBinding


class JobSeekerOnReviews : Fragment() {
    private lateinit var jobSeekerOnReviewsBinding: FragmentJobSeekerOnReviewsBinding
    private var list = ArrayList<Review>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        jobSeekerOnReviewsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_job_seeker_on_reviews,container,false)
        list.add(Review(resources.getString(R.string.person_image),"Emol Williams","4.0","21st Jan'18","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))
        list.add(Review(resources.getString(R.string.person_image),"Emol Williams","5.0","21st Jan'18","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))
        jobSeekerOnReviewsBinding.recyclerViewReviews.adapter = ReviewAdapter(list)
        return jobSeekerOnReviewsBinding.root
    }


}
