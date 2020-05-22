package layout

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handyman.Models.jobSeeker.Seekers
import com.example.handyman.R
import com.squareup.picasso.Picasso


class JobSeekerViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.job_seeker_single_layout,parent,false)) {

    private var imageView: ImageView? = null
    private var name:TextView? = null
    private var rating: TextView? = null
    private var jobType: TextView? = null
    private var rate:TextView? = null
    private var distance:TextView? = null
    private var workdone : TextView? =null


    init {

        imageView = itemView.findViewById(R.id.imageViewJobSeeker)
        name = itemView.findViewById(R.id.nameJobSeeker)
        rating = itemView.findViewById(R.id.ratingJobSeeker)
        jobType= itemView.findViewById(R.id.jobTypeJobSeeker)
        rate = itemView.findViewById(R.id.rateJobSeeker)
        distance = itemView.findViewById(R.id.distanceJobSeeker)
        workdone = itemView.findViewById(R.id.workDoneJobSeeker)

    }

    fun bind(jobSeeker: Seekers, title: String) {
        if(jobSeeker.general_information.profile_image!= "")
        Picasso.get().load(jobSeeker.general_information.profile_image).fit().into(imageView)
        name?.text = jobSeeker.general_information.name
        rate?.text = "$ "+jobSeeker.hourly_rate+" / per hour"


       // rating?.text = jobSeeker. + "$"
        jobType?.text = title
       // workdone?.text = jobSeeker.workDone
       // distance?.text = jobSeeker.distance + " km away"
    }

}