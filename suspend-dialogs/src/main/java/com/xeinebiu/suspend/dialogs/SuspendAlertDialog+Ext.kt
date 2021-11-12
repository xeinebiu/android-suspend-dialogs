package com.xeinebiu.suspend.dialogs

import android.app.Activity
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.MenuRes
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
 * Display an [AlertDialog] with [menuRes] as CTA
 *
 * Dialog is dismiss when an item from [menuRes] is clicked
 *
 * Return the selected [MenuItem]
 */
suspend inline fun AlertDialog.Builder.setItems(
    activity: Activity,
    @MenuRes menuRes: Int,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
) = SuspendAlertDialog.setItems(
    activity = activity,
    menuRes = menuRes,
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText
) { this }

/**
 * Display an [AlertDialog] with [menu] as CTA
 *
 * Dialog is dismiss when an item from [menu] is clicked
 *
 * Return the selected [MenuItem]
 */
suspend inline fun AlertDialog.Builder.setItems(
    menu: Menu,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
) = SuspendAlertDialog.setItems(
    menu = menu,
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText
) { this }

/**
 * Display an [AlertDialog] with [items] as CTA
 *
 * Dialog is dismiss when an item from [items] is clicked
 *
 * Return the selected index from [items]
 */
suspend fun AlertDialog.Builder.setItems(
    items: List<String>,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
) = SuspendAlertDialog.setItems(
    items = items,
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText
) { this }

/**
 * Set a list of items from given [menuRes] to be displayed in the dialog as the content.
 *
 * The list will have a check mark displayed to
 * the right of the text for the checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 */
suspend inline fun AlertDialog.Builder.setSingleChoiceItems(
    activity: Activity,
    @MenuRes menuRes: Int,
    selectedIndex: Int = -1,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
): SuspendAlertDialog.SingleChoiceMenuResult = SuspendAlertDialog.setSingleChoiceItems(
    activity = activity,
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText,
    menuRes = menuRes,
    selectedIndex = selectedIndex
) { this }

/**
 * Set a list of items from given [Menu] to be displayed in the dialog as the content.
 *
 * The list will have a check mark displayed to
 * the right of the text for the checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 */
suspend inline fun AlertDialog.Builder.setSingleChoiceItems(
    menu: Menu,
    selectedIndex: Int = -1,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
): SuspendAlertDialog.SingleChoiceMenuResult = SuspendAlertDialog.setSingleChoiceItems(
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText,
    menu = menu,
    selectedIndex = selectedIndex
) { this }

/**
 * Set a list of items to be displayed in the dialog as the content.
 *
 * The list will have a check mark displayed to
 * the right of the text for the checked item. Clicking on an item in the list will not
 * dismiss the dialog. Clicking on a button will dismiss the dialog.
 */
suspend inline fun AlertDialog.Builder.setSingleChoiceItems(
    items: SuspendAlertDialog.SingleChoiceItems,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
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
    items: SuspendAlertDialog.MultiChoiceItems,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    neutralButtonText: CharSequence? = null,
) = SuspendAlertDialog.setMultiChoiceItems(
    positiveButtonText = positiveButtonText,
    negativeButtonText = negativeButtonText,
    neutralButtonText = neutralButtonText,
    items = items
) {
    this
}
