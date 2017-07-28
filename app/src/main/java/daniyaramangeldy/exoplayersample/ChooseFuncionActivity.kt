package daniyaramangeldy.exoplayersample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_DOWN
import android.view.MotionEvent.ACTION_UP
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.view.longClicks
import com.jakewharton.rxbinding2.view.touches
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_choose_funcion.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ChooseFuncionActivity : AppCompatActivity() {
    val TAG = "tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_funcion)
        microphoneButton.setOnClickListener { startActivity<MicrophoneActivity>() }
        playerButton.setOnClickListener { startActivity<MainActivity>() }
        microphoneButton.touches().subscribe(this::onSuccess)

    }


    private fun onSuccess(t:MotionEvent){
        when(t.action){
             ACTION_DOWN -> toast("down")
             ACTION_UP -> toast("up")
        }

    }

    private fun onError(error: Throwable){

    }

}

