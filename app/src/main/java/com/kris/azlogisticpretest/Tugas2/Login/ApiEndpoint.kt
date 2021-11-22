package com.kris.azlogisticpretest.Tugas2.Login

import com.kris.azlogisticpretest.Tugas2.Login.models.Barang
import com.kris.azlogisticpretest.Tugas2.Login.models.info
import com.kris.azlogisticpretest.Tugas2.Login.models.login
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {

    @POST("api/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("device_id") device_id: Int,
        @Field("companyID") companyID: Int
    ) : Call<login>

    @GET("albums/1/photos")
    fun getData() : Call<Barang>

    @GET("photos/{id}")
    fun getInfo() : Call<info>
}