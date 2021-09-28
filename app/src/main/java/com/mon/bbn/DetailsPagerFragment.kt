package com.mon.bbn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.mon.bbn.adapter.DetailsFragmentViewPagerAdapter
import com.mon.bbn.data.DataManager
import com.mon.bbn.databinding.FragmentDetailsBinding
import com.mon.bbn.vm.MainViewModel
import kotlin.properties.Delegates

class DetailsPagerFragment : Fragment() {
    lateinit var binding: FragmentDetailsBinding
    lateinit var viewPager: ViewPager2
    lateinit var detailsFragmentViewPagerAdapter: DetailsFragmentViewPagerAdapter
    var position = 0
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager = binding.viewPager

//        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
//        mainViewModel.getPosition().observe(viewLifecycleOwner, Observer<Int> {
//                position -> viewPager.doOnPreDraw { viewPager.currentItem = position }
//        })


        detailsFragmentViewPagerAdapter = DetailsFragmentViewPagerAdapter(this, DataManager.contestants, mainViewModel)
        viewPager.adapter = detailsFragmentViewPagerAdapter



        /*// Get adapter position of recyclerView and scroll to corresponding viewPager item
        val arguments: Bundle? = arguments
        val bundle = DetailsFragmentArgs.fromBundle(arguments!!)
        position = bundle.adapterPosition*/

    }

    override fun onResume() {
        super.onResume()
        viewPager.doOnPreDraw { viewPager.currentItem = mainViewModel.getPosition()}
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.setPosition(viewPager.currentItem)
    }
}