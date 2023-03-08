package com.furkasm.mydiaryapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.furkasm.mydiaryapp.databinding.FragmentSearchAreaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SearchAreaFragment : Fragment() {

    private lateinit var auth : FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var SearchAreaFragmentBinding : FragmentSearchAreaBinding? = null
    private val binding get() = SearchAreaFragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        SearchAreaFragmentBinding = FragmentSearchAreaBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        firestore = Firebase.firestore
        val db = firestore


        val user = hashMapOf<String,Any>()

        val fragmentTransaction = parentFragmentManager.beginTransaction()

        binding.storySaveButton.setOnClickListener{

            val userStory = binding.searchAreaStoryTextView.text.toString()
            user.put("userEmail",auth.currentUser!!.email.toString())
            user.put("userStory",userStory)


            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(getActivity(),"Saved!",Toast.LENGTH_SHORT).show()

                    // find a way to replace fragment


                }.addOnFailureListener {
                    Toast.makeText(getActivity(),it.localizedMessage.toString(),Toast.LENGTH_SHORT).show()

                }


        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        SearchAreaFragmentBinding = null
    }

}