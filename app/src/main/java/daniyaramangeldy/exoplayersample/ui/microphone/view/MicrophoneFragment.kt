package daniyaramangeldy.exoplayersample.ui.microphone.view


import android.os.Bundle
import android.os.SystemClock
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import daniyaramangeldy.exoplayersample.R
import daniyaramangeldy.exoplayersample.ui.microphone.presenter.MicrophonePresenter
import kotlinx.android.synthetic.main.fragment_microphone.*
import android.widget.Chronometer
import com.jakewharton.rxbinding2.view.clicks
import org.jetbrains.anko.toast


class MicrophoneFragment : MvpAppCompatFragment(), MicrophoneView {

    val btnToggleRecord: FloatingActionButton by lazy { button_toggleRecord }
    val timer: Chronometer by lazy { tv_chronometer }
    var clicked = false

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
        btnToggleRecord.clicks()
                .doOnError(this::handleButtonTouchesError)
                .retry()
                .subscribe(this::handleButtonTouchesSuccess)
    }


    private fun handleButtonTouchesSuccess(void: Unit) {
        clicked = !clicked
        ToggleTimer(clicked)
        ChangeButtonDrawable(clicked)
        ToggleRecordAudio(clicked)

    }

    private fun ChangeButtonDrawable(clicked: Boolean) {
        val drawable = context.getDrawable(when (clicked) {
            true -> R.drawable.ic_stop_black_24dp
            false -> R.drawable.ic_fiber_manual_record_black_24dp
        })
        btnToggleRecord.setImageDrawable(drawable)
    }

    private fun ToggleTimer(clicked: Boolean) {
        if (clicked) {
            timer.start()
        } else {
            timer.stop()
            timer.base = SystemClock.elapsedRealtime()
        }
    }


    private fun ToggleRecordAudio(clicked: Boolean) {
        when (clicked) {
            true -> presenter.startRecord(getAbsolutePath())
            false -> presenter.stopRecord(context)
        }
    }

    private fun getAbsolutePath(): String = context.externalCacheDir.absolutePath



    private fun handleButtonTouchesError(error: Throwable) {
        context.toast("${error.message}")
    }

}
