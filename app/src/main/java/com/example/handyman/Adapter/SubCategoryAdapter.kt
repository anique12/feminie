
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.subService.SubService
import com.example.handyman.fragments.SubCategories
private  lateinit var subCategorycallback: SubCategorycallback
class SubCategoryAdapter(
    var list: List<SubService>,
    val context: SubCategories
): RecyclerView.Adapter<SubCategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        subCategorycallback = context
        val inflater= LayoutInflater.from(parent.context)
        return SubCategoryViewHolder(inflater,parent)
    }

    override fun getItemCount()= list.size


    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        var subCategory= list[position]
        holder.bind(subCategory)
        holder.itemView.setOnClickListener {
            subCategorycallback.callback(subCategory)
        }
    }

}

interface SubCategorycallback{
    fun callback(subCategory: SubService)
}
