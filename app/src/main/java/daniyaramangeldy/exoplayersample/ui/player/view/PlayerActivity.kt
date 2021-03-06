package daniyaramangeldy.exoplayersample.ui.player.view

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import com.google.android.exoplayer2.util.Util
import daniyaramangeldy.exoplayersample.R


class PlayerActivity : AppCompatActivity() {

    lateinit var player:SimpleExoPlayer;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bandwidthMeter = DefaultBandwidthMeter()
        val dataSourceFactory = DefaultDataSourceFactory(applicationContext,
                Util.getUserAgent(applicationContext, "yourApplicationName"), bandwidthMeter)
        val extractorsFactory = DefaultExtractorsFactory()
        val cache: SimpleCache = SimpleCache(applicationContext.externalCacheDir,LeastRecentlyUsedCacheEvictor(1024*1024*10))
        val cacheSourceFactory = CacheDataSourceFactory(cache,dataSourceFactory)
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
        val videoSource = ExtractorMediaSource(Uri.parse("http://138.68.64.233:3000/1.mp3"),
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
