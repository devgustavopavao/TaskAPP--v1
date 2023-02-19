package com.devgusta.taskapp.util

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.devgusta.taskapp.R
import com.devgusta.taskapp.databinding.BottomDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.initToolbar(toolbar: Toolbar){
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener { activity?.onBackPressed() }
}

fun Fragment.createBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    msg: String,
    onClick: () -> Unit = {}
){
    val bottomSheet = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog )
    val bottomBinding: BottomDialogBinding =
        BottomDialogBinding.inflate(layoutInflater,null,false)

   bottomBinding.txtTitle.text = getText(titleDialog ?: R.string.text_aviso)
    bottomBinding.textError.text = msg
    bottomBinding.btnEntendi.text = getText(titleButton ?: R.string.text_btn)
    bottomBinding.btnEntendi.setOnClickListener {
        onClick()
        bottomSheet.dismiss()
    }
        bottomSheet.setContentView(bottomBinding.root)
        bottomSheet.show()
}