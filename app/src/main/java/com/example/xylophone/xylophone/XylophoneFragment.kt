package com.example.xylophone.xylophone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.xylophone.R
import com.example.xylophone.databinding.FragmentXylophoneBinding

class XylophoneFragment: Fragment() {

    private lateinit var viewModel: XylophoneViewModel
    private lateinit var viewModelFactory: XylophoneViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentXylophoneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_xylophone, container, false)
        binding.lifecycleOwner = this
        viewModelFactory = XylophoneViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(XylophoneViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }
}