package com.mon.bbn.adapter

import android.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mon.bbn.DetailsObjectFragment
import com.mon.bbn.entity.Contestant
import com.mon.bbn.vm.MainViewModel

class DetailsFragmentViewPagerAdapter(fragment: Fragment, contestants:ArrayList<Contestant>,
                                      mainViewModel: MainViewModel, imageResources:HashMap<String,Int>)
    : FragmentStateAdapter(fragment){ // behaviour, resume only current fragment
    private val contestants = contestants
    private val mainViewModel = mainViewModel
    private val imageResources = imageResources

    override fun getItemCount(): Int {
        return contestants.size
    }

    override fun createFragment(position: Int): Fragment {
        val contestant = contestants[position]
        val imageResString: String= imageResources.get(contestants[position].tag).toString()
        val fragment = DetailsObjectFragment.createInstance(contestant,imageResString)
        return fragment
    }


}