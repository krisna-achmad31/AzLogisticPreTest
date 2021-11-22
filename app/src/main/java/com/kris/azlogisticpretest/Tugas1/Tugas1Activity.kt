package com.kris.azlogisticpretest.Tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kris.azlogisticpretest.R

class Tugas1Activity : AppCompatActivity() {

    private lateinit var integer: TextView
    private var int : Int = 7777
    private var nama: String = "Achmad Yukrisna A"
    private var belakang: String = "Morning Glory Enterprise Developer"
    private lateinit var tugas3: TextView
    private lateinit var tugas3baru : TextView
    private lateinit var tugas4: TextView
    private lateinit var kota: Array<String>
    private lateinit var tugas5: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas1)

        initView()
    }

    private fun initView() {

        integer  =  findViewById(R.id.tvInt)
        integer.setText(int)

        tugas3 = findViewById(R.id.tvTugas3)
        tugas3.setText(nama+belakang)

        tugas3baru = findViewById(R.id.tvTugas3_1)
        val namabaru = nama+belakang
        tugas3baru.setText(namabaru.replace("o","a"))

        tugas4 = findViewById(R.id.tvTugas4)
        kota = arrayOf("surabaya","jakarta","semarang","makasar")
        tugas4.setText(kota.set(2,"Samarinda").toString())

        tugas5 = findViewById(R.id.tvTugas5)
        kota[4] = "Aceh"
        tugas5.setText(kota.toString())


    }
}