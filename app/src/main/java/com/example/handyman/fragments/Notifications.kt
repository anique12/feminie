package com.example.handyman.fragments


import NotificationAdapter
import android.app.NotificationChannel
import android.content.res.Resources
import android.graphics.ColorSpace
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import com.example.handyman.Models.Notification
import com.example.handyman.R
import com.example.handyman.databinding.FragmentNotificationsBinding
import kotlinx.android.synthetic.main.fragment_notifications.*

/**
 * A simple [Fragment] subclass.
 */
class Notifications : Fragment() {

    lateinit var list : ArrayList<Notification>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentNotificationsBinding>(inflater,
            R.layout.fragment_notifications,container,false)
             list = ArrayList()
            list.add(Notification("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzzl5gr-FBxoRVGzZVJXrfeXIPXU4hMfVNqThauFB80FE8MF-G&usqp=CAU","12:31pm","Found a beautician you may search for."))
            list.add(Notification("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRTBrSeupN5gtIWu4XnVwIyDUhumh5s1pAR02zyQUdnMoygkcD0&usqp=CAU","31 min ago","Your request to Mr.Poul for content writing is rejected"))
            list.add(Notification("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQoapPseWby2w7SBVML4Qhy1Pr2eFAyzXD-Wiu71xF99Inu3x3v&usqp=CAU","3 hour ago","Your request to Mr.Johnson for Art and design..."))

            binding.recyclerViewNotification.adapter = NotificationAdapter(list)
        return binding.root
    }


}
