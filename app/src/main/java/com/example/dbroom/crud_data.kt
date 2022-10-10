package com.example.dbroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbroom.adapter.dataAdapter
import com.example.dbroom.adapter.dataViewMolder
import com.example.dbroom.databinding.ActivityCrudDataBinding
import com.example.dbroom.databinding.ActivityMainBinding
import com.example.navegacion.DB.Registro

class crud_data : AppCompatActivity(), dataAdapter.methodClick {
    private lateinit var binding: ActivityCrudDataBinding
    lateinit var recyclerAdapter: dataAdapter
    lateinit var viewModel: dataViewMolder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrudDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDatos.apply {
            layoutManager = LinearLayoutManager(this@crud_data)
            recyclerAdapter= dataAdapter(this@crud_data)
            adapter = recyclerAdapter

        }

        viewModel = ViewModelProvider(this).get(dataViewMolder::class.java)
        viewModel.getAllRegistrosObserver().observe(this, Observer {
            recyclerAdapter.setListData(ArrayList(it))
            recyclerAdapter.notifyDataSetChanged()
        })


        binding.btn.setOnClickListener {
            lateinit var gender:String
            binding.apply {
                if (rbF.isChecked){
                    gender = "Femenino"
                } else if(rbM.isChecked){
                    gender = "Masculino"
                }
                val name = etName.text.toString()
                val lastname = etLastname.text.toString()
                if(btn.text.equals("Guardar")) {
                    val newRegister = Registro(0, name, lastname, gender)
                    viewModel.insert(newRegister)
                }else{
                    val newRegister = Registro(etName.getTag(etName.id).toString().toInt(),name, lastname, gender)
                    viewModel.update(newRegister)

                    btn.setText("Guardar")
                }
                etName.setText("")
                etLastname.setText("")
            }
        }

    }

    override fun editClick(registro: Registro) {
        binding.apply {
            etName.setText(registro.nombre)
            etLastname.setText(registro.apellido)
            if(registro.genero == "Femenino"){
                rbF.isChecked = true
            }else if(registro.genero == "Masculino"){
                rbM.isChecked = true
            }
            etName.setTag(etName.id, registro.regId)

            btn.setText("Actualizar")
        }
    }
    override fun deleteClick(registro: Registro) {
        viewModel.delete(registro)
    }



}