package com.example.handyman.fragments


import ChatAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.handyman.R
import com.example.handyman.databinding.FragmentChatBinding
import com.example.handyman.Models.Chat

/**
 * A simple [Fragment] subclass.
 */
class Chat : Fragment() {

    lateinit var list:ArrayList<Chat>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentChatBinding>(inflater,R.layout.fragment_chat,container,false)
        list = ArrayList()
        list.add(Chat("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzzl5gr-FBxoRVGzZVJXrfeXIPXU4hMfVNqThauFB80FE8MF-G&usqp=CAU","Aliza Smith","Beauty","12:31pm","Yes, How may i help you?"))
        list.add(Chat("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRTBrSeupN5gtIWu4XnVwIyDUhumh5s1pAR02zyQUdnMoygkcD0&usqp=CAU","Emma","Home care","31 min ago","Yes how may i help you"))
        list.add(Chat("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQoapPseWby2w7SBVML4Qhy1Pr2eFAyzXD-Wiu71xF99Inu3x3v&usqp=CAU","Sophia","Art and design", "3 hours ago","Okey done ! Will be there"))

        binding.recyclerViewChat.adapter = ChatAdapter(list)
        return binding.root
    }


}
