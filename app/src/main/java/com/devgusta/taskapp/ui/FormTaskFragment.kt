package com.devgusta.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devgusta.taskapp.R
import com.devgusta.taskapp.databinding.FragmentFormTaskBinding
import com.devgusta.taskapp.util.initToolbar


class FormTaskFragment : Fragment() {
    private var _binding:FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        checkCampos()
    }
    private fun checkCampos(){
        binding.btnSalvar.setOnClickListener {
            val tarefa = binding.editDesc.text.toString().trim()
                if(tarefa.isNotEmpty()){
                    Toast.makeText(requireContext(), "Tudo ok", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireContext(), "Digite uma tarefa antes.", Toast.LENGTH_SHORT).show()
                }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}