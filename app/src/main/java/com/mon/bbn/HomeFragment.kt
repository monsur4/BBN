package com.mon.bbn

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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
import android.view.View.OnLayoutChangeListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected


private val HomeFragment.imageView: ImageView
    get() {
        val imageViewHOH = binding.imageViewHOH
        return imageViewHOH
    }

class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    private lateinit var recyclerViewPresentHousemates:RecyclerView
    private lateinit var recyclerViewAllSeasons:RecyclerView
    private lateinit var recyclerViewPresentHousematesAdapter: PresentHousematesAdapter
    private lateinit var mainViewModel: MainViewModel
    private lateinit var hohAnimation: AnimationDrawable
    private lateinit var imageViewHOH: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        recyclerViewPresentHousemates = binding.recyclerViewPresentHousemates
        val recyclerViewPresentHousematesLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPresentHousemates.layoutManager = recyclerViewPresentHousematesLayoutManager

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val recyclerViewPresentHousematesAdapter = PresentHousematesAdapter(this, DataManager.contestants, mainViewModel, DataManager.images)
        recyclerViewPresentHousemates.adapter = recyclerViewPresentHousematesAdapter

        // add onClickListener to navigate to the winners of HOH fragment
        val cardViewHOH = binding.cardViewHeadOfHouse
        cardViewHOH.setOnClickListener{view -> view.findNavController().navigate(R.id.HOHWinnersFragment)}
        val imageButton =binding.imageButton
        imageButton.setOnClickListener{view -> view.findNavController().navigate(R.id.HOHWinnersFragment)}

        val snapHelperPresentHousemates = MyLinearSnapHelper()
        snapHelperPresentHousemates.attachToRecyclerView(recyclerViewPresentHousemates)

        recyclerViewAllSeasons = binding.recyclerViewAllSeasons
        recyclerViewAllSeasons.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAllSeasons.adapter = AllSeasonsAdapter(requireContext(), DataManager.seasons)

        val snapHelperAllSeasons = PagerSnapHelper()
        snapHelperAllSeasons.attachToRecyclerView(recyclerViewAllSeasons)

        // set up animation for hoh imageView
        imageViewHOH = binding.imageViewHOH
        animateHOHImages()

        prepareTransition()

        //TODO 8b: call postponeEnterTransition on Both Fragments
        postponeEnterTransition()

        exitTransition = TransitionInflater.from(context).inflateTransition(R.transition.home_fragment_exit_transition)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollToPosition()
    }

    private fun prepareTransition() {
        //TODO 3[]: set up exit shared element transition
        setExitSharedElementCallback(object : SharedElementCallback() {
            override fun onMapSharedElements(
                names: MutableList<String>?,
                sharedElements: MutableMap<String, View>?
            ) {
                val selectedViewHolder =
                    recyclerViewPresentHousemates.findViewHolderForAdapterPosition(mainViewModel.getPosition())
                if (selectedViewHolder == null || selectedViewHolder.itemView == null) {
                    return
                }
                // shared element are indexed based on how they were added, so map the first name element
                // to the first view (imageView)
                sharedElements!!.put(names!![0], selectedViewHolder.itemView.findViewById(R.id.imageView))
                sharedElements.put(names[1], selectedViewHolder.itemView.findViewById(R.id.imageButtonFavorite))
            }
        })

        // TODO 3B?: setEnterSharedElementCallBack ? - not sure

    }

    /**
     * Scrolls the recycler view to show the last viewed item in the grid. This is important when
     * navigating back from the grid.
     */
    private fun scrollToPosition() {
        recyclerViewPresentHousemates.addOnLayoutChangeListener(object : OnLayoutChangeListener {
            override fun onLayoutChange(
                v: View,
                left: Int,
                top: Int,
                right: Int,
                bottom: Int,
                oldLeft: Int,
                oldTop: Int,
                oldRight: Int,
                oldBottom: Int
            ) {
                recyclerViewPresentHousemates.removeOnLayoutChangeListener(this)
                val layoutManager: RecyclerView.LayoutManager = recyclerViewPresentHousemates.getLayoutManager()!!
                val viewAtPosition = layoutManager.findViewByPosition(mainViewModel.getPosition())
                // Scroll to position if the view for the current position is null (not currently part of
                // layout manager children), or it's not completely visible.
                if (viewAtPosition == null || layoutManager
                        .isViewPartiallyVisible(viewAtPosition, false, true)
                ) {
                    recyclerViewPresentHousemates.post { layoutManager.scrollToPosition(mainViewModel.getPosition()) }
                }
            }
        })
    }

    // animating hoh images
    public fun animateHOHImages(){
        val hohImages = listOf(R.drawable.erica_hoh, R.drawable.nengi_hoh, R.drawable.ozo_hoh, R.drawable.tacha_hoh)
        // val hohAnimation = AnimationUtils.loadAnimation(context, R.)
        val fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out)
        val fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        var currentImage = 0

        imageViewHOH.setImageResource(R.drawable.ozo_hoh)
        fadeOut.repeatCount = Animation.INFINITE
        fadeOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {

            }

            override fun onAnimationRepeat(p0: Animation?) {
                if (currentImage < hohImages.size){
                    imageViewHOH.setImageResource(hohImages[currentImage++])
                }
                else{
                    currentImage = 0
                    imageViewHOH.setImageResource(hohImages[currentImage++])
                }
                imageViewHOH.startAnimation(fadeIn)

            }

        })
        imageViewHOH.startAnimation(fadeOut
        )

        fadeIn.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                imageViewHOH.startAnimation(fadeOut)
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        item.onNavDestinationSelected(findNavController())
        return true
    }
}