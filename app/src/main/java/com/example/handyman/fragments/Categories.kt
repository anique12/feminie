package com.example.handyman.fragments


import CategoryAdapter
import CategoryCallback
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.handyman.Models.service.Service
import com.example.handyman.Models.service.ServiceResponse
import com.example.handyman.R
import com.example.handyman.api.ApiClient
import com.example.handyman.databinding.FragmentCategoriesBinding
import com.example.handyman.utils.SharedPreference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Categories : Fragment(),CategoryCallback {

    private lateinit var categoriesBinding : FragmentCategoriesBinding
    private lateinit var clickedCategory: Service
    private lateinit var progressDialog : ProgressDialog
    private lateinit var pref : SharedPreference

    override fun callBack(service: Service) {
        clickedCategory = service
        actionOnRecyclerViewClick()
    }

    private fun actionOnRecyclerViewClick() {
        val action = CategoriesDirections.actionCategoriesToSubCategories(clickedCategory)
        findNavController().navigate(action)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        categoriesBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_categories,container,false)

        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Loading")
        pref = SharedPreference(context!!)
       // addSubCategories()
        addData()


        return categoriesBinding.root
    }


    private fun addData() {
        val call = ApiClient.getClient.readAllServices(pref.getToken("token")!!)
        showDialogLoading()
        call.enqueue(object : Callback<ServiceResponse>{
            override fun onFailure(call: Call<ServiceResponse>, t: Throwable) {
                removeDialogLoading()
                Toast.makeText(context,t.message,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ServiceResponse>, response: Response<ServiceResponse>) {
                removeDialogLoading()
                if(response.body()?.meta?.status == 200){
                    val serviceResponce = response.body()?.data
                    Log.i("service_msg",response.body()?.meta?.message.toString())
                    categoriesBinding.recyclerViewCategories.apply {
                        layoutManager = GridLayoutManager(context,3)
                        adapter = CategoryAdapter(serviceResponce?.service_list!!,this@Categories)
                    }
                }
                else{
                    removeDialogLoading()
                    Toast.makeText(context,response.body()?.meta?.message,Toast.LENGTH_SHORT).show()
                }


            }

        })

     /*   categoryList.add(
            Category("Content Writing",resources.getString(R.string.person_image),
            subCategorycontentWriting)
        )
        categoryList.add(Category("Tution",resources.getString(R.string.person_image),
            subCategoryTution))
        categoryList.add(Category("Art & Design",resources.getString(R.string.person_image),
            subCategoryArtAndDesign))
        categoryList.add(Category("Beauty",resources.getString(R.string.person_image),
            subCategoryBeauty))
        categoryList.add(Category("Homecare",resources.getString(R.string.person_image),
            subCategoryHomecare))*/




    }

    private fun showDialogLoading(){
        progressDialog.show()
    }

    private fun removeDialogLoading(){
        progressDialog.dismiss()
    }

}
