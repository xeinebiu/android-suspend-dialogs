package com.xeinebiu.demo.suspendDialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.xeinebiu.demo.suspendDialogs.databinding.DialogFragmentDemoBinding

class DemoDialogFragment : DialogFragment() {

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DialogFragmentDemoBinding.inflate(
        inflater,
        container,
        false
    ).also {
        it.btnClose.setOnClickListener { dismiss() }
    }.root
}
