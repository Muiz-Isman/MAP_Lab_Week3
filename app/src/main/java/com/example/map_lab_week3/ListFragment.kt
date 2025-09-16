package com.example.map_lab_week3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.cappuccino),
            view.findViewById(R.id.espresso)
        )

        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                val fragmentBundle = Bundle().apply {
                    // Mengirim ID dari view yang di-klik sebagai argumen
                    putInt(DetailFragment.COFFEE_ID, coffee.id)
                }
                // Menjalankan aksi navigasi ke DetailFragment
                it.findNavController().navigate(
                    R.id.coffee_id_action,
                    fragmentBundle
                )
            }
        }
    }
}