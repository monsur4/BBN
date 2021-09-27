package com.mon.bbn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.mon.bbn.data.DataManager
import com.mon.bbn.data.DetailsFragmentViewPagerAdapter
import com.mon.bbn.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    lateinit var binding: FragmentDetailsBinding
    lateinit var viewPager: ViewPager2
    lateinit var detailsFragmentViewPagerAdapter: DetailsFragmentViewPagerAdapter

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
        detailsFragmentViewPagerAdapter = DetailsFragmentViewPagerAdapter(this, DataManager.contestants)
        viewPager.adapter = detailsFragmentViewPagerAdapter

        // Get adapter position of recyclerView and scroll to corresponding viewPager item
        val arguments: Bundle? = arguments
        val bundle = DetailsFragmentArgs.fromBundle(arguments!!)
        val position = bundle.adapterPosition

        viewPager.currentItem = position
//        viewPager.setCurrentItem(position, false)

    }
}