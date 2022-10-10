package com.example.dbroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dbroom.R
import com.example.dbroom.databinding.ItemListaBinding
import com.example.navegacion.DB.Registro


class dataAdapter(val listener: methodClick) : RecyclerView.Adapter<dataAdapter.myViewHolder>()  {
    var items=ArrayList<Registro>()
    fun setListData(data: ArrayList<Registro>){
        this.items = data

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return myViewHolder(layoutInflater, listener)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener.editClick(items[position]) }
        holder.itemView.setOnClickListener { listener.deleteClick(items[position]) }
        holder.bind(items[position])
    }
    override fun getItemCount(): Int = items.size

    class myViewHolder(view: View, val listener:methodClick): RecyclerView.ViewHolder(view){
        var binding = ItemListaBinding.bind(view)
        fun bind(registro: Registro){
            binding.tvName.text = registro.nombre
            binding.tvLastname.text = registro.apellido
            binding.tvGender.text = registro.genero

            binding.ibEdit.setOnClickListener {
                listener.editClick(registro)
            }

            binding.ibDelete.setOnClickListener {
                listener.deleteClick(registro)
            }
        }
    }

    interface methodClick{
        fun deleteClick(registro: Registro){

        }
        fun editClick(registro: Registro){

        }
    }


}