package com.ninetysixgroup.casinopokertis


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ninetysixgroup.casinopokertis.model.PokerModel
import kotlinx.android.synthetic.main.home_cardview.view.*

class RecyclerPoker (context: Context, list: ArrayList<PokerModel>, private val listener: onItemClicked):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    private val context: Context = context
    var list: ArrayList<PokerModel> = list

    inner class PokerVH(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.home_cardview_image
        var text = view.home_text
        var cardView = view.card_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PokerVH(
            LayoutInflater.from(context).inflate(R.layout.home_cardview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val pokerItem = list.get(position)

        if(holder is PokerVH){
            holder.image.setImageResource(pokerItem.pokerImage)
            holder.text.text = pokerItem.pokerTitle
            holder.cardView.setOnClickListener{
//                listener.onClicked(context, item.foodName, item.imageDetail, item.foodDetails)
                listener.onClickedTips(pokerItem.pokerContent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface onItemClicked {
        fun onClicked(context: Context, content: String, image: Int, imageDetail: Int)
        fun onClickedTips(content: String)
    }
}

