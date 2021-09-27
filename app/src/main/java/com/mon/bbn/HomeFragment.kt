package com.mon.bbn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.mon.bbn.data.AllSeasonsAdapter
import com.mon.bbn.data.DataManager
import com.mon.bbn.data.PresentHousematesAdapter
import com.mon.bbn.databinding.FragmentHomeBinding
import com.mon.bbn.vm.MainViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    private lateinit var recyclerViewPresentHousemates:RecyclerView
    private lateinit var recyclerViewAllSeasons:RecyclerView
    private lateinit var recyclerViewPresentHousematesAdapter: PresentHousematesAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

//        val textViewSectionSeason: TextView = binding.textViewSectionSeason
//        textViewSectionSeason.setOnClickListener(View.OnClickListener{view -> view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)})

        recyclerViewPresentHousemates = binding.recyclerViewPresentHousemates
        val recyclerViewPresentHousematesLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPresentHousemates.layoutManager = recyclerViewPresentHousematesLayoutManager

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val recyclerViewPresentHousematesAdapter = PresentHousematesAdapter(requireContext(), DataManager.contestants, mainViewModel)
        recyclerViewPresentHousemates.adapter = recyclerViewPresentHousematesAdapter

        val snapHelperPresentHousemates = PagerSnapHelper()
        snapHelperPresentHousemates.attachToRecyclerView(recyclerViewPresentHousemates)

        recyclerViewAllSeasons = binding.recyclerViewAllSeasons
        recyclerViewAllSeasons.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAllSeasons.adapter = AllSeasonsAdapter(requireContext(), DataManager.seasons)

        val snapHelperAllSeasons = LinearSnapHelper()
        snapHelperAllSeasons.attachToRecyclerView(recyclerViewAllSeasons)


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        recyclerViewPresentHousemates.scrollToPosition(mainViewModel.getPosition())
    }

}