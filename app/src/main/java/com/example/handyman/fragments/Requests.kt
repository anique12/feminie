package com.example.handyman.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.handyman.R
import com.example.handyman.databinding.FragmentRequestsBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_requests.*

/**
 * A simple [Fragment] subclass.
 */
class Requests : Fragment() {

    private lateinit var bindingRequest : FragmentRequestsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         bindingRequest = DataBindingUtil.inflate(inflater, R.layout.fragment_requests,container,false)
        return bindingRequest.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingRequest.tabLayoutRequest.addTab(tabLayoutRequest.newTab().setText("Pending"))
        bindingRequest.tabLayoutRequest.addTab(tabLayoutRequest.newTab().setText("Completed"))
        val adapter = RequestPagerAdapter(childFragmentManager,bindingRequest.tabLayoutRequest.tabCount)
        bindingRequest.pagerRequest.adapter = adapter
        bindingRequest.pagerRequest.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(bindingRequest.tabLayoutRequest))
        bindingRequest.tabLayoutRequest.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                bindingRequest.pagerRequest.currentItem = p0!!.position
            }

        })

    }

}
class RequestPagerAdapter(fm: FragmentManager, private var tabCount: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> RequestPending()
            1 -> RequestCompleted()
            else -> null!!
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
