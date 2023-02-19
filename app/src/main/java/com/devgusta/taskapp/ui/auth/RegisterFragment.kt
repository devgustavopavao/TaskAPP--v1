package com.devgusta.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devgusta.taskapp.R
import com.devgusta.taskapp.databinding.FragmentRegisterBinding
import com.devgusta.taskapp.util.createBottomSheet
import com.devgusta.taskapp.util.initToolbar


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        checkCadastro()
    }
    private fun checkCadastro(){
        binding.btnCadastro.setOnClickListener {
            val mail = binding.editEmailCadastro.text.toString().trim()
            val senha = binding.editSenhaCadastro.text.toString().trim()

            if(mail.isNotEmpty()) {
                if(senha.isNotEmpty()) {
                    Toast.makeText(requireContext(), "Tudo ok", Toast.LENGTH_SHORT).show()
                }else{
                    createBottomSheet(msg = getString(R.string.senha_empty))
                }
            }else{
                createBottomSheet(msg = getString(R.string.email_empty))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}