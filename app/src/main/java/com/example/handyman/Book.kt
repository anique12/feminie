package com.example.handyman


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import android.graphics.Color.LTGRAY
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso
import devs.mulham.horizontalcalendar.HorizontalCalendar
import java.util.*
import android.app.TimePickerDialog
import kotlinx.android.synthetic.main.fragment_book.*
import kotlinx.android.synthetic.main.fragment_book.view.*
import android.view.WindowManager




/**
 * A simple [Fragment] subclass.
 */
class Book : Fragment() {

    private lateinit var horizontalCalendar : HorizontalCalendar
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_book,container,false)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        Picasso.get().load(resources.getString(R.string.person_image)).into(view.profileBook)
        view.chooseTime.setOnClickListener {
            val mcurrentTime = Calendar.getInstance()
            val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute = mcurrentTime.get(Calendar.MINUTE)
            val mTimePicker: TimePickerDialog
            mTimePicker = TimePickerDialog(context,TimePickerDialog.OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                view.chooseTime.text = "$selectedHour:$selectedMinute"
            }, hour, minute, false)//Yes 24 hour time
            mTimePicker.setTitle("Select Time")
            mTimePicker.show()
        }
        val startDate = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)

        /* end after 1 month from now */
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

        horizontalCalendar = HorizontalCalendar.Builder(view, R.id.calendarView)
            .range(startDate, endDate)
            .datesNumberOnScreen(5)
            .configure()
            .formatTopText("MMM")
            .formatMiddleText("dd")
            .formatBottomText("EEE")
            .textSize(14f, 24f, 14f)
            .showTopText(true)
            .showBottomText(true)
            .textColor(LTGRAY, Color.WHITE)
            .end()
            .build()

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Calendar, position: Int) {
                /* Toast.makeText(
                     context,
                     android.text.format.DateFormat.format("EEE, MMM d, yyyy", date) + " is selected!",
                     Toast.LENGTH_SHORT
                 ).show()*/
            }

        }
            return view
    }


}
