package com.mon.bbn.data;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MyLinearSnapHelper extends LinearSnapHelper {
    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        LinearLayoutManager linearLayoutManager;
        // snapping of this method is by the item in the centre by default
        // therefore stop the snapping if we are at the first or last item
        if(layoutManager instanceof LinearLayoutManager){
            linearLayoutManager = (LinearLayoutManager) layoutManager;
            if(linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 ||
                    linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount()-1){
                return null;
            }
        }
            return super.findSnapView(layoutManager);
    }
}
