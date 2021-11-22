package com.kris.azlogisticpretest.Tugas2.Login.detailBarang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.kris.azlogisticpretest.R
import com.kris.azlogisticpretest.Tugas2.Login.ApiRetrofit

class DetailBarangActivity : AppCompatActivity() {

    private lateinit var idBarang: TextView
    private lateinit var tittleBarang: TextView
    private lateinit var urlBarang: TextView
    private lateinit var gambarBarang: ImageView

    private val api by lazy { ApiRetrofit().endpoint }
    private val id by lazy { intent.getIntExtra("id", 0) }
    private val title by lazy { intent.getStringExtra("title")}
    private val url by lazy{ intent.getStringExtra("url")}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_barang)

        setupView()
    }

    private fun setupView() {
        idBarang = findViewById(R.id.etNamaBarang)
        tittleBarang = findViewById(R.id.etTittle)
        urlBarang = findViewById(R.id.etUrl)

        idBarang.setText(id)
        tittleBarang.setText(title)
        urlBarang.setText(url)
    }
}