package daniyaramangeldy.exoplayersample.ui.microphone.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import daniyaramangeldy.exoplayersample.R

class MicrophoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_microphone)
        val fragment = supportFragmentManager.findFragmentById(R.id.container) ?: MicrophoneFragment.newInstance()
        supportFragmentManager.beginTransaction()
                .add(R.id.container,fragment)
                .commit()
    }
}
