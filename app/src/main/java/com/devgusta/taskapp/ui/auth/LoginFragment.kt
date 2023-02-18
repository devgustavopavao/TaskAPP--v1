package com.devgusta.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.devgusta.taskapp.R
import com.devgusta.taskapp.databinding.FragmentEmailSendBinding
import com.devgusta.taskapp.databinding.FragmentLoginBinding
import com.devgusta.taskapp.databinding.FragmentRegisterBinding


class LoginFragment : Fragment() {
    private var _binding:  FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            onAuths()

    }

    private fun checkLogin() {
        binding.btnLogin.setOnClickListener {
            val mail = binding.editEmailCadastro.text.toString().trim()
            val senha = binding.editSenhaCadastro.text.toString().trim()

            if(mail.isNotEmpty()) {
                if(senha.isNotEmpty()) {
                    findNavController().navigate(R.id.action_global_homeFragment)
                }else{
                    Toast.makeText(requireContext(), "Digite uma senha antes.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireContext(), "Digite um email antes.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onAuths(){
        binding.editCadastrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
        }
        binding.textEsqueceu.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_emailSendFragment22)
        }
        binding.btnLogin.setOnClickListener {
            checkLogin()

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}