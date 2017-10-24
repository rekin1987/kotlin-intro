package pl.emget.androidkotlinexample.components


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import pl.emget.androidkotlinexample.R
import pl.emget.androidkotlinexample.model.*
import java.text.SimpleDateFormat
import java.util.*

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
            with(person) lambda@ {
                with(itemView) {
                    title.text = when (this@lambda) {
                        is CinemaEvent -> "CINEMA (${this@lambda.freeSpots})"
                        is TheaterEvent -> "THEATER (${if (this@lambda.formalOutfitRequired) "formal" else " casual"})"
                        else -> "N/A"
                    }

                    val formattedDate = SimpleDateFormat("dd/MM HH:mm").format(Date(this@lambda.time))
                    val desc = "${this@lambda.title} : $formattedDate : ${this@lambda.data}"
                    name.text = desc
                    setOnClickListener { itemClick(this@lambda) }
                }
            }
        }
    }
}