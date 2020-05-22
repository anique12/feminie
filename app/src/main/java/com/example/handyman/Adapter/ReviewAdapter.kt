
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.Chat
import com.example.handyman.Models.Notification
import com.example.handyman.Models.Review
import layout.ChatViewHolder
import layout.NotificationViewHolder
import layout.RequestViewHolder
import layout.ReviewtViewHolder

class ReviewAdapter(var review: ArrayList<Review>): RecyclerView.Adapter<ReviewtViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewtViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        return ReviewtViewHolder(inflater,parent)
    }

    override fun getItemCount()= review.size


    override fun onBindViewHolder(holder: ReviewtViewHolder, position: Int) {
        var review= review[position]
        holder.bind(review)
    }

}