import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.service.Service
import com.example.handyman.R
import com.squareup.picasso.Picasso


class CategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.category_single_layout,parent,false)) {

    private var name:TextView? = null
    private var photo: ImageView? =null

    init {
        name = itemView.findViewById(R.id.nameCategorySingleLayout)
        photo = itemView.findViewById(R.id.imageCategorySingleLayout)

    }

    fun bind (service : Service){

        name?.text = service.title
        Picasso.get().load(service.service_img).into(photo)
    }

}