package com.mon.bbn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mon.bbn.adapter.HOHWinnersAdapter
import com.mon.bbn.data.DataManager
import com.mon.bbn.databinding.FragmentHOHWinnersBinding

class HOHWinnersFragment : Fragment() {
    lateinit var binding : FragmentHOHWinnersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHOHWinnersBinding.inflate(inflater, container, false)
        val recyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = HOHWinnersAdapter(requireContext(), DataManager.winnersOfHOH)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter =adapter

        // change the title
        activity?.actionBar?.title = "The Head of House"
        return binding.root
    }

}