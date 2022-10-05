package com.example.task_6_navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.task_6_navigation.databinding.FragmentBalanceBinding

class BalanceFragment : Fragment() {

    private var _binding: FragmentBalanceBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getString("bundleKey")
                binding.resultTv.text = result

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBalanceBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.openBottomSheetBtn.setOnClickListener {
            showBottomSheet()


        }
    }
    private fun showBottomSheet(){
        val action = BalanceFragmentDirections.actionBalanceFragmentToBottomSheetFragment()
        findNavController().navigate(action)

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}