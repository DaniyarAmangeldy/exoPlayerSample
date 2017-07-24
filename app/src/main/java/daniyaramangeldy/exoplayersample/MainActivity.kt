package daniyaramangeldy.exoplayersample

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelector
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.TrackSelection
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.BandwidthMeter
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.util.Util.getUserAgent
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import com.google.android.exoplayer2.util.Util


class MainActivity : AppCompatActivity() {

    lateinit var player:SimpleExoPlayer;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mp3Uri: Uri = Uri.Builder().appendEncodedPath("http://e-cdn-preview-5.deezer.com/stream/51afcde9f56a132096c0496cc95eb24b-4.mp3").build()
        val mainHandler = Handler()
        val bandwidthMeter = DefaultBandwidthMeter()
        val dataSourceFactory = DefaultDataSourceFactory(applicationContext,
                Util.getUserAgent(applicationContext, "yourApplicationName"), bandwidthMeter)
        val extractorsFactory = DefaultExtractorsFactory()
        val cache: SimpleCache = SimpleCache(applicationContext.externalCacheDir,LeastRecentlyUsedCacheEvictor(1024000))
        val cacheSourceFactory = CacheDataSourceFactory(cache,dataSourceFactory)
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
        val videoSource = ExtractorMediaSource(Uri.parse("http://e-cdn-preview-5.deezer.com/stream/51afcde9f56a132096c0496cc95eb24b-4.mp3"),
                cacheSourceFactory, extractorsFactory, null, null)
        player = ExoPlayerFactory.newSimpleInstance(applicationContext, trackSelector)
        player.prepare(videoSource)
        playerView.player = player
        player.playWhenReady = true


    }

    override fun onStop() {
        super.onStop()
        player.release()
    }
}
