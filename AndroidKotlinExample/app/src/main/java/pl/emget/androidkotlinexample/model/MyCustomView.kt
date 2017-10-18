package pl.emget.androidkotlinexample.model

import android.view.View


class MyCustomView {
        lateinit var listener: (View) -> Unit
        lateinit var listener2: View.OnClickListener

        fun setOnClickListener(listenerParam: View.OnClickListener){
            // register callback
            this.listener = listenerParam::onClick
            this.listener = {
                //lambda
            }

            val view = View(null)
            listener(view)
            listener2.onClick(view)
        }

        fun setOnClickListener(listener: (View) -> Unit){
            // register callback
            this.listener = listener
        }

}

fun xcv(){
    MyCustomView().apply { listener = { println("aaa")} }
}