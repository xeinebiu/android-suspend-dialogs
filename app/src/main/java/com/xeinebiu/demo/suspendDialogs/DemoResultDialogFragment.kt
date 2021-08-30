package com.xeinebiu.demo.suspendDialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.xeinebiu.demo.suspendDialogs.databinding.DialogFragmentDemoCustomResultBinding
import com.xeinebiu.suspend.dialogs.SuspendDialogResult

class DemoResultDialogFragment : DialogFragment(), SuspendDialogResult<String> {

    override var result: String? = null

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
    ): View = DialogFragmentDemoCustomResultBinding.inflate(
        inflater,
        container,
        false
    ).init().root

    private fun DialogFragmentDemoCustomResultBinding.init() = apply {
        btnClose.setOnClickListener {
            result = etText.text.toString()

            dismiss()
        }
    }
}
