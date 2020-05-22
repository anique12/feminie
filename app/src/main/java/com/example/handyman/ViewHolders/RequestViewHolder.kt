package layout

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.Request
import com.example.handyman.R
import com.squareup.picasso.Picasso


class RequestViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.requests_single_layout,parent,false)) {

    private var imageView: ImageView? = null
    private var name:TextView? = null
    private var status: TextView? = null
    private var jobType: TextView? = null
    private var rate:TextView? = null
    private var time:TextView? = null


    init {

        imageView = itemView.findViewById(R.id.imageViewRequest)
        name = itemView.findViewById(R.id.nameRequest)
        jobType = itemView.findViewById(R.id.jobTypeRequest)
        rate = itemView.findViewById(R.id.rateRequest)
        time = itemView.findViewById(R.id.timeRequest)
        status = itemView.findViewById(R.id.statusRequest)

    }

    fun bind(request: Request) {

        Picasso.get().load(request.url).fit().into(imageView)
        name?.text = request.name
        rate?.text = "$ "+request.rate+"/ per hour"
        status?.text = request.status
        jobType?.text = request.jobType
        time?.text = request.timeStamp
    }

}