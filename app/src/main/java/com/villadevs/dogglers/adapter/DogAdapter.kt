package com.villadevs.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.villadevs.dogglers.R
import com.villadevs.dogglers.model.Dog

class DogAdapter(private val context: Context, private val listDog: List<Dog>) :
    RecyclerView.Adapter<DogAdapter.DogViewHoder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHoder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_dog, parent, false)
        return DogViewHoder(adapterLayout)

    }

    override fun getItemCount(): Int = listDog.size

    override fun onBindViewHolder(holder: DogViewHoder, position: Int) {
        val dog = listDog[position]
        holder.tvDogName.text = dog.name
        holder.tvDogAge.text = dog.age
        holder.tvDogHobbies.text = dog.hobbies
        holder.ivDogImage.setImageResource(dog.imageResourceId)
    }


    class DogViewHoder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvDogName : TextView = view.findViewById(R.id.tvDogName)
        val tvDogAge : TextView = view.findViewById(R.id.tvDogAge)
        val tvDogHobbies : TextView = view.findViewById(R.id.tvDogHobbies)
        val ivDogImage : ImageView = view.findViewById(R.id.ivDogImage)


    }

}