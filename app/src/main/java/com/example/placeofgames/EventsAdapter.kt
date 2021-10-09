package com.example.placeofgames

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.placeofgames.data.Event
import com.google.android.material.button.MaterialButton

class EventsAdapter(private val data: List<Event>, private val signUpClickListener: OnSignUpClickListener) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val iv: ImageView = view.findViewById(R.id.iv_event)
        val tvName: TextView = view.findViewById(R.id.tv_event_name)
        val tvPeople: TextView = view.findViewById(R.id.tv_people_num)
        val tvAddress: TextView = view.findViewById(R.id.tv_event_address)
        val btnSignUp: MaterialButton = view.findViewById(R.id.btn_event_sign_up)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = data[position]

        //todo refactor
        holder.iv.setImageDrawable(ResourcesCompat.getDrawable(holder.itemView.resources, R.drawable.dog, holder.itemView.context.theme))

        holder.tvName.text = event.name
        holder.tvAddress.text = event.place.address
        holder.tvPeople.text = "Кол-во участников: ${event.currentPeopleNum}/${event.maxPeopleNum}"
        holder.btnSignUp.setOnClickListener {
            signUpClickListener.onClickSignUp(holder.btnSignUp, event.id)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun setData(data: List<Event>){
//        this.data.clear()
//        this.data.addAll(data)
//        notifyDataSetChanged()
//    }

    interface OnSignUpClickListener{
        fun onClickSignUp(v: View, eventId: Int)
    }
}

