package cu.bellalogica.jnjcuba2019

import android.app.Dialog
import android.content.Intent
import android.content.res.AssetManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_historia.*
import android.media.MediaPlayer
import android.media.session.MediaSession
import android.net.Uri
import android.os.Environment
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.SurfaceHolder
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ui.PlaybackControlView
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz
import java.io.File


class Historia : AppCompatActivity() {

    lateinit var actividad:AppCompatActivity
    lateinit var mFullScreenDialog :  Dialog
    lateinit var reproductora : Reproductor
    lateinit var reproductora2 : Reproductor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.color.colorPrimaryDark))
        actividad =this
        var listay = arrayListOf(
                R.mipmap.foto3,
                R.mipmap.foto5,
                R.mipmap.foto7,
                R.mipmap.foto13,
                R.mipmap.foto19,
                R.mipmap.foto22,
                R.mipmap.foto23,
                R.mipmap.foto24,
                R.mipmap.foto25,
                R.mipmap.foto26,
                R.mipmap.foto27,
                R.mipmap.foto28,
                R.mipmap.foto29
        )

        lista_historia.adapter =  AdapterList(listay,this)   //StackAdapter(listay)
        lista_historia.layoutManager = GridLayoutManager(this,resources.getInteger(R.integer.columnas_historia) )
        scroller.setOnScrollChangeListener(onscroll)

       /* reproductora = Reproductor(this)
        reproductora.Reproducir(historia_vid1,R.raw.video110)
        reproductora.initFullscreenButton(historia_vid1,act_historia)

        reproductora2 = Reproductor(this)
        reproductora.Reproducir(historia_vid2, R.raw.video_m5)
        reproductora.initFullscreenButton(historia_vid2,act_historia)*/


       // var video_monsennor = vista.findViewById<ImageView>(R.id.video_monsennor)
        historia_vid1.setOnClickListener {
            var intent = Intent(it.context, Actividad_Reproductor::class.java)
            intent.putExtra("video",1)
            startActivity(intent)
        }

        historia_vid2.setOnClickListener {
            var intent = Intent(it.context, Actividad_Reproductor::class.java)
            intent.putExtra("video",0)
            startActivity(intent)
        }


    }




    override fun onResume() {
        super.onResume()

       // reproductora.initFullscreenButton(historia_vid2,act_historia)


      //  var playbackcv = (historia_vid1 as ViewGroup).findViewById(R.id.exo_controller) as PlaybackControlView
    }

    /*  private fun initFullscreenButton() {

        controlView =(historia_vid1 as ViewGroup).findViewById(R.id.exo_controller) as PlaybackControlView
        mFullScreenIcon = controlView.findViewById(R.id.exo_fullscreen_icon) as ImageView
        mFullScreenButton = controlView.findViewById(R.id.exo_fullscreen_button) as FrameLayout
        params = historia_vid1.layoutParams
        mFullScreenButton.setOnClickListener(View.OnClickListener {
            if (!mExoPlayerFullscreen)
                openFullscreenDialog()
            else
                closeFullscreenDialog()
        })
    }

    private fun openFullscreenDialog() {

    (historia_vid1.getParent() as ViewGroup).removeView(historia_vid1)

    mFullScreenDialog.addContentView(historia_vid1, ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT))
    mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen_exit))
    mExoPlayerFullscreen = true
    mFullScreenDialog.show()
}

    private fun closeFullscreenDialog() {

    ( historia_vid1.getParent() as ViewGroup).removeView(historia_vid1)
    act_historia.addView(historia_vid1,params)
    mExoPlayerFullscreen = false
    mFullScreenDialog.dismiss()
    mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen))
}

*/
  /*  override fun onStop() {
        super.onStop()
        if(reproductora!=null)
            reproductora.releasePlayer()

        if(reproductora2!=null)
            reproductora.releasePlayer()

    }

    override fun onPause() {
        super.onPause()
        if(reproductora!=null)
            reproductora.releasePlayer()
        if(reproductora2!=null)
            reproductora2.releasePlayer()
    }*/

    val onscroll =  NestedScrollView.OnScrollChangeListener { scroller, i:Int, j:Int, k:Int, m:Int ->
        if(i> j)
            supportActionBar?.hide()
        else
            supportActionBar?.show()
    }



     class AdapterList(var lista:List<Int>,var actividad: AppCompatActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {

                var vista = LayoutInflater.from(parent!!.context).inflate(R.layout.item_galeria_imagen,parent,false)

                return VH_Img(vista)

        }

        override fun getItemCount(): Int {
            return lista.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {
                if(holder is VH_Img)
                    Glide.with((holder as VH_Img).imagen.context)
                            .load(lista.get(p1)).into(holder.imagen)
          //  (holder as VH_Img).imagen.setImageResource(R.mipmap.bombin)

            holder.itemView.setOnClickListener {
                var intent = Intent(it.context,FullscreenImagenHistoria::class.java)
                intent.putExtra("imagen",p1)
                it.context.startActivity(intent)
                actividad.overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
            }
        }
    }

     class VH_Img(vista:View) : RecyclerView.ViewHolder(vista){
      var imagen = vista.findViewById<ImageView>(R.id.imagen_galeria)
    }





}



//  val mediaPlayer = MediaPlayer.create(this,R.raw.google)
//mediaPlayer.setOnPreparedListener {  }

//mediaPlayer.start()
//Log.d("path",Environment.getRootDirectory().path+"tierno.mp4")
//var media = MediaSession(this,"media")

// var path = assets.list("")
//Log.d("path",path.toString())
//var file = File(assets.toString(),"google.mp4")
//video.setVideoURI(Uri.parse("assets:///google.mp4"))
//video.setMediaController(MediaController(this))
// assets.open(mediaPlayer)  //   AssetManager.ACCESS_STREAMING

/* inner class StackAdapter (var listado:ArrayList<StackItem>) : BaseAdapter(){

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var vista:View
            if(p0==0){
               vista  = LayoutInflater.from(p2!!.context).inflate(R.layout.item_historia,p2,false)
                var imagen = vista.findViewById<ImageView>(R.id.img_historia)
                imagen.setImageResource( listado.get(p0).recurso )
            }
            else{
                vista  = LayoutInflater.from(p2!!.context).inflate(R.layout.item_historia_video,p2,false)
               var video = vista.findViewById<VideoView>(R.id.vid_historia)
                var path = "android.resource://$packageName/${listado.get(p0).recurso}"
                video.setVideoURI(Uri.parse(path))
                //video.setMediaController(MediaController(baseContext))
                                video.start()
            }

                var year =   vista.findViewById<TextView>(R.id.anno)
                year.text = listado.get(p0).mensaje.toString()
                return vista

        }

        override fun getItem(p0: Int): Any {
            return  listado.get(p0)
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
         return listado.size
        }

    }*/