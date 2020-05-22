
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.Chat
import com.example.handyman.Models.Notification
import layout.ChatViewHolder
import layout.NotificationViewHolder

class ChatAdapter(var chat: ArrayList<Chat>): RecyclerView.Adapter<ChatViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        return ChatViewHolder(inflater,parent)
    }

    override fun getItemCount()= chat.size


    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        var chat= chat[position]
        holder.bind(chat)
    }

}