
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.jobSeeker.Seekers
import com.example.handyman.fragments.JobSeekerFragment
import layout.JobSeekerViewHolder

class JobSeekerAdapter(
    var context: JobSeekerFragment,
    var jobSeeker: List<Seekers>,
    var title: String
): RecyclerView.Adapter<JobSeekerViewHolder>(){
    private lateinit var jobSeekerCallback: JobSeekerCallback
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobSeekerViewHolder {
        jobSeekerCallback = context
        val inflater= LayoutInflater.from(parent.context)
        return JobSeekerViewHolder(inflater,parent)
    }

    override fun getItemCount()= jobSeeker.size


    override fun onBindViewHolder(holder: JobSeekerViewHolder, position: Int) {
        var jobSeeker= jobSeeker[position]
        holder.bind(jobSeeker,title)
        holder.itemView.setOnClickListener {
            jobSeekerCallback.callback(jobSeeker)
        }
    }

}

interface JobSeekerCallback{
    fun callback(jobSeeker: Seekers)
}
