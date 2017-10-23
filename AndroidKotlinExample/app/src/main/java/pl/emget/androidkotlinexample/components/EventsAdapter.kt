package pl.emget.androidkotlinexample.components


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import pl.emget.androidkotlinexample.R
import pl.emget.androidkotlinexample.model.*

class EventsAdapter(private val eventsList: List<Event>,
                    private val itemClick: (Event) -> Unit) :
        RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(eventsList[position])
    }

    override fun getItemCount() = eventsList.size

    class ViewHolder(view: View, private val itemClick: (Event) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindView(person: Event) {
            with(person) {
                itemView.title.text = when (this) {
                    is CinemaEvent -> "CINEMA"
                    is TheaterEvent -> "THEATER"
                    else -> "N/A"
                }
                itemView.name.text = title
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}