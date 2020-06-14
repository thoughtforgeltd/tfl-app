package com.gelanees.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gelanees.demo.R
import com.gelanees.presentation.model.ModeView

class JourneyModesAdapter(private val modes: List<ModeView>) :
    RecyclerView.Adapter<JourneyModesAdapter.JourneyModesViewHolder>() {
    class JourneyModesViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.list_item_title)
        val icon: ImageView = view.findViewById(R.id.list_item_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): JourneyModesViewHolder {
        return JourneyModesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_journey_mode, parent, false))
    }

    override fun onBindViewHolder(holder: JourneyModesViewHolder, position: Int) {
        holder.title.text = modes[position].description
        holder.icon.setImageResource(modes[position].icon)
    }

    override fun getItemCount() = modes.size
}