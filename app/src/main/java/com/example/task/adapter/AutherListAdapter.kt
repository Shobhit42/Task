package com.example.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.models.FirstHits
import com.example.task.models.Hits

class AutherListAdapter : RecyclerView.Adapter<AutherListAdapter.MyViewHolder>() {

    private var authorList : ArrayList<Hits>? = null

    fun setAuthorList(authorList: ArrayList<Hits>?){
        this.authorList = authorList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AutherListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AutherListAdapter.MyViewHolder, position: Int) {
        holder.bind(authorList?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(authorList==null){
            return 0
        }else{
            return authorList?.size!!
        }
    }

    class MyViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val tView = view.findViewById<TextView>(R.id.tView)
        fun bind(data : Hits){
            tView.text = data.toString()
        }
    }

}