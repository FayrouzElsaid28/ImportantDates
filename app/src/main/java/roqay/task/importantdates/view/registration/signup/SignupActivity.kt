package roqay.task.importantdates.view.registration.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_signup.*
import roqay.task.importantdates.R
import roqay.task.importantdates.helpers.extensions.activeColor
import roqay.task.importantdates.helpers.extensions.notActiveColor
import roqay.task.importantdates.view.registration.login.VerificationCodeFragment

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        initView()
    }

    private fun initView() {
        back.setOnClickListener { onBackPressed() }
        login_layout.setOnClickListener { onBackPressed() }
        signup_btn.setOnClickListener {
            SignupSuccessFragment().show(supportFragmentManager,"")
        }

        //username
        handlePlaceHolder(
            signup_username_et,
            signup_username_layout,
            signup_username_txt
        )
        //email
        handlePlaceHolder(
            signup_mail_et,
            signup_email_layout,
            signup_email_txt
        )
        //phone
        handlePlaceHolder(
            signup_phone_et,
            signup_phone_layout,
            signup_phone_txt
        )
        //password
        handlePlaceHolder(
            signup_password_et,
            signup_password_layout,
            signup_password
        )
        //confirm password
        handlePlaceHolder(
            signup_confirm_password_et,
            signup_confirm_password_layout,
            signup_confirm_password
        )
    }

    private fun handlePlaceHolder(
        editText: EditText?,
        layout: ConstraintLayout?,
        textView: TextView?
    ) {
        editText?.onFocusChangeListener = View.OnFocusChangeListener { _, focus ->
            if (focus){
                layout?.setBackgroundResource(R.drawable.active_edittext_background)
                textView?.setTextColor(activeColor)
            }else{
                layout?.setBackgroundResource(R.drawable.not_active_edittext_background)
                textView?.setTextColor(notActiveColor)
            }
        }
    }
}
