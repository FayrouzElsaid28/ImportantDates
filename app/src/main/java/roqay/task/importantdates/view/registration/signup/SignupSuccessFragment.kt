package roqay.task.importantdates.view.registration.signup


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_signup_success.*
import roqay.task.importantdates.R
import roqay.task.importantdates.helpers.extensions.openActivityFromParent
import roqay.task.importantdates.view.main.MainActivity

class SignupSuccessFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signup_success, container, false)
        if (dialog != null && dialog?.window != null) {
            dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog?.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //To prevent dismissing fragment from outside
        dialog?.setCanceledOnTouchOutside(false)

        close.setOnClickListener { dismiss() }
        back_tv.setOnClickListener { dismiss() }

        continue_btn.setOnClickListener {
            openActivityFromParent(MainActivity::class.java)
            activity?.finishAffinity()
        }
    }

}
