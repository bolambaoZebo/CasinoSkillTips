package com.ninetysixgroup.casinopokertis

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ninetysixgroup.casinopokertis.model.PokerModel
import kotlinx.android.synthetic.main.activity_content.*

class MainActivity : AppCompatActivity(), RecyclerPoker.onItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home_recycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        home_recycler.adapter = RecyclerPoker(this,getAllRacing(), this)

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
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
    }
}