package cu.bellalogica.jnjcuba2019

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz
import kotlinx.android.synthetic.main.activity_lista__cronograma.*
import java.util.*

class Lista_Cronograma : AppCompatActivity(), View.OnClickListener {

    var date = 1
    //var lectura = listOf<Lectura>()
   lateinit var bd:DB_Interfaz
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista__cronograma)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setBackgroundDrawable(resources.getDrawable(R.color.colorPrimaryDark))
        date = intent.getIntExtra("date",1)
        bd = DB_Interfaz(this)
        var list = bd.ObtenerEventos(date)

        var diasem = when(date){
            1->"JUEVES"
            2->"VIERNES"
            3->"SÁBADO"
            else->"DOMINGO"
        }

        supportActionBar!!.subtitle = "$diasem $date de AGOSTO 2019"


        var recycler_eventos = findViewById(R.id.recycler_eventos) as RecyclerView
        recycler_eventos.adapter = Adaptador_Lista_Eventos(list,this,recycler_eventos)
        recycler_eventos.layoutManager = StaggeredGridLayoutManager(resources.getInteger(
                R.integer.columnas_calendario),StaggeredGridLayoutManager.VERTICAL)

        when(date)
        {
            1->{
                vernoche.visibility = View.VISIBLE
                vernoche.setOnClickListener(this)
            }
            2->{
                vermorning.visibility = View.VISIBLE
                vermorning.setOnClickListener(this)
                vernoche.visibility = View.VISIBLE
                vernoche.setOnClickListener(this)
            }
            3->{
                vermorning.visibility = View.VISIBLE
                vermorning.setOnClickListener(this)
                vernoche.visibility = View.VISIBLE
                vernoche.setOnClickListener(this)
            }
            4->{
                vermorning.visibility = View.VISIBLE
                vermorning.setOnClickListener(this)

            }
        }


    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.vermorning->AbrirDialogo(1)
            R.id.vernoche->AbrirDialogo(2)
        }
    }

    fun AbrirDialogo(number:Int)
    {
        var altdialg = AlertDialog.Builder(this)
        var lectura = bd.ObtenerLecturas(date,number)
        altdialg.setMessage(lectura.texto)
        altdialg.create().show()
    }

    override fun onBackPressed() {
      /*  var intent =  Intent(this,Principal::class.java)
        startActivity( intent)
        overridePendingTransition(R.anim.desplazamiento_lateral,R.anim.desplazamiento_lateral)*/
        NavUtils.navigateUpFromSameTask(this)
    }
/* lecturadeldia = vista.findViewById<TextView>(R.id.lecturadeldia)
        textlecturadeldia = vista.findViewById<TextView>(R.id.textlecturadeldia)
        liturgia = vista.findViewById<Chip>(R.id.verliturgia)

        var tabs = vista.findViewById<TabLayout>(R.id.tabs)
        tabs.addOnTabSelectedListener(tabselected)
        var recycler_eventos = vista.findViewById<View>(R.id.recycler_eventos) as RecyclerView
        recycler_eventos.adapter = Adaptador_Lista_Eventos(list,context!!)
        recycler_eventos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
*/

    /*fun CrearListaEventos() : ArrayList<Eventos>
    {
        var listado = arrayListOf<Eventos>(
                Eventos("Evento#1", GregorianCalendar(1987,12,7),"plaza san marcos"),
                Eventos("Evento#2", GregorianCalendar(1987,12,7),"baticano"),
                Eventos("Evento#3", GregorianCalendar(1987,12,7),"baticano"),
                Eventos("Evento#4", GregorianCalendar(1987,12,7),"baticano"),
                Eventos("Evento#1", GregorianCalendar(1987,12,7),"plaza san marcos"),
                Eventos("Evento#2", GregorianCalendar(1987,12,7),"baticano"),
                Eventos("Evento#3", GregorianCalendar(1987,12,7),"baticano")
        )
        return listado
    }*/
}
