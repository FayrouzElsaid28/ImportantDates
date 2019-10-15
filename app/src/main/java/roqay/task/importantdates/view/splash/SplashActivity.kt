package roqay.task.importantdates.view.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import roqay.task.importantdates.R
import roqay.task.importantdates.helpers.extensions.activeColor
import roqay.task.importantdates.helpers.extensions.notActiveColor
import roqay.task.importantdates.helpers.extensions.openActivity
import roqay.task.importantdates.view.registration.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            openActivity(this,LoginActivity::class.java)
            finishAffinity()
            //TODO:: Check if already logged in before
        }, 1000)

        initValues()
    }

    private fun initValues() {
        activeColor = ContextCompat.getColor(applicationContext, R.color.placeholder_red)
        notActiveColor = ContextCompat.getColor(applicationContext, R.color.black)
    }
}
