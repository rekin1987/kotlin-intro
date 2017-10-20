package pl.emget.androidkotlinexample.components


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import pl.emget.androidkotlinexample.R
import pl.emget.androidkotlinexample.model.Developer
import pl.emget.androidkotlinexample.model.JavaPerson
import pl.emget.androidkotlinexample.model.Tester

class PeopleAdapter(private val peopleList: List<JavaPerson>,
                    private val itemClick: (JavaPerson) -> Unit) :
        RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(peopleList[position])
    }

    override fun getItemCount() = peopleList.size

    class ViewHolder(view: View, private val itemClick: (JavaPerson) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindView(person: JavaPerson) {
            with(person) {
                itemView.title.text = when (this) {
                    is Developer -> "DEV"
                    is Tester -> "TEST"
                    else -> "N/A"
                }
                itemView.name.text = name
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}