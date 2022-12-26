package com.kudos.devbytesapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kudos.devbytesapp.databinding.RowItemDevBytesVideoBinding
import com.kudos.devbytesapp.domain.DevByteVideo

class DevBytesVideoAdapter(private val onItemClick: (DevByteVideo) -> Unit) :
    ListAdapter<DevByteVideo, DevBytesVideoAdapter.ViewHolder>(callback) {

    companion object {
        val callback = object : DiffUtil.ItemCallback<DevByteVideo>() {
            override fun areItemsTheSame(
                oldItem: DevByteVideo,
                newItem: DevByteVideo
            ) =
                oldItem.url == newItem.url

            override fun areContentsTheSame(
                oldItem: DevByteVideo,
                newItem: DevByteVideo
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(val rowItemDevBytesVideoBinding: RowItemDevBytesVideoBinding) :
        RecyclerView.ViewHolder(rowItemDevBytesVideoBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowItemDevBytesVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            rowItemDevBytesVideoBinding.apply {
                val item = getItem(position)
                video = item

                clickableOverlay.setOnClickListener {
                    onItemClick(item)
                }

            }
        }
    }

}