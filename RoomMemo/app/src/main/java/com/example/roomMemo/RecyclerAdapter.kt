package com.example.roomMemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>() {
//    var helper: SqliteHelper? = null
    var helper: RoomDB? = null
    var listData = mutableListOf<RoomMemo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData[position]
        holder.setMemo(memo)
    }

    inner class Holder(itemview: View) : RecyclerView.ViewHolder(itemview){

        var mMemo: RoomMemo? = null
        val textTitle = itemView.findViewById<TextView>(R.id.textTitle)
        val textContent = itemview.findViewById<TextView>(R.id.textContent)
        val textDatetime = itemview.findViewById<TextView>(R.id.textDatetime)

        init{
            val buttonDelete = itemview.findViewById<Button>(R.id.buttonDelete)

            buttonDelete.setOnClickListener {
//                helper?.deleteMemo(mMemo!!) // DB 에서 삭제
                helper?.roomMemoDao()?.delete(mMemo!!)
                listData.remove(mMemo) // listData 에서 삭제
                notifyDataSetChanged() // 어뎁터 갱신
            }
        }

        fun setMemo(memo: RoomMemo){
            textTitle.text = memo.title
            textContent.text = memo.content
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
            textDatetime.text = "${(sdf.format(memo.datetime))}"

            this.mMemo = memo

            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"클릭된 아이템 = ${textTitle.text.toString()}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

