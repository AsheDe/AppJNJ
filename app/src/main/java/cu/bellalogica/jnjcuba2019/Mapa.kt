package cu.bellalogica.jnjcuba2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.Window
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz
import kotlinx.android.synthetic.main.activity_mapa.*

class Mapa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_mapa)

        var bd = DB_Interfaz(this)
        var lugar = intent.getStringExtra("lugar")
        var list:ArrayList<Localizacion> = ArrayList()
        if(lugar.equals("Centros catequéticos"))
        {
            list = bd.ObtenerLocalizacionCentroCatequeticos()
        }
        else if(lugar.equals("Centros catequéticos escogidos"))
        {
          //  list.add( bd.ObtenerLocalizacionDadoLugar("Cristo de la Salud")!!)
            list.add( bd.ObtenerLocalizacionDadoLugar("Santa Teresita")!!)
            list.add( bd.ObtenerLocalizacionDadoLugar("San Antonio María Claret ")!!)
           // list.add( bd.ObtenerLocalizacionDadoLugar("María Auxiliadora (Don Bosco)")!!)
           // list.add( bd.ObtenerLocalizacionDadoLugar("Nuestra Señora de los desamparados")!!)

        }
        else if(lugar.equals("Atrio de la Santa Basílica Metropolitana Iglesia Catedral de Santiago de Cuba."))
        {
            list.add( bd.ObtenerLocalizacionDadoLugar("Atrio de la Santa Basílica Metropolitana Iglesia Catedral de Santiago de Cuba.")!!)
            list.add( bd.ObtenerLocalizacionDadoLugar("Cristo de la Salud")!!)
            list.add( bd.ObtenerLocalizacionDadoLugar("Santa Teresita")!!)
            list.add( bd.ObtenerLocalizacionDadoLugar("María Auxiliadora (Don Bosco)")!!)

        }
        else
            list.add( bd.ObtenerLocalizacionDadoLugar(lugar)!!)
        var frag =  FragmentoMapa()
        var bdle = Bundle()//.apply { putParcelableArray("puntos",list.toTypedArray()) }
        bdle.putParcelableArrayList("puntos", list )
        frag!!.arguments = bdle

        supportFragmentManager.beginTransaction().replace(R.id.fragmento_map,frag).commit()


    }
}
