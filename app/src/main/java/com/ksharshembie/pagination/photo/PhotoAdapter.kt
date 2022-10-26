package com.ksharshembie.pagination.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ksharshembie.pagination.databinding.ItemHitsBinding
import com.ksharshembie.pagination.model.ImageModel

class PhotoAdapter(val list: List<ImageModel>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(val binding: ItemHitsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageModel: ImageModel) {
            binding.photoImg.load(imageModel.largeImageURL)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemHitsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}