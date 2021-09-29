package com.mon.bbn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.mon.bbn.adapter.AllSeasonsAdapter
import com.mon.bbn.adapter.PresentHousematesAdapter
import com.mon.bbn.data.DataManager
import com.mon.bbn.data.MyLinearSnapHelper
import com.mon.bbn.databinding.FragmentHomeBinding
import com.mon.bbn.vm.MainViewModel

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        recyclerViewPresentHousemates = binding.recyclerViewPresentHousemates
        val recyclerViewPresentHousematesLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPresentHousemates.layoutManager = recyclerViewPresentHousematesLayoutManager

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val recyclerViewPresentHousematesAdapter = PresentHousematesAdapter(requireContext(), DataManager.contestants, mainViewModel, DataManager.images)
        recyclerViewPresentHousemates.adapter = recyclerViewPresentHousematesAdapter

        val snapHelperPresentHousemates = MyLinearSnapHelper()
        snapHelperPresentHousemates.attachToRecyclerView(recyclerViewPresentHousemates)

        recyclerViewAllSeasons = binding.recyclerViewAllSeasons
        recyclerViewAllSeasons.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAllSeasons.adapter = AllSeasonsAdapter(requireContext(), DataManager.seasons)

        val snapHelperAllSeasons = PagerSnapHelper()
        snapHelperAllSeasons.attachToRecyclerView(recyclerViewAllSeasons)

        //TODO 3[]: set up exit shared element transition
        setExitSharedElementCallback(object: SharedElementCallback(){
            override fun onMapSharedElements(
                names: MutableList<String>?,
                sharedElements: MutableMap<String, View>?
            ) {
                val name = names!!.get(0)
                val selectedViewHolder =
                    recyclerViewPresentHousemates.findViewHolderForAdapterPosition(mainViewModel.getPosition())
                if(selectedViewHolder == null || selectedViewHolder.itemView ==null){
                    return
                }
                // shared element are indexed based on how they were added, so map the first name element
                // to the first view (imageView)
                sharedElements!!.put(name, selectedViewHolder.itemView.findViewById(R.id.imageView))
            }
        })
        // TODO 3B?: setEnterSharedElementCallBack ? - not sure

        //TODO 8b: call postponeEnterTransition on Both Fragments
//        postponeEnterTransition()

//        exitTransition = TransitionInflater.from(context).inflateTransition(R.transition.home_fragment_exit_transition)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        recyclerViewPresentHousemates.scrollToPosition(mainViewModel.getPosition())

    }

}