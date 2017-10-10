package pl.emget.androidkotlinexample

import android.os.Build


fun readApiLevel() = Build.VERSION.SDK_INT
fun readApiName() = Build.VERSION.CODENAME

inline fun atLeastLollipop(functionToExecute: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        functionToExecute()
    }
}

