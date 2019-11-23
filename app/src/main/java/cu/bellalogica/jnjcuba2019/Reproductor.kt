package cu.bellalogica.jnjcuba2019

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.support.annotation.RawRes
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
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

class Reproductor(var contexto: Context,var player:SimpleExoPlayer?=null)  {

    lateinit var mPlayerView: PlayerView
    fun Reproducir(playerView: SimpleExoPlayerView,rawRes: Int ){


        player = ExoPlayerFactory.newSimpleInstance(
                DefaultRenderersFactory(contexto),
                DefaultTrackSelector(),
                DefaultLoadControl())
        playerView?.setPlayer(player)


        var datasrc = DefaultDataSourceFactory(contexto, Util.getUserAgent(contexto,"JNJ CUBA 2019"))
        var mediasrc = ExtractorMediaSource.Factory(datasrc).createMediaSource(RawResourceDataSource.buildRawResourceUri(rawRes))
        player?.prepare(mediasrc)

    }

    lateinit var controlView : PlaybackControlView
    lateinit var mFullScreenIcon : ImageView
    lateinit var mFullScreenButton : FrameLayout
    var mExoPlayerFullscreen = false
    lateinit var params: ViewGroup.LayoutParams

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
    }
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
