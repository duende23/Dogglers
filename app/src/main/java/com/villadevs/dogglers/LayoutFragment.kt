package com.villadevs.dogglers

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.villadevs.dogglers.const.Layout
import com.villadevs.dogglers.databinding.FragmentLayoutBinding
import com.villadevs.dogglers.viewmodel.DogViewModel


private const val ARG_PARAM1 = "param1"


class LayoutFragment : Fragment() {

    private val sharedViewModel: DogViewModel by activityViewModels()

    private var _binding: FragmentLayoutBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btVerticalLayout.setOnClickListener {
            sharedViewModel.clickButtonSelect(Layout.VERTICAL)
            goToDogFragment()
        }

        binding.btHorizontalLayout.setOnClickListener {
            sharedViewModel.clickButtonSelect(Layout.HORIZONTAL)
            goToDogFragment()
        }

        binding.btGridLayout.setOnClickListener {
            sharedViewModel.clickButtonSelect(Layout.GRID)
            goToDogFragment()
        }

    }

    private fun goToDogFragment() {
        findNavController().navigate(R.id.action_layoutFragment_to_dogFragment)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}