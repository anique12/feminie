package com.example.handyman.api


import com.example.handyman.Models.jobSeeker.JobSeekerResponce
import com.example.handyman.Models.login.LoginRequest
import com.example.handyman.Models.login.LoginResponse
import com.example.handyman.Models.register.RegisterRequest
import com.example.handyman.Models.register.RegisterResponse
import com.example.handyman.Models.service.ServiceResponse
import com.example.handyman.Models.subService.SubServiceResponce
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("registration/sign_up")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
    @POST("registration/login")
    fun loginUser(@Body loginRequest: LoginRequest):Call<LoginResponse>
    @GET("client/all_services")
    fun readAllServices(@Header("Authorization") authorization : String):Call<ServiceResponse>
    @GET("client/all_sub_services")
    fun readSubService(@Header("Authorization") authorization : String,@Query("service_id") ID : Int):Call<SubServiceResponce>
    @GET("job_poster/get_job_seekers_of_sub_service")
    fun readJobSeekers(@Header("Authorization") authorization : String,@Query("service_id") ID : Int):Call<JobSeekerResponce>


}