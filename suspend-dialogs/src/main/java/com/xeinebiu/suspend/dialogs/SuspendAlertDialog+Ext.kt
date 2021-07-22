package com.xeinebiu.suspend.dialogs

import androidx.appcompat.app.AlertDialog


/**
 * Show a dialog from [AlertDialog.Builder] with a title and message
 *
 * Clicking on a button will dismiss the dialog.
 */
suspend inline fun AlertDialog.Builder.alert(
    buttonText: String = "Ok"
) = SuspendAlertDialog.alert(buttonText) {
    this
}

/**
 * Show a dialog from [AlertDialog.Builder] with a title and message
 *
 * Clicking on a button will dismiss the dialog.
 */
suspend inline fun AlertDialog.Builder.confirm(
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null
) = SuspendAlertDialog.confirm(
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText
) {
    this
}

/**
 * Set a list of items to be displayed in the dialog as the content.
 *
 * The list will have a check mark displayed to
 * the right of the text for the checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 */
suspend inline fun AlertDialog.Builder.setSingleChoiceItems(
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
    items: SuspendAlertDialog.SingleChoiceItems
) = SuspendAlertDialog.setSingleChoiceItems(
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText,
    items = items
) { this }

/**
 * Set a list of items to be displayed in the dialog as the content.
 * The list will have a check mark displayed to the right of the text
 * for each checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 */
suspend inline fun AlertDialog.Builder.setMultiChoiceItems(
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
    items: SuspendAlertDialog.MultiChoiceItems
) = SuspendAlertDialog.setMultiChoiceItems(
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText,
    items = items
) {
    this
}
