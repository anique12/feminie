package layout

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.Chat
import com.example.handyman.Models.Notification
import com.example.handyman.Models.Review
import com.example.handyman.R
import com.squareup.picasso.Picasso


class ReviewtViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.review_single_layout,parent,false)) {

    private var imageView: ImageView? = null
    private var name:TextView? = null
    private var time: TextView? = null
    private var rating: TextView? = null
    private var reviewp:TextView? = null

    init {

        imageView = itemView.findViewById(R.id.imageViewReviews)
        time = itemView.findViewById(R.id.dateReviews)
        name = itemView.findViewById(R.id.nameReviews)
        rating = itemView.findViewById(R.id.ratingReviews)
        reviewp = itemView.findViewById(R.id.review)

    }

    fun bind(review: Review) {

        name?.text = review.name
        time?.text = review.timeStamp
        rating?.text = review.rating
        Picasso.get().load(review.image).fit().into(imageView)
        reviewp?.text = review.review
    }

}