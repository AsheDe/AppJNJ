package cu.bellalogica.jnjcuba2019

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.chip.Chip
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz

class Adaptador_Pager_Principal(fm:FragmentManager,var contexto: Context) : FragmentStatePagerAdapter(fm)
{

    override fun getItem(position: Int): Fragment {

      return when(position) {
          0 -> Fragmento_Lista_Eventos()
          1 -> Fragmento_Lista_Apostoles()
/*          2 -> {
                var bd = DB_Interfaz(contexto)
               var list = bd.ObtenerTodasLocalizaciones()
               var frag =  FragmentoMapa()
              var bdle = Bundle()//.apply { putParcelableArray("puntos",list.toTypedArray()) }
             bdle.putParcelableArrayList("puntos", list )
                       frag!!.arguments = bdle
              return frag
          }*/
          else -> Fragment()
      }

    }

    override fun getCount(): Int {
    return 2
    }


    class Fragmento_Lista_Eventos : Fragment(){





        lateinit var lecturadeldia:TextView
        lateinit var reproductora:Reproductor
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            var vista = LayoutInflater.from(context).inflate(R.layout.fragmento_eventos,container,false)

           var video = vista.findViewById<SimpleExoPlayerView>(R.id.video_monsennor)
           var frg_presentacion = vista.findViewById<ConstraintLayout>(R.id.frg_presentacion)
        //    var path = "android.resource://${container?.context?.packageName}/${R.raw.video_m3}"
            //video.setVideoURI(Uri.parse(path))
            //video.setMediaController(MediaController(container?.context))
            //video.start()
         /*  reproductora =  Reproductor(context!!)
            reproductora.Reproducir(video,R.raw.video_mosennor)

            reproductora.initFullscreenButton(video,frg_presentacion)
*/

           // reproductora.player?.playWhenReady = true

          /*  var video_monsennor = vista.findViewById<ImageView>(R.id.video_monsennor)
            video_monsennor.setOnClickListener {
                var intent = Intent(it.context, Actividad_Reproductor::class.java)
                intent.putExtra("video",2)
                startActivity(intent)
            }*/


            vista.findViewById<ImageView>(R.id.fecha_1_ago).setOnClickListener(vercronogarma)
            vista.findViewById<ImageView>(R.id.fecha_2_ago).setOnClickListener(vercronogarma)
            vista.findViewById<ImageView>(R.id.fecha_3_ago).setOnClickListener(vercronogarma)
            vista.findViewById<ImageView>(R.id.fecha_4_ago).setOnClickListener(vercronogarma)

            return vista


        }

        private var vercronogarma = View.OnClickListener {
            var date = when(it.id){
                R.id.fecha_1_ago -> 1
                R.id.fecha_2_ago -> 2
                R.id.fecha_3_ago -> 3
                else -> 4
            }
          var intent =  Intent(it.context,Lista_Cronograma::class.java)
            intent.putExtra("date",date)
           it.context.startActivity( intent)
            activity?.overridePendingTransition(R.anim.desplazamiento_lateral,R.anim.desplazamiento_lateral)
        }

    /*    private var tabselected = object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                        when(tab.position)
                        {
                            0->{
                                lecturadeldia.visibility = View.GONE
                                textlecturadeldia.visibility = View.GONE
                                liturgia.visibility = View.GONE
                            }
                            1->{
                                lecturadeldia.visibility = View.VISIBLE
                                textlecturadeldia.visibility = View.VISIBLE
                                liturgia.visibility = View.VISIBLE

                                lecturadeldia.text = "LECTURAS 2 DE AGOSTO"
                                textlecturadeldia.text = "Lv 23,1.4-11.15-16.27.34b-37\n" +
                                        "Sal 80,3-4.5-6ab.10-11ab\n" +
                                        "Mt 13,54-58\n"
                                liturgia.setOnClickListener {  }



                            }
                            2->{
                                lecturadeldia.visibility = View.VISIBLE
                                textlecturadeldia.visibility = View.VISIBLE
                                liturgia.visibility = View.VISIBLE


                                lecturadeldia.text = "LECTURAS 3 DE AGOSTO"
                                textlecturadeldia.text = "Qo 1,2;2,21-23\n" +
                                        "Sal 89,2.3-4.5-6.12-13\n" +
                                        "Col 3,1-5.9-11\n" +
                                        "Lc 12,13-21"
                                liturgia.setOnClickListener {  }



                            }
                            3->{
                                lecturadeldia.visibility = View.GONE
                                textlecturadeldia.visibility = View.GONE
                                liturgia.visibility = View.GONE



                            }
                        }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        }*/


        /* inner class MySpanSizeLookUp( var list : ArrayList<Any>) : GridLayoutManager.SpanSizeLookup(){
             override fun getSpanSize(position: Int): Int {
                 if(list.get(position) is Eventos) {
                     return 2
                 }
                 return 1
             }

         }*/





    }


    //////////////////////////////////777


    class Fragmento_Lista_Apostoles : Fragment(){
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            //return super.onCreateView(inflater, container, savedInstanceState)
            var vista= inflater.inflate(R.layout.listado_patrones,null,false)  //RecyclerView(inflater!!.context)
            var recyclerView= vista.findViewById<RecyclerView>(R.id.listpatrones)

            var bd = DB_Interfaz(inflater!!.context)
            var lista_Apostoles = bd.ObtenerApostoles()
            recyclerView.adapter = Adaptador_Lista_Apostoles(lista_Apostoles,activity!!)
            recyclerView.layoutManager = GridLayoutManager(context,context!!.resources.getInteger(R.integer.columnas_apostoles),GridLayoutManager.VERTICAL,false)
            return vista
            //return inflater.inflate(R.layout)

        }

    }
}