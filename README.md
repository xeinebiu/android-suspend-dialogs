# Android Suspendable Dialogs

A helper library for Android to display Dialogs by suspending the coroutine till finish of the dialog.

# Installation
```
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```

```
dependencies {
    implementation 'com.github.xeinebiu:android-suspend-dialogs:1.6.2'
}
```
    

# Some Differences with and without suspend

### Confirm

The below example shows how a normal dialog is shown without any suspension

```kotlin
MaterialAlertDialogBuilder(this@MainActivity)
    .setTitle("Title")
    .setMessage("Message")
    .setPositiveButton("Positive") { _, _ ->
        // code to execute
    }
    .setNegativeButton("Negative") { _, _ ->
        // code to execute
    }
    .setNeutralButton("Neutral") { _, _ ->
        // code to execute
    }
    .show()
        
    // this code is executed before the dialog is finished
    println("Hello World")
```

Now, using the suspend dialog, we can wait for the dialog to be finish after continue with rest of the code flow
```kotlin
val result = SuspendAlertDialog.confirm(
    positiveButtonText = "Positive",
    negativeButtonText = "Negative",
    neutralButtonText = "Neutral"
) {
    MaterialAlertDialogBuilder(this@MainActivity)
        .setTitle("Title")
        .setMessage("Message")
}

// this line is executed after the dialog above is finish
tvResult.text = result.toString()
```

If you are fan of extension functions, the below approach can be used to achieve the same behavior as above.
```kotlin
val result = MaterialAlertDialogBuilder(this@MainActivity)
    .setTitle("Title")
    .setMessage("Message")
    .confirm(
        positiveButtonText = "Save",
        negativeButtonText = "Cancel",
        neutralButtonText = "Neutral",
    )

tvResult.text = result.toString()
```

### Alert

```kotlin
SuspendAlertDialog.alert("Ok") {
    MaterialAlertDialogBuilder(this@MainActivity).setTitle("Selected Option")
}

tvResult.text = getString(R.string.alert_finished)
```

Using extension function

```kotlin
MaterialAlertDialogBuilder(this@MainActivity)
    .setTitle("Selected Option")
    .alert("Ok")

tvResult.text = getString(R.string.alert_finished)
```

### Multi Choice Items

```kotlin
val multiChoiceResult = SuspendAlertDialog.setMultiChoiceItems(
        positiveButtonText = "Save",
        negativeButtonText = "Cancel",
        neutralButtonText = "Minimize",
        items = SuspendAlertDialog.MultiChoiceItems(
            items = listOf("Hello", "World", "Berlin", "Germany"),
            checked = listOf(false, false, false, false)
        )
) {
    MaterialAlertDialogBuilder(this@MainActivity).setTitle("Title")
}

tvResult.text = multiChoiceResult.toString()
```

Using extension function

```kotlin
val result = MaterialAlertDialogBuilder(this@MainActivity)
    .setTitle("Title")
    .setMultiChoiceItems(
        positiveButtonText = "Save",
        negativeButtonText = "Cancel",
        neutralButtonText = "Minimize",
        items = SuspendAlertDialog.MultiChoiceItems(
            items = listOf("Hello", "World", "Berlin", "Germany"),
            checked = listOf(false, false, false, false)
        )
    )

tvResult.text = result.toString()
```

### Single Choice Items

```kotlin
val singleChoiceResult = SuspendAlertDialog.setSingleChoiceItems(
    positiveButtonText = "Save",
    negativeButtonText = "Cancel",
    neutralButtonText = "Minimize",
    items = SuspendAlertDialog.SingleChoiceItems(
        items = listOf("Hello", "World", "Berlin", "Germany"),
        selectedIndex = 1
    )
) {
  MaterialAlertDialogBuilder(this@MainActivity).setTitle("Title")
}

tvResult.text = singleChoiceResult.toString()
```

Using extension function

```kotlin
val result = MaterialAlertDialogBuilder(this@MainActivity)
    .setTitle("Title")
    .setSingleChoiceItems(
        positiveButtonText = "Save",
        negativeButtonText = "Cancel",
        neutralButtonText = "Minimize",
        items = SuspendAlertDialog.SingleChoiceItems(
            items = listOf("Hello", "World", "Berlin", "Germany"),
            selectedIndex = 1
        )
    )

tvResult.text = result.toString()
```

## Custom Dialogs (DialogFragment & BottomSheetDialogFragment)

While above we read how to suspend calls to some dialogs, here we will discuss about suspend of calls to the DialogFragment and BottomSheetDialogFragment.

### showAwait

Show await suspends the call till the dialog is destroyed. Returns an Unit.

```kotlin
DemoDialogFragment().showAwait(
	fragmentManager = supportFragmentManager,
	tag = DemoDialogFragment::class.java.canonicalName
)

tvResult.text = "${DemoDialogFragment::class.java.canonicalName} finished"
```

### showAwaitResult

Dialogs that must return results, an implementation of `SuspendDialogResult` interface is a must. `SuspendDialogResult` provides a member called `result` which one is returned
from the dialog after destroy. Make sure to assign a value to `result` before calling dismiss.

For more details, check the example app.

```kotlin
val result = DemoResultDialogFragment().showAwaitResult(
	fragmentManager = supportFragmentManager,
	tag = DemoResultDialogFragment::class.java.canonicalName
)
tvResult.text = result
```
