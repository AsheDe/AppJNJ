package cu.bellalogica.jnjcuba2019

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.RawRes
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.FrameLayout
import android.widget.ImageView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlaybackControlView
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.actividad_reproductor.*

class Actividad_Reproductor : AppCompatActivity()  {

    lateinit var mPlayerView: PlayerView
    lateinit var controlView : PlaybackControlView
    lateinit var mFullScreenIcon : ImageView
    lateinit var mFullScreenButton : FrameLayout
    var mExoPlayerFullscreen = true
    lateinit var params: ViewGroup.LayoutParams
    var player : SimpleExoPlayer?  = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_reproductor)

        setTheme(android.R.style.Theme_Black_NoTitleBar_Fullscreen)

        var arrayvideos = listOf(R.raw.video_jnj_2016,R.raw.video_mosennor)

        Utiles.FullScreen(this)
      /*  constraint_container.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        constraint_container.setOnClickListener {
            if(mExoPlayerFullscreen)
                constraint_container.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            else
                constraint_container.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_LOW_PROFILE or
                                View.SYSTEM_UI_FLAG_FULLSCREEN or
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
*/
        player = ExoPlayerFactory.newSimpleInstance(
                DefaultRenderersFactory(this),
                DefaultTrackSelector(),
                DefaultLoadControl())
        videoPlayer.setPlayer(player)

        var numvideo = intent.getIntExtra("video",0)
        var datasrc = DefaultDataSourceFactory(this, Util.getUserAgent(this,"JNJ CUBA 2019"))
        var mediasrc = ExtractorMediaSource.Factory(datasrc).createMediaSource(RawResourceDataSource.buildRawResourceUri(arrayvideos.get(numvideo)))
        player?.prepare(mediasrc)
        player?.playWhenReady = true


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        player?.seekTo(savedInstanceState!!.getLong("time",0))
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putLong("time",player!!.currentPosition)
        player?.release()
        player = null
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }

    override fun onPause() {
        super.onPause()
        player?.release()
        player = null
    }

    /* fun Reproducir(playerView: SimpleExoPlayerView,rawRes: Int ){


        player = ExoPlayerFactory.newSimpleInstance(
                DefaultRenderersFactory(contexto),
                DefaultTrackSelector(),
                DefaultLoadControl())
        playerView?.setPlayer(player)


        var datasrc = DefaultDataSourceFactory(contexto, Util.getUserAgent(contexto,"JNJ CUBA 2019"))
        var mediasrc = ExtractorMediaSource.Factory(datasrc).createMediaSource(RawResourceDataSource.buildRawResourceUri(rawRes))
        player?.prepare(mediasrc)

    }



    var mFullScreenDialog = object : Dialog(contexto, android.R.style.Theme_Black_NoTitleBar_Fullscreen) {
        override fun onBackPressed() {
            if (mExoPlayerFullscreen)
                closeFullscreenDialog(mPlayerView.parent as ViewGroup)
            super.onBackPressed()
        }
    }


    fun initFullscreenButton(playerView: SimpleExoPlayerView, parent: ViewGroup) {
          mPlayerView = playerView
          controlView =(mPlayerView as ViewGroup).findViewById(R.id.exo_controller) as PlaybackControlView
        mFullScreenIcon = controlView.findViewById(R.id.exo_fullscreen_icon) as ImageView
        mFullScreenButton = controlView.findViewById(R.id.exo_fullscreen_button) as FrameLayout
        params = mPlayerView.layoutParams
        mFullScreenButton.setOnClickListener(View.OnClickListener {
            if (!mExoPlayerFullscreen)
                openFullscreenDialog()
            else
                closeFullscreenDialog(parent)
        })
    }

    private fun openFullscreenDialog() {

    (mPlayerView.getParent() as ViewGroup).removeView(mPlayerView)

    mFullScreenDialog.addContentView(mPlayerView, ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT))
    mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(contexto, R.drawable.ic_fullscreen_exit))
    mExoPlayerFullscreen = true
    mFullScreenDialog.show()
}

    private fun closeFullscreenDialog(toadd:ViewGroup) {

        var parent:ViewGroup =  mPlayerView.getParent() as ViewGroup
    parent.removeView(mPlayerView)
    toadd.addView(mPlayerView,params)
    mExoPlayerFullscreen = false
    mFullScreenDialog.dismiss()
    mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(contexto, R.drawable.ic_fullscreen))
}



    fun releasePlayer() {
        if (player != null) {
          //var  playbackPosition = player.getCurrentPosition()
         //var   currentWindow = player.getCurrentWindowIndex()
         // var  playWhenReady = player.getPlayWhenReady()
            player!!.release()
            player = null
        }
    }*/
}

/*  fun initializePlayer(playerView : SimpleExoPlayerView ) {
      if (player == null) {
          player = ExoPlayerFactory.newSimpleInstance(
                  DefaultRenderersFactory(contexto),
                  DefaultTrackSelector(),
                  DefaultLoadControl())
          playerView?.setPlayer(player)
       //   var path = "android.resource://${actividad?.packageName}/${R.raw.video_m3}"
          player!!.setPlayWhenReady(true)
          // player.seekTo(currentWindow, playbackPosition)
          //   }
          val mediaSource = buildMediaSource(Uri.parse(path))
          player!!.prepare(mediaSource, true, false)
      }
  }

  private fun buildMediaSource(uri: Uri): MediaSource? {

      val userAgent = "exoplayer-codelab"

      if (uri.getLastPathSegment().contains("mp3") || uri.getLastPathSegment().contains("mp4")) {
          return ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
                  .createMediaSource(uri)
      } //else if (uri.getLastPathSegment().contains("m3u8")) {
          //return HlsMediaSource.Factory(DefaultHttpDataSourceFactory(userAgent))
            //      .createMediaSource(uri)
       //else {
         // val dashChunkSourceFactory = DefaultDashChunkSource.Factory(
           //       DefaultHttpDataSourceFactory("ua", 100 ))
          //val manifestDataSourceFactory = DefaultHttpDataSourceFactory(userAgent)
          //return DashMediaSource.Factory(dashChunkSourceFactory, manifestDataSourceFactory).createMediaSource(uri)
      //}
      return null
  }*/
