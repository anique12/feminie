
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.service.Service
import com.example.handyman.fragments.Categories


class CategoryAdapter(var serviceList: List<Service>, var context:Categories): RecyclerView.Adapter<CategoryViewHolder>(){
    private lateinit var callBack : CategoryCallback
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder{
         callBack = context
        val inflater= LayoutInflater.from(parent.context)
        return CategoryViewHolder(inflater,parent)
    }

    override fun getItemCount()= serviceList.size


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var service= serviceList[position]
        holder.bind(service)
        holder.itemView.setOnClickListener {
            callBack.callBack(service)
        }
    }

}

interface CategoryCallback{
    fun callBack(responceData: Service)
}