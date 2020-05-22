package com.example.handyman.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.handyman.R
import com.example.handyman.databinding.FragmentAccountBinding
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class Account : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAccountBinding>(inflater,
            R.layout.fragment_account,container,false)
            Picasso.get().load(getString(R.string.person_image)).fit().into(binding.imageViewAccount)
            binding.manageAddressAccount.setOnClickListener {
            findNavController().navigate(R.id.action_account_to_manageAddress)
        }
        return binding.root
    }


}
