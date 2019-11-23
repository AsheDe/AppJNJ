package cu.bellalogica.jnjcuba2019

import android.os.Bundle

import android.content.Context
import android.content.Intent
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz

import kotlinx.android.synthetic.main.activity_canto.*

class Canto : AppCompatActivity() {

    lateinit var actividad:AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canto)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actividad =this
        var lista_canciones = DB_Interfaz(this).ObtenerCanciones()
        var adapter = Adaptador_Canciones(lista_canciones,this)
        lista_cantoral.adapter = adapter
        lista_cantoral.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
       NavUtils.navigateUpFromSameTask(this)
        return true
    }


    internal class Adaptador_Canciones(var lista_canciones:List<Cancion>, var actividad:AppCompatActivity) : RecyclerView.Adapter<View_Holder_Cancion>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): View_Holder_Cancion {
            var vista = LayoutInflater.from(p0.context).inflate(R.layout.item_cantoral,p0,false)
            return View_Holder_Cancion(vista)
        }

        override fun getItemCount(): Int  = lista_canciones.size

        override fun onBindViewHolder(holder: View_Holder_Cancion, posicion: Int) {
            val cancion= lista_canciones.get(posicion)
            holder.titulo_cancion.text = cancion.titulo
            holder.itemView.setOnClickListener {
                var intent = Intent(it.context,VerCancion::class.java)
                intent.putExtra("cancion",cancion)
                it.context.startActivity(intent)
                actividad.overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
            }
        }
    }

}
