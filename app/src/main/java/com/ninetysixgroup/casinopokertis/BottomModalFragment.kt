package com.ninetysixgroup.casinopokertis

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_modal_layout.*
import java.awt.font.TextAttribute

class BottomModalFragment: BottomSheetDialogFragment(), RecyclerPoker.onItemClicked {

    private lateinit var contentDetail : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val name= activity//getArguments().getString("content").toString()//getString("content").toString();


        return inflater.inflate(R.layout.bottom_modal_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onClicked(context: Context, content: String, image: Int, imageDetail: Int) {
    }

    override fun onClickedTips(content: String) {
        bottom_modal_txt.text = content
    }
}