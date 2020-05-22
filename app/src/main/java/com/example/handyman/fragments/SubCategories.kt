package com.example.handyman.fragments


import SubCategoryAdapter
import SubCategorycallback
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.handyman.Models.service.Service
import com.example.handyman.Models.service.ServiceResponse
import com.example.handyman.Models.subService.SubService
import com.example.handyman.Models.subService.SubServiceResponce
import com.example.handyman.R
import com.example.handyman.api.ApiClient
import com.example.handyman.databinding.FragmentSubcategoriesBinding
import com.example.handyman.utils.SharedPreference
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */

class SubCategories : Fragment(),SubCategorycallback {

    override fun callback(subCategory: SubService) {
        val action = SubCategoriesDirections.actionSubCategoriesToJobSeekerFragment(service)
        findNavController().navigate(action)
    }

    private lateinit var pref : SharedPreference
    private lateinit var service : Service




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSubcategoriesBinding>(inflater,R.layout.fragment_subcategories,container,false)
        service  = arguments?.getParcelable("service")!!
        pref = SharedPreference(context!!)
        Picasso.get().load(service?.service_img).into(binding.cateogryPhotoSubcategory)
        binding.categoryNameSubcategory.text = service?.title
        val call = ApiClient.getClient.readSubService(pref.getToken("token")!!,service!!.id)
        call.enqueue(object : Callback<SubServiceResponce>{

            override fun onFailure(call: Call<SubServiceResponce>, t: Throwable) {
                Toast.makeText(context,t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<SubServiceResponce>, response: Response<SubServiceResponce>) {
                if(response.body()?.meta?.status == 200){
                    val subServiceResponce = response.body()?.data
                    binding.recyclerViewSubcategory.adapter = SubCategoryAdapter(subServiceResponce!!.sub_service_list,this@SubCategories)
                }
            }


        })
        return binding.root
    }



}
