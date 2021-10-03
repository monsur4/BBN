package com.mon.bbn.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TypeWriterView(context: Context, attr: AttributeSet) : AppCompatTextView(context, attr) {

    private var myText: CharSequence = ""
    private var myIndex: Int = 0
    private var myDelay: Long = 0

    private val myHandler = Handler(Looper.getMainLooper())

    private val characterAdder = object : Runnable {
        override fun run() {
            text = myText.subSequence(0, myIndex++)
            if (myIndex < myText.length + 1){
                myHandler.postDelayed(this, myDelay)
            }
        }
    }

    fun animateText(charSequence: CharSequence){
        myText = charSequence
        myIndex = 0

        text = ""

        myHandler.removeCallbacks(characterAdder)
        myHandler.postDelayed(characterAdder, myDelay)
    }

    fun setDelay(delay: Long){
        myDelay = delay
    }

}