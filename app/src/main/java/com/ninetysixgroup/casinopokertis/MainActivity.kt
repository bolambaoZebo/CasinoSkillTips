package com.ninetysixgroup.casinopokertis

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.ninetysixgroup.casinopokertis.model.PokerModel
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs

class MainActivity : AppCompatActivity(), RecyclerPoker.onItemClicked {

    private var shortAnimationDuration: Int = 0
    private lateinit var bottomModalFragment: BottomModalFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        home_recycler.adapter = RecyclerPoker(this,getAllRacing(), this)

        header_title_withanimation.visibility = View.GONE

        app_bar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener{ appBarLayout, verticalOffset ->
                if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                    header_title_withanimation.apply {
                        visibility = View.VISIBLE

                        animate()
                            .alpha(1f)
                            .setDuration(shortAnimationDuration.toLong())
                            .setListener(null)

                    }

                } else if (abs(verticalOffset) == 0) {
                    header_title_withanimation.apply {
                        alpha = 0f
                        visibility = View.GONE

                        animate()
                            .alpha(1f)
                            .setDuration(shortAnimationDuration.toLong())
                            .setListener(null)
                    }
                } else {
                    // Idle
                }
          }
        )
// LISTENER FOR NESTED SCROLLING

//        nested_view.setOnScrollChangeListener(
//            NestedScrollView.OnScrollChangeListener {
//                    _, scrollX, scrollY, _, oldScrollY ->

//                if(scrollY > 1){
////                    header_title_withanimation.isVisible = true
////                    header_title_withanimation.visibility = View.VISIBLE
//
//                    header_title_withanimation.apply {
//                        alpha = 0f
//                        visibility = View.VISIBLE
//
//                        animate()
//                            .alpha(1f)
//                            .setDuration(shortAnimationDuration.toLong())
//                            .setListener(null)
//
//                    }
//
//                } else if(scrollY == 0){
//                    header_title_withanimation.visibility = View.GONE
//                }
//            })

    }

    private fun getAllRacing(): ArrayList<PokerModel> {
        val homeimages = resources.obtainTypedArray(R.array.array_image)
        val contentImage = resources.obtainTypedArray(R.array.array_image)
        val content = resources.getStringArray(R.array.array_content)
        val contentDetails = resources.getStringArray(R.array.array_details)
        val list = ArrayList<PokerModel>()


        for (i in 0 until homeimages.length()){
            list.add(
                PokerModel(this,content[i],contentDetails[i],homeimages.getResourceId(i, -1))
            )
        }

        return list
    }

    override fun onClicked(context: Context, content: String, image: Int, imageDetail: Int) {

    }

    override fun onClickedTips(content: String) {
        bottomModalFragment = BottomModalFragment()
//        bottomModalFragment.updateValues("content")
        val bundle = Bundle()
        bundle.putString("content", content);
        bottomModalFragment.arguments = bundle;
        bottomModalFragment.show(supportFragmentManager, "BottomSheetDialog")

    }


}