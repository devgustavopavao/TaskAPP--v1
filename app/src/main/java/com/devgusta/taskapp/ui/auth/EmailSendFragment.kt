package com.devgusta.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devgusta.taskapp.R
import com.devgusta.taskapp.databinding.FragmentEmailSendBinding
import com.devgusta.taskapp.util.createBottomSheet
import com.devgusta.taskapp.util.initToolbar


class EmailSendFragment : Fragment() {
   private var _binding: FragmentEmailSendBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailSendBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        checkEmailSend()
    }

    private fun checkEmailSend(){

        binding.btnLogin.setOnClickListener {
            val email = binding.editSendEmail.text.toString().trim()
            if(email.isNotEmpty()){
                Toast.makeText(requireContext(), "Tudo ok", Toast.LENGTH_SHORT).show()
            }else{
                createBottomSheet(msg = getString(R.string.email_empty))
            } }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}