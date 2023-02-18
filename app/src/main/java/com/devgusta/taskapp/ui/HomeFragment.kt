package com.devgusta.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devgusta.taskapp.R
import com.devgusta.taskapp.databinding.FragmentHomeBinding
import com.devgusta.taskapp.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabLayout()
    }
    private fun initTabLayout(){
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        adapter.addFragment(TodoFragment(),R.string.tab_title_todo)
        adapter.addFragment(DoingFragment(),R.string.tab_title_doing)
        adapter.addFragment(DoneFragment(),R.string.tab_title_done)

        binding.viewPager.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab,position ->
            tab.text = getString(adapter.getTitle(position))

        }.attach()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}