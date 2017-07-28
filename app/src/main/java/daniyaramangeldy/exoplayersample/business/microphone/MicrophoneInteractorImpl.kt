package daniyaramangeldy.exoplayersample.business.microphone

import android.content.Context
import android.media.MediaRecorder
import daniyaramangeldy.exoplayersample.data.repository.microphone.MicrophoneRepository
import javax.inject.Inject
import android.util.Log
import cafe.adriel.androidaudioconverter.AndroidAudioConverter
import cafe.adriel.androidaudioconverter.callback.IConvertCallback
import cafe.adriel.androidaudioconverter.model.AudioFormat
import daniyaramangeldy.exoplayersample.di.microphone.MicrophoneScope
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

@MicrophoneScope
class MicrophoneInteractorImpl @Inject constructor(val microphoneRepository: MicrophoneRepository) : MicrophoneInteractor,IConvertCallback {

    lateinit var cachedFileName: String
    lateinit var path: String
    var mMediaRecorder: MediaRecorder? = null
    val TAG = "MicrophoneInteractor"

    override fun stopRecord(context:Context) {
        stopMediaRecorder()
        convertMediaToM4a(context)
    }

    private fun stopMediaRecorder() {
        mMediaRecorder?.stop()
        mMediaRecorder?.release()
        mMediaRecorder = null
    }

    private fun convertMediaToM4a(context:Context) {
        val file: File = File(path,cachedFileName)
        AndroidAudioConverter.with(context)
                .setFile(file)
                .setFormat(AudioFormat.M4A)
                .setCallback(this)
                .convert()
    }

    override fun onSuccess(file: File?) {
        Log.d(TAG,"file created at path: ${file?.absolutePath}")
    }

    override fun onFailure(error: Exception?) {
        Log.d(TAG,"file create error ${error?.message}")
    }

    override fun startRecord(path: String) {
        this.path = path
        mMediaRecorder = MediaRecorder()
        mMediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mMediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
        mMediaRecorder?.setOutputFile(generateFileName(path))
        mMediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.HE_AAC)
        prepareRecorder(mMediaRecorder)
        mMediaRecorder?.start()
    }


    private fun prepareRecorder(mMediaRecorder: MediaRecorder?) {
        try {
            mMediaRecorder?.prepare()
        } catch (e: IOException) {
            throw e
        }
    }

    private fun generateFileName(path: String): String {
        cachedFileName = "${generateMd5EncryptedName()}.3gp"
        Log.d(TAG, cachedFileName)
        return "$path/$cachedFileName"
    }

    private fun generateMd5EncryptedName(): String {
        try {
            var mdEnc = MessageDigest.getInstance("MD5")
            val currentTime = System.currentTimeMillis().toString()
            mdEnc!!.update(currentTime.toByteArray(), 0, currentTime.length)
            var md5 = BigInteger(1, mdEnc!!.digest()).toString(16)
            while (md5.length < 32) {
                md5 = "0$md5"
            }
            return md5
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            return ""
        }
    }
}


