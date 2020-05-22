package com.example.handyman

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.handyman.Models.login.LoginRequest
import com.example.handyman.Models.login.LoginResponse
import com.example.handyman.api.ApiClient
import com.example.handyman.utils.SharedPreference
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog
    private lateinit var pref : SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading")
        pref = SharedPreference(this)
        gotoSignUp.setOnClickListener {
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        continue_btn_login.setOnClickListener {
            val email = username_login.text.toString()
            val password = password_login.text.toString()
            val loginRequest = LoginRequest(email,password)
            val call = ApiClient.getClient.loginUser(loginRequest)
            showDialogLoading()
            call.enqueue(object : Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@Login,t.message,Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if(response.isSuccessful){
                        removeDialogLoading()
                        if (response.body()?.meta?.status==200){
                            Log.i("RequestResponce",response.body()?.meta?.message!!)
                            Toast.makeText(this@Login, response.body()?.meta?.message, Toast.LENGTH_SHORT).show()
                            pref.saveToken("token",response.body()?.data?.access_token!!)
                            val intent = Intent(this@Login,MainActivity::class.java)
                            startActivity(intent)
                            finishAffinity()
                        }else{
                            Log.i("RequestResponce",response.body()?.meta?.message!!)
                            Toast.makeText(this@Login,response.body()?.meta?.message, Toast.LENGTH_SHORT).show()

                        }
                    }
                    else{
                        removeDialogLoading()

                    }
                }

            })
        }
    }

    private fun showDialogLoading(){
        progressDialog.show()
    }

    private fun removeDialogLoading(){
        progressDialog.dismiss()
    }
}
