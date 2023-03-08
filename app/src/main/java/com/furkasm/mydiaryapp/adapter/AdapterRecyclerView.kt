package com.furkasm.mydiaryapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.furkasm.mydiaryapp.databinding.MainHomeFragmentRowBinding

class AdapterRecyclerView(private val postList: ArrayList<StorySaver>) :RecyclerView.Adapter<AdapterRecyclerView.RowHolder>(){


    class RowHolder(val binding: MainHomeFragmentRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = MainHomeFragmentRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.binding.rowTopTextView.text = postList.get(position).userName
        holder.binding.rowStoryTextView.text = postList.get(position).story
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}