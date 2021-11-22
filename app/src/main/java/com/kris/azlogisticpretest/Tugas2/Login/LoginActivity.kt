package com.kris.azlogisticpretest.Tugas2.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kris.azlogisticpretest.R
import com.kris.azlogisticpretest.Tugas2.Login.models.login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var deviceId: EditText
    private lateinit var companyID: EditText
    private lateinit var btnLogin: Button

    private val api by lazy {ApiRetrofit().endpoint}
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
        setupListener()
    }

    private fun setupView() {
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)
        deviceId = findViewById(R.id.etDeviceId)
        companyID = findViewById(R.id.etCompanyID)
        btnLogin = findViewById(R.id.btnLogin)
    }

    private fun setupListener() {
        btnLogin.setOnClickListener {
            if (email.text.toString().isNotEmpty()&&password.text.toString().isNotEmpty()&&deviceId.text.toString().isNotEmpty()&&companyID.text.toString().isNotEmpty()){
                api.login(email.text.toString(),password.text.toString(),deviceId.text.toString().toInt(),companyID.text.toString().toInt())
                    .enqueue(object: Callback<login>{
                        override fun onResponse(call: Call<login>, response: Response<login>) {
                            if (response.isSuccessful){
                                val add = response.body()
                                if (add != null){
                                    Toast.makeText(applicationContext, add.email, Toast.LENGTH_SHORT)
                                        .show()
                                    finish()
                                }
                            }
                        }

                        override fun onFailure(call: Call<login>, t: Throwable) {

                        }

                    })
            }else{
                Toast.makeText(applicationContext,"Data Harus Diisi Semua", Toast.LENGTH_SHORT).show()
            }
        }
    }
}