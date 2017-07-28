package daniyaramangeldy.exoplayersample.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import daniyaramangeldy.exoplayersample.ui.player.view.PlayerActivity
import daniyaramangeldy.exoplayersample.ui.microphone.view.MicrophoneActivity
import daniyaramangeldy.exoplayersample.R
import kotlinx.android.synthetic.main.activity_choose_funcion.*
import org.jetbrains.anko.startActivity

class ChooseFuncionActivity : AppCompatActivity() {
    val TAG = "tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_funcion)
        microphoneButton.setOnClickListener { startActivity<MicrophoneActivity>() }
        playerButton.setOnClickListener { startActivity<PlayerActivity>() }

    }

}

