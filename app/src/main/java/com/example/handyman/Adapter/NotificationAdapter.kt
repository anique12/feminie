
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.Notification
import layout.NotificationViewHolder

class NotificationAdapter(var notification: ArrayList<Notification>): RecyclerView.Adapter<NotificationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        return NotificationViewHolder(inflater,parent)
    }

    override fun getItemCount()= notification.size


    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        var notification= notification[position]
        holder.bind(notification)
    }

}