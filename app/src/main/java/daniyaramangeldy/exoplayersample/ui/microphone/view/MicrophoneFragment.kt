package daniyaramangeldy.exoplayersample.ui.microphone.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import daniyaramangeldy.exoplayersample.R
import daniyaramangeldy.exoplayersample.ui.microphone.presenter.MicrophonePresenter


class MicrophoneFragment : MvpAppCompatFragment(),MicrophoneView {

    @InjectPresenter
    lateinit var presenter: MicrophonePresenter

    companion object {
        fun newInstance(): MicrophoneFragment {
            val fragment = MicrophoneFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_microphone, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
