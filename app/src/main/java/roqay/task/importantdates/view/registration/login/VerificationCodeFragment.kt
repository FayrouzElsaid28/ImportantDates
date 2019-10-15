package roqay.task.importantdates.view.registration.login


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_verification_code.*
import roqay.task.importantdates.R


class VerificationCodeFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_verification_code, container, false)
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

        resend_code.setOnClickListener {
            //TODO:: resend code from server
        }
    }
}
