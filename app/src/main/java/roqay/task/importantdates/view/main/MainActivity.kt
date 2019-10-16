package roqay.task.importantdates.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_empty_data.*
import roqay.task.importantdates.R
import roqay.task.importantdates.helpers.extensions.openActivity
import roqay.task.importantdates.model.main.Main
import roqay.task.importantdates.view.main.calender.CalenderActivity
import roqay.task.importantdates.view.main.categories.KidsInformationActivity
import roqay.task.importantdates.view.main.categories.PartnerInformationActivity
import roqay.task.importantdates.view.main.categories.PersonalInformationActivity
import roqay.task.importantdates.view.main.categories.ServantsInformationActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mainAdapter = MainAdapter()
    private val mainList = arrayListOf<Main>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setDummyData()
        setSpinnerData()
    }

    private fun setSpinnerData() {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        for (i in currentYear until currentYear + 30){
            getYearMonths(i)
            //TODO:: Change logic
        }
    }

    private fun getYearMonths(i: Int) {
        val spinnerList = arrayListOf<String>()
        spinnerList.add("$i-October")
        spinnerList.add("$i-October")
        spinnerList.add("$i-October")

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, spinnerList)
        calender_spinner.adapter = spinnerAdapter
    }

    private fun setDummyData() {
        for (i in 0..3)
            mainList.add(Main)
        mainAdapter.setData(mainList)
    }

    private fun initView() {
        //Initialize recycler view
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        main_recycler_view.adapter = mainAdapter

        //Main data layout
        partner_layout.setOnClickListener {
            openActivity(this,PartnerInformationActivity::class.java)
        }
        personal_layout.setOnClickListener {
            openActivity(this,PersonalInformationActivity::class.java)
        }
        servant_layout.setOnClickListener {
            openActivity(this,ServantsInformationActivity::class.java)
        }
        kids_layout.setOnClickListener {
            openActivity(this,KidsInformationActivity::class.java)
        }
        calender_img.setOnClickListener {
            openActivity(this,CalenderActivity::class.java)
        }
        menu_img.setOnClickListener {
            //TODO:: Create side menu
        }

    }
}
