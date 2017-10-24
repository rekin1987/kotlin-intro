package examples

import android.view.View

class MyCustomView {
        lateinit var listener: (View) -> Unit
        lateinit var listener2: View.OnClickListener

        fun setOnClickListener(listenerParam: View.OnClickListener){
            this.listener = listenerParam::onClick
            this.listener = {
                //lambda
            }

            this.listener2 = listenerParam
        }

        fun setOnClickListener(listener: (View) -> Unit){
            this.listener = listener
            //this.listener2 = listener // does not compile
        }
}

fun callingCustomView(){
    val cv = MyCustomView().apply {
        listener = { println("aaa") }
    }
    val view = View(null)
    cv.listener(view)
    cv.listener2.onClick(view)
}