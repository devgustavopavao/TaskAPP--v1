package com.devgusta.taskapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devgusta.taskapp.R
import com.devgusta.taskapp.databinding.FragmentFormTaskBinding
import com.devgusta.taskapp.util.createBottomSheet
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
    @SuppressLint("SuspiciousIndentation")
    private fun checkCampos(){
        binding.btnSalvar.setOnClickListener {
            val tarefa = binding.editDesc.text.toString().trim()
                if(tarefa.isNotEmpty()){
                    Toast.makeText(requireContext(), "Tudo ok", Toast.LENGTH_SHORT).show()
                }else{
                    createBottomSheet(msg = getString( R.string.tarefa_empty))
                }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}