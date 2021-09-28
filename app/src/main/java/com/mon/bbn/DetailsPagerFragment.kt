package com.mon.bbn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.app.SharedElementCallback
import androidx.core.view.doOnPreDraw
import androidx.core.view.get
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.transition.Transition
import androidx.transition.TransitionInflater
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

        viewPager = binding.viewPager

        detailsFragmentViewPagerAdapter = DetailsFragmentViewPagerAdapter(this, DataManager.contestants, mainViewModel)
        viewPager.adapter = detailsFragmentViewPagerAdapter

        //TODO 5: inflate the transitionSet XML into code
        val transition: Transition = TransitionInflater.from(context).inflateTransition(R.transition.image_tranisition)

        //TODO 6: set the transition into the shared element transition
        sharedElementEnterTransition = transition

        //TODO 7: set the enter Shared Element Callback, and attach the view to the appropriate name
        setEnterSharedElementCallback(object : SharedElementCallback(){
            override fun onMapSharedElements(
                names: MutableList<String>?,
                sharedElements: MutableMap<String, View>?
            ) {
//                viewPager.currentItem
//                viewPager.get(mainViewModel.getPosition())
                val view = viewPager.get(viewPager.currentItem)

                val name = names!!.get(0)
                if(view == null){
                    return
                }
                //map the shared element to that view position
                sharedElements!!.put(name, view.findViewById(R.id.imageViewDetail))
            }
        })

        //TODO 8a: call postponeEnterTransition on Both Fragments
        postponeEnterTransition()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    override fun onResume() {
        super.onResume()
        //viewPager.doOnPreDraw { viewPager.currentItem = mainViewModel.getPosition()}
        viewPager.currentItem = mainViewModel.getPosition()

//        val view = viewPager.get(viewPager.currentItem) I used view instead of viewpager earlier
        //TODO 9: call startPostponedEnterTransition after view has been drawn
        viewPager.getViewTreeObserver().addOnPreDrawListener { viewPager.viewTreeObserver.removeOnPreDrawListener { true }
            startPostponedEnterTransition()
            true
        }
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.setPosition(viewPager.currentItem)
    }

}