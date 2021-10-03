package com.mon.bbn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.activityViewModels
import androidx.transition.Transition
import androidx.transition.TransitionInflater
import androidx.viewpager2.widget.ViewPager2
import com.mon.bbn.adapter.DetailsFragmentViewPagerAdapter
import com.mon.bbn.data.DataManager
import com.mon.bbn.databinding.FragmentDetailsBinding
import com.mon.bbn.vm.MainViewModel

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

        detailsFragmentViewPagerAdapter = DetailsFragmentViewPagerAdapter(
            this,
            DataManager.contestants,
            mainViewModel,
            DataManager.images
        )
        viewPager.adapter = detailsFragmentViewPagerAdapter

        prepareTransition()
        return binding.root
    }

    // all code for setting up transitioning
    private fun prepareTransition() {
        //TODO 5: inflate the transitionSet XML into code
        val transition: Transition =
            TransitionInflater.from(context).inflateTransition(R.transition.image_tranisition)

        //TODO 6: set the transition into the shared element transition
        sharedElementEnterTransition = transition

        //TODO 7: set the enter Shared Element Callback, and attach the view to the appropriate name
        setEnterSharedElementCallback(object : SharedElementCallback() {
            override fun onMapSharedElements(
                names: MutableList<String>?,
                sharedElements: MutableMap<String, View>?
            ) {

                val currentFragment = childFragmentManager.findFragmentByTag(
                    "f${
                        (viewPager.adapter as DetailsFragmentViewPagerAdapter).getItemId(
                            mainViewModel.getPosition()
                        )
                    }"
                )
                val view = currentFragment?.view ?: return
                //map the shared element to that view position
                sharedElements!!.put(names!![0], view.findViewById(R.id.imageViewDetailProfile))
                sharedElements.put(names[1], view.findViewById(R.id.imageButtonDetailFavorite))
            }
        })

        //        //TODO 8a: call postponeEnterTransition on Both Fragments
        postponeEnterTransition()

        // TODO 9: call startPostponedEnterTransition after view has been drawn
        viewPager.doOnPreDraw {
            viewPager.setCurrentItem(mainViewModel.getPosition(), false)
            startPostponedEnterTransition()
        }

    }

    override fun onStop() {
        super.onStop()
        mainViewModel.setPosition(viewPager.currentItem)
    }

}