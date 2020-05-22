package com.example.handyman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.handyman.Models.register.RegisterRequest
import com.example.handyman.api.ApiClient
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.app.ProgressDialog
import com.example.handyman.Models.register.RegisterResponse


class SignUp : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading")
        signupNow_signup.setOnClickListener {
            val username = user_signUp.text.toString()
            val email = email_signUp.text.toString()
            val password = password_signUp.text.toString()
            val registerRequest = RegisterRequest(email,password,1,username)
            val call = ApiClient.getClient.registerUser(registerRequest)
            showDialogLoading()
            call.enqueue(object : Callback<RegisterResponse>{
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    removeDialogLoading()
                    Toast.makeText(this@SignUp,t.message,Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if(response.isSuccessful){
                        removeDialogLoading()
                        if (response.body()?.meta?.status==200){
                            Log.i("RequestResponce",response.body()?.meta!!.message)
                            Toast.makeText(this@SignUp, response.body()?.meta?.message,Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignUp,MainActivity::class.java)
                            startActivity(intent)
                            finishAffinity()
                        }else{
                            Log.i("RequestResponce",response.body()?.meta?.message!!)
                            Toast.makeText(this@SignUp,response.body()?.meta?.message,Toast.LENGTH_SHORT).show()

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
