package roqay.task.importantdates.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import roqay.task.importantdates.R
import roqay.task.importantdates.model.main.Main

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mainList = arrayListOf<Main>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_main,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mainList.size
    }
    
    fun setData(newData: ArrayList<Main>){
        mainList = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.main_day_name.text = mainList[position].dayName
        holder.main_day_number.text = mainList[position].dayNumber.toString()
        holder.main_month.text = mainList[position].month
        holder.main_title.text = mainList[position].title
        holder.main_details.text = mainList[position].details
        holder.main_circle.setImageResource(mainList[position].circle)
        holder.main_icon.setImageResource(mainList[position].icon)
        //TODO:: Change view color and layout background
        /**
         * View --> Red if event is today
         *      --> Gray if not
         */
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val main_day_name: TextView = itemView.findViewById(R.id.main_day_name)
        val main_day_number: TextView = itemView.findViewById(R.id.main_day_number)
        val main_month: TextView = itemView.findViewById(R.id.main_month)
        val main_title: TextView = itemView.findViewById(R.id.main_title)
        val main_details: TextView = itemView.findViewById(R.id.main_details)
        val main_circle: ImageView = itemView.findViewById(R.id.main_circle)
        val main_icon: ImageView = itemView.findViewById(R.id.main_icon)
        val main_view: View = itemView.findViewById(R.id.main_view)
        val main_layout: ConstraintLayout = itemView.findViewById(R.id.main_layout)
    }
}