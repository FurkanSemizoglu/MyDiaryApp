package com.furkasm.mydiaryapp.fragments

import android.icu.lang.UCharacter.VerticalOrientation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.furkasm.mydiaryapp.R
import com.furkasm.mydiaryapp.adapter.AdapterRecyclerView
import com.furkasm.mydiaryapp.adapter.StorySaver
import com.furkasm.mydiaryapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment




        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    private lateinit var storyList : List<StorySaver>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.inflate(layoutInflater)


        val userList = ArrayList<StorySaver>()


        userList.add(StorySaver("furkan","hiiiiiiiiii"))


        val recyclerView = binding.homeRecyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity ,LinearLayoutManager.VERTICAL,false)

        val adapter =  AdapterRecyclerView(userList)

        recyclerView.adapter = adapter

    }
}