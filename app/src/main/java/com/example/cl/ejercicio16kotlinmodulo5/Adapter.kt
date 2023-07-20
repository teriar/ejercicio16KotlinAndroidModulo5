package com.example.cl.ejercicio16kotlinmodulo5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.ejercicio16kotlinmodulo5.databinding.ItemLayoutBinding


class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {
      var paises = mutableListOf<Pais>()
      var callback : PaisCallback? = null

    fun setPaisCallback(c:PaisCallback){
        this.callback = c
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding =ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent , false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    fun setData(listaPaises: List<Pais>){
        paises = listaPaises.toMutableList()
    }
    inner class ViewHolder (val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root){
     fun bind(item:Pais){

         val texto = "Pais:${item.nombre} Poblacion:${item.poblacion}"
         binding.txtNombre.text = item.nombre
         binding.bandera.load(item.imgUrl)
         binding.txtPoblacion.text = item.poblacion.toString()

         binding.cardView.setOnClickListener(View.OnClickListener {
             callback?.showCountry(texto)
         })
     }

    }
}
interface PaisCallback {
    fun showCountry(s:String)
}