package roqay.task.importantdates.view.registration.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import roqay.task.importantdates.R
import roqay.task.importantdates.helpers.extensions.activeColor
import roqay.task.importantdates.helpers.extensions.notActiveColor
import roqay.task.importantdates.helpers.extensions.openActivity
import roqay.task.importantdates.view.main.MainActivity
import roqay.task.importantdates.view.registration.signup.SignupActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {

        login_btn.setOnClickListener {
            loading.visibility = View.VISIBLE
            Handler().postDelayed({
                //TODO:: Login with api -- view model
                openActivity(this, MainActivity::class.java)
                finishAffinity()
            }, 1000)
        }
        login_forget_password.setOnClickListener {
            openActivity(this,ForgetPasswordActivity::class.java)
        }
        login_create_account_layout.setOnClickListener {
            openActivity(this,SignupActivity::class.java)
        }
        login_mail_et.onFocusChangeListener = View.OnFocusChangeListener { _, focus ->
            if (focus){
                login_email_layout.setBackgroundResource(R.drawable.active_edittext_background)
                login_email_txt.setTextColor(activeColor)
            }else{
                login_email_layout.setBackgroundResource(R.drawable.not_active_edittext_background)
                login_email_txt.setTextColor(notActiveColor)
            }
        }
        login_password_et.onFocusChangeListener = View.OnFocusChangeListener { _, focus ->
            if (focus){
                login_password_layout.setBackgroundResource(R.drawable.active_edittext_background)
                login_password.setTextColor(activeColor)
            }else{
                login_password_layout.setBackgroundResource(R.drawable.not_active_edittext_background)
                login_password.setTextColor(notActiveColor)
            }
        }

    }

}
