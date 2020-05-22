package layout

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.Notification
import com.example.handyman.R
import com.squareup.picasso.Picasso


class NotificationViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.notification_single_layout,parent,false)) {

    private var imageView: ImageView? = null
    private var time: TextView? = null
    private var description: TextView? = null

    init {

        imageView = itemView.findViewById(R.id.circle_imageView_notification)
        time = itemView.findViewById(R.id.time_notification)
        description = itemView.findViewById(R.id.description_notification)

    }

    fun bind(notification: Notification) {

        time!!.text = notification.time
        description!!.text = notification.description
        Picasso.get().load(notification.imageUrl).fit().into(imageView)
    }

}