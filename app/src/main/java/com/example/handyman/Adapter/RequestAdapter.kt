
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.*
import com.example.handyman.fragments.JobSeekerFragment
import layout.ChatViewHolder
import layout.JobSeekerViewHolder
import layout.NotificationViewHolder
import layout.RequestViewHolder

class RequestAdapter(var request: ArrayList<Request>): RecyclerView.Adapter<RequestViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        return RequestViewHolder(inflater,parent)
    }

    override fun getItemCount()= request.size


    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        var request= request[position]
        holder.bind(request)
    }

}
