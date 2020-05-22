import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.subService.SubService
import com.example.handyman.R


class SubCategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.subcategories_single_layout,parent,false)) {

    private var name:TextView? = null

    init {
        name = itemView.findViewById(R.id.nameSubcategory)
    }

    fun bind(subService: SubService) {
        name?.text = subService.title

    }

}
