package pl.emget.androidkotlinexample.additions

import android.os.Build

fun readApiLevel() = Build.VERSION.SDK_INT
fun readApiName() = Build.VERSION.CODENAME

inline fun aboveLollipop(functionToExecute: () -> Unit) {
    if (Build.VERSION.SDK_INT > 21 /*Build.VERSION_CODES.LOLLIPOP*/) {
        functionToExecute()
    }
}

