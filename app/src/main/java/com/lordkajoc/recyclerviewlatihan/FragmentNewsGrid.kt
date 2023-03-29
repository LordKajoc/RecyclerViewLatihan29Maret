package com.lordkajoc.recyclerviewlatihan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerviewlatihan.databinding.FragmentNewsGridBinding

class FragmentNewsGrid : Fragment() {
    val list = ArrayList<KumpulanData>()
    lateinit var binding: FragmentNewsGridBinding
    lateinit var recyclerviewnewsgrid: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsGridBinding.inflate(layoutInflater, container, false)
        recyclerviewnewsgrid = binding.recyclerviewgrid
        recyclerviewnewsgrid.setHasFixedSize(true)
        showRecyclerListGrid()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagebutton = binding.tbGrid.ivIclist
        val fragmentlinear = FragmentNewsLinear()
        imagebutton.setOnClickListener {
            setCurrentFragment(fragmentlinear)
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

    private fun showRecyclerListGrid() {
        val viewGridLayout = GridLayoutManager(context, 2)
        recyclerviewnewsgrid.layoutManager = viewGridLayout
        val listRecyclerAdapter = RecyclerAdapter(list)
        recyclerviewnewsgrid.adapter = listRecyclerAdapter
        list.clear()
        list.addAll(getlistNews())
    }

    private fun setCurrentFragment(fragment: Fragment): FragmentTransaction =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fr_container, fragment)
            commit()
        }


}