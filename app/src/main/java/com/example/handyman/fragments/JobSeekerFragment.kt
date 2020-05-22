package com.example.handyman.fragments


import JobSeekerAdapter
import JobSeekerCallback
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.handyman.Models.jobSeeker.JobSeekerResponce
import com.example.handyman.Models.jobSeeker.Seekers
import com.example.handyman.Models.jobSeeker.Service
import com.example.handyman.R
import com.example.handyman.api.ApiClient
import com.example.handyman.databinding.FragmentJobSeekerBinding
import com.example.handyman.utils.SharedPreference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class JobSeekerFragment : Fragment(),JobSeekerCallback {

    private lateinit var jobSeekerBinding: FragmentJobSeekerBinding
    private lateinit var jobSeeker: ArrayList<Seekers>
    private lateinit var clickedJobSeeker : Seekers
    private lateinit var pref : SharedPreference

    override fun callback(jobSeeker: Seekers) {
        clickedJobSeeker = jobSeeker
        val action = JobSeekerFragmentDirections.actionJobSeekerFragmentToJobSeekerProfile(clickedJobSeeker)
        findNavController().navigate(action)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        jobSeekerBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_job_seeker,container,false)
        jobSeeker = ArrayList()
        pref = SharedPreference(context!!)
        val service = arguments?.getParcelable<com.example.handyman.Models.service.Service>("service")
        jobSeekerBinding.servieName.text = service?.title
        val call = ApiClient.getClient.readJobSeekers(pref.getToken("token")!!,service?.id!!)
        call.enqueue(object : Callback<JobSeekerResponce>{
            override fun onFailure(call: Call<JobSeekerResponce>, t: Throwable) {
                Toast.makeText(context,t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<JobSeekerResponce>, response: Response<JobSeekerResponce>) {
                if(response.body()?.meta?.status == 200){
                    val jobSeekerResponce = response.body()?.data
                    jobSeekerBinding.recyclerViewJobSeeker.adapter = JobSeekerAdapter(this@JobSeekerFragment,jobSeekerResponce!!.seekers_list,service.title)

                }
            }

        })

       /* val args = JobSeekerFragmentArgs.fromBundle(arguments!!).subCategory
        clickedSubCategory = gson.fromJson(args,SubCategory::class.java)
        Toast.makeText(context,clickedSubCategory.name,Toast.LENGTH_LONG).show()
        jobSeekerBinding.recyclerViewJobSeeker.adapter = JobSeekerAdapter(this,jobSeeker)*/
        return jobSeekerBinding.root
    }





}
