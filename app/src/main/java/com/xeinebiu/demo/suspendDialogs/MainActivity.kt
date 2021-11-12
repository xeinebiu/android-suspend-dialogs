package com.xeinebiu.demo.suspendDialogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.xeinebiu.demo.suspendDialogs.databinding.ActivityMainBinding
import com.xeinebiu.suspend.dialogs.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        with(binding) {
            confirmDialog()
            confirmDialogExt()

            alertDialog()
            alertDialogExt()

            setItems()
            setItemsExt()

            multiChoiceDialog()
            multiChoiceDialogExt()

            singleChoiceDialog()
            singleChoiceDialogExt()

            fragmentDialog()
            customDialogFragmentWithResult()
        }
    }

    private fun ActivityMainBinding.alertDialog() {
        btnAlert.setOnClickListener {
            lifecycleScope.launch {
                SuspendAlertDialog.alert("Ok") {
                    MaterialAlertDialogBuilder(this@MainActivity).setTitle("Hello")
                }

                tvResult.text = getString(R.string.alert_finished)
            }
        }
    }

    private fun ActivityMainBinding.alertDialogExt() {
        btnAlertExt.setOnClickListener {
            lifecycleScope.launch {
                MaterialAlertDialogBuilder(this@MainActivity)
                    .setTitle("Hello")
                    .alert("Ok")

                tvResult.text = getString(R.string.alert_finished)
            }
        }
    }

    private fun ActivityMainBinding.setItems() {
        btnSetItems.setOnClickListener {
            lifecycleScope.launch {
                val result = SuspendAlertDialog.setItems(
                    items = listOf("Hello", "World"),
                    negativeButtonText = NEGATIVE,
                    neutralButtonText = NEUTRAL,
                ) {
                    MaterialAlertDialogBuilder(this@MainActivity)
                }

                tvResult.text = result.toString()
            }
        }
    }

    private fun ActivityMainBinding.setItemsExt() {
        btnSetItemsExt.setOnClickListener {
            lifecycleScope.launch {
                val result = MaterialAlertDialogBuilder(this@MainActivity)
                    .setItems(
                        items = listOf("Hello", "World"),
                        positiveButtonText = POSITIVE,
                        negativeButtonText = NEGATIVE,
                        neutralButtonText = NEUTRAL,
                    )

                tvResult.text = result.toString()
            }
        }
    }

    private fun ActivityMainBinding.confirmDialog() {
        btnConfirm.setOnClickListener {
            lifecycleScope.launch {
                val result = SuspendAlertDialog.confirm(
                    positiveButtonText = POSITIVE,
                    negativeButtonText = NEGATIVE,
                    neutralButtonText = NEUTRAL,
                ) {
                    MaterialAlertDialogBuilder(this@MainActivity)
                        .setTitle("Title")
                        .setMessage("Message")
                }

                tvResult.text = result.toString()
            }
        }
    }

    private fun ActivityMainBinding.confirmDialogExt() {
        btnConfirmExt.setOnClickListener {
            lifecycleScope.launch {
                val result = MaterialAlertDialogBuilder(this@MainActivity)
                    .setTitle("Title")
                    .setMessage("Message")
                    .confirm(
                        positiveButtonText = POSITIVE,
                        negativeButtonText = NEGATIVE,
                        neutralButtonText = NEUTRAL,
                    )

                tvResult.text = result.toString()
            }
        }
    }

    private fun ActivityMainBinding.multiChoiceDialog() {
        btnMultiChoice.setOnClickListener {
            lifecycleScope.launch {
                val multiChoiceResult = SuspendAlertDialog.setMultiChoiceItems(
                    positiveButtonText = POSITIVE,
                    negativeButtonText = NEGATIVE,
                    neutralButtonText = NEUTRAL,
                    items = SuspendAlertDialog.MultiChoiceItems(
                        items = listOf("Hello", "World", "Berlin", "Germany"),
                        checked = listOf(false, false, false, false)
                    )
                ) {
                    MaterialAlertDialogBuilder(this@MainActivity).setTitle("Title")
                }

                tvResult.text = multiChoiceResult.toString()
            }
        }
    }

    private fun ActivityMainBinding.multiChoiceDialogExt() {
        btnMultiChoiceExt.setOnClickListener {
            lifecycleScope.launch {
                val result = MaterialAlertDialogBuilder(this@MainActivity)
                    .setTitle("Title")
                    .setMultiChoiceItems(
                        positiveButtonText = POSITIVE,
                        negativeButtonText = NEGATIVE,
                        neutralButtonText = NEUTRAL,
                        items = SuspendAlertDialog.MultiChoiceItems(
                            items = listOf("Hello", "World", "Berlin", "Germany"),
                            checked = listOf(false, false, false, false)
                        )
                    )

                tvResult.text = result.toString()
            }
        }
    }

    private fun ActivityMainBinding.singleChoiceDialog() {
        btnSingleChoice.setOnClickListener {
            lifecycleScope.launch {
                val singleChoiceResult = SuspendAlertDialog.setSingleChoiceItems(
                    positiveButtonText = POSITIVE,
                    negativeButtonText = NEGATIVE,
                    neutralButtonText = NEUTRAL,
                    items = SuspendAlertDialog.SingleChoiceItems(
                        items = listOf("Hello", "World", "Berlin", "Germany"),
                        selectedIndex = 1
                    )
                ) {
                    MaterialAlertDialogBuilder(this@MainActivity).setTitle("Title")
                }

                tvResult.text = singleChoiceResult.toString()
            }
        }
    }

    private fun ActivityMainBinding.singleChoiceDialogExt() {
        btnSingleChoiceExt.setOnClickListener {
            lifecycleScope.launch {
                val result = MaterialAlertDialogBuilder(this@MainActivity)
                    .setTitle("Title")
                    .setSingleChoiceItems(
                        positiveButtonText = POSITIVE,
                        negativeButtonText = NEGATIVE,
                        neutralButtonText = NEUTRAL,
                        items = SuspendAlertDialog.SingleChoiceItems(
                            items = listOf("Hello", "World", "Berlin", "Germany"),
                            selectedIndex = 1
                        )
                    )

                tvResult.text = result.toString()
            }
        }
    }

    private fun ActivityMainBinding.fragmentDialog() {
        btnDialogFragment.setOnClickListener {
            lifecycleScope.launch {
                DemoDialogFragment().showAwait(
                    fragmentManager = supportFragmentManager,
                    tag = DemoDialogFragment::class.java.canonicalName
                )
                tvResult.text = "${DemoDialogFragment::class.java.canonicalName} finished"
            }
        }
    }

    private fun ActivityMainBinding.customDialogFragmentWithResult() {
        btnDialogFragmentResult.setOnClickListener {
            lifecycleScope.launch {
                val result = DemoResultDialogFragment().showAwaitResult(
                    fragmentManager = supportFragmentManager,
                    tag = DemoResultDialogFragment::class.java.canonicalName
                )
                tvResult.text = result
            }
        }
    }

    companion object {
        private val POSITIVE = "Positive"
        private val NEGATIVE = "Negative"
        private val NEUTRAL = "Neutral"
    }
}