package roqay.task.importantdates.view.registration.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.os.Handler
import kotlinx.android.synthetic.main.activity_forget_password.*
import roqay.task.importantdates.R
import roqay.task.importantdates.helpers.extensions.activeColor
import roqay.task.importantdates.helpers.extensions.notActiveColor

class ForgetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        initView()
    }

    private fun initView() {
        back.setOnClickListener { onBackPressed() }
        email_et.onFocusChangeListener = View.OnFocusChangeListener { _, focus ->
            if (focus){
                forget_password_email_layout.setBackgroundResource(R.drawable.active_edittext_background)
                forget_password_email_txt.setTextColor(activeColor)
            }else{
                forget_password_email_layout.setBackgroundResource(R.drawable.not_active_edittext_background)
                forget_password_email_txt.setTextColor(notActiveColor)
            }
        }
        btn_send.setOnClickListener {
            loading.visibility = View.VISIBLE
            Handler().postDelayed({
                loading.visibility = View.GONE
                VerificationCodeFragment().show(supportFragmentManager,"")
            },1000)
        }
    }
}
