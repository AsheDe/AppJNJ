package cu.bellalogica.jnjcuba2019

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_ver_actividad_eucaristia.*

class VerActividadEucaristia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mostrar = intent.getIntExtra("actividad",0)
        var subtitilo = ""

       var layoout = when(mostrar){
            0->{
                 subtitilo ="VIVE LA EUCARISTÍA"
                R.layout.activity_ver_actividad_eucaristia
            }
            1->{
                subtitilo ="Viernes 2 de AGO"
                R.layout.activity_ver_actividad_eucaristiaviernes
            }
            else->{
                subtitilo ="MISA DE ENVÍO"
                R.layout.activity_ver_actividad_eucaristiamisaenvio
            }

        }

        setContentView(layoout)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setSubtitle(subtitilo)

   /*     var fragmen = Fragmento()
        var bdl = Bundle()
        bdl.putInt("frag",mostrar)
        fragmen.arguments = bdl
         when(mostrar){
            0->{
                toolbar.setSubtitle("VIVE LA EUCARISTÍA")

            }
            1->{
                toolbar.setSubtitle("Viernes 2 de AGO")

            }
            else->{
                toolbar.setSubtitle("MISA DE ENVÍO")

            }

        }
      // var frg = Fragment()
//        frg.layoutInflater.inflate(texto,null,false)
        supportFragmentManager.beginTransaction().replace(texto_eucaristia.id,fragmen)*/
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        NavUtils.navigateUpFromSameTask(this)
        return true
    }

    class Fragmento : Fragment(){

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return when(arguments?.getInt("frag")) {
              0->  inflater.inflate(R.layout.include_vive_laeucaristia,container,false)
              1->  inflater.inflate(R.layout.include_vive_laeucaristia,container,false)
              else->  inflater.inflate(R.layout.include_vive_laeucaristia,container,false)
            }
        }
    }
}
