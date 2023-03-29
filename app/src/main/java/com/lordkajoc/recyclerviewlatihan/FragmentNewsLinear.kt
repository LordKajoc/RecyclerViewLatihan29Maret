package com.lordkajoc.recyclerviewlatihan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerviewlatihan.databinding.FragmentNewsLinearBinding

class FragmentNewsLinear : Fragment() {
    val list = ArrayList<KumpulanData>()
    lateinit var binding: FragmentNewsLinearBinding
    lateinit var recyclerViewLinear: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsLinearBinding.inflate(layoutInflater, container, false)
        recyclerViewLinear = binding.recyclerView
        recyclerViewLinear.setHasFixedSize(true)
        showRecyclerListLinear()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagebutton = binding.tbLinear.ivIcgrid
        val fragmentGrid = FragmentNewsGrid()
        imagebutton.setOnClickListener {
            setCurrentFragment(fragmentGrid)
        }
    }


    private fun getlistNews(): ArrayList<KumpulanData> {
        val dataNama = resources.getStringArray(R.array.data_mobil)
        val dataTangal = resources.getStringArray(R.array.data_tanggal)
        val dataKategori = resources.getStringArray(R.array.data_kategori)
        val dataFoto = resources.obtainTypedArray(R.array.foto_mobil)
        val listMobil = ArrayList<KumpulanData>()
        for (i in dataNama.indices) {
            val student = KumpulanData(
                dataNama[i],
                dataTangal[i],
                dataKategori[i],
                dataFoto.getResourceId(i, -1)
            )
            listMobil.add(student)
        }
        return listMobil
    }

    private fun showRecyclerListLinear() {
        recyclerViewLinear.layoutManager = LinearLayoutManager(context)
        val liststudentadapter = RecyclerAdapter(list)
        recyclerViewLinear.adapter = liststudentadapter
        list.clear()
        list.addAll(getlistNews())
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }
}