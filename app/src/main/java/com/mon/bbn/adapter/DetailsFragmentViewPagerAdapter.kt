package com.mon.bbn.adapter

import android.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mon.bbn.DetailsObjectFragment
import com.mon.bbn.entity.Contestant
import com.mon.bbn.vm.MainViewModel

class DetailsFragmentViewPagerAdapter(fragment: Fragment, contestants:ArrayList<Contestant>, mainViewModel: MainViewModel)
    : FragmentStateAdapter(fragment){
    private val contestants = contestants
    private val mainViewModel = mainViewModel
    override fun getItemCount(): Int {
        return contestants.size
    }

    override fun createFragment(position: Int): Fragment {
        val contestant = contestants[position]
        val fragment = DetailsObjectFragment(contestant)
        return fragment
    }

}