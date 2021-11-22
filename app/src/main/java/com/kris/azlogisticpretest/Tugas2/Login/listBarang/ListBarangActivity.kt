package com.kris.azlogisticpretest.Tugas2.Login.listBarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.kris.azlogisticpretest.R
import com.kris.azlogisticpretest.Tugas2.Login.ApiRetrofit
import com.kris.azlogisticpretest.Tugas2.Login.adapter.BarangAdapter
import com.kris.azlogisticpretest.Tugas2.Login.detailBarang.DetailBarangActivity
import com.kris.azlogisticpretest.Tugas2.Login.models.Barang
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListBarangActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }

    private lateinit var listBarang: RecyclerView
    private lateinit var barangAdapter: BarangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_barang)

        getBarang()

        setupView()
        setupList()
    }

    private fun getBarang() {
        api.getData().enqueue(object : Callback<Barang>{
            override fun onResponse(call: Call<Barang>, response: Response<Barang>) {
                if (response.isSuccessful){
                    val listBarang = response.body()!!.database
                    barangAdapter.setData(listBarang)
                }
            }

            override fun onFailure(call: Call<Barang>, t: Throwable) {

            }

        })
    }

    private fun setupView() {
        listBarang = findViewById(R.id.rvItem)
    }

    private fun setupList() {
        barangAdapter= BarangAdapter(arrayListOf(), object: BarangAdapter.OnAdapterListener{
            val startForResult =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
                startActivity(
                    Intent(this@ListBarangActivity,ListBarangActivity::class.java))
            }

            override fun getInfo(database: Barang.Database) {
                startForResult.launch(
                    Intent(this@ListBarangActivity,DetailBarangActivity::class.java)
                        .putExtra("id", database.id)
                        .putExtra("title", database.title)
                        .putExtra("url",database.url)

                )
            }
        })
    }


}