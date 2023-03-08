package com.furkasm.mydiaryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.furkasm.mydiaryapp.R
import com.furkasm.mydiaryapp.databinding.ActivityMainAppPageBinding
import com.furkasm.mydiaryapp.fragments.HomeFragment
import com.furkasm.mydiaryapp.fragments.HomeFragmentDirections
import com.furkasm.mydiaryapp.fragments.ProfileFragment
import com.furkasm.mydiaryapp.fragments.SearchAreaFragment

class MainAppPage : AppCompatActivity() {
    private lateinit var binding : ActivityMainAppPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainAppPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fragmentBeginner(HomeFragment())





        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_icon -> fragmentBeginner(HomeFragment())
                R.id.searching_icon -> fragmentBeginner(SearchAreaFragment())
                R.id.profile_icon -> fragmentBeginner(ProfileFragment())
            }
            true
        }

    }



    fun fragmentBeginner (fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


    }


}