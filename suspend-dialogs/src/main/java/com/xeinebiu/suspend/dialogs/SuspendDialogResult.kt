package com.xeinebiu.suspend.dialogs

import androidx.fragment.app.DialogFragment

/**
 * Provides [SuspendDialogResult.result] member to return from the [DialogFragment]
 */
interface SuspendDialogResult<T> {
    var result: T?
}
