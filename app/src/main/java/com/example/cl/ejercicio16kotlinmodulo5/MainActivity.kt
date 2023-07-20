package com.example.cl.ejercicio16kotlinmodulo5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cl.ejercicio16kotlinmodulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PaisCallback {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = Adapter()
        adapter.setData(PaisesLatam.paises)
        adapter.setPaisCallback(this)
        binding.recyclerView.adapter = adapter


    }

    override fun showCountry(s: String) {
        binding.txtPoblacion.text = s
    }
}