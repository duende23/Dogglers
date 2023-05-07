package com.villadevs.dogglers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.villadevs.dogglers.adapter.DogAdapter
import com.villadevs.dogglers.const.Layout
import com.villadevs.dogglers.data.DataSource
import com.villadevs.dogglers.databinding.FragmentDogBinding
import com.villadevs.dogglers.databinding.FragmentLayoutBinding
import com.villadevs.dogglers.viewmodel.DogViewModel


private const val ARG_PARAM1 = "param1"



class DogFragment : Fragment() {

    private val sharedViewModel: DogViewModel by activityViewModels()

    private var _binding: FragmentDogBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentDogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dogList = DataSource().loadDogs()



        sharedViewModel.buttonState.observe(viewLifecycleOwner){ buttonState ->
            when(buttonState){
                Layout.VERTICAL -> {
                    binding.rvRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                }

                Layout.HORIZONTAL -> {
                    binding.rvRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                }

                Layout.GRID -> {
                    binding.rvRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
                }
            }
        }

        binding.rvRecyclerView.adapter = DogAdapter(requireContext(), dogList)
        binding.rvRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}