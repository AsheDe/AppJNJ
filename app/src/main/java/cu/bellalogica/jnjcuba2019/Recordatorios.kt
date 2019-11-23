package cu.bellalogica.jnjcuba2019

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz


import kotlinx.android.synthetic.main.activity_recordatorios.*

class Recordatorios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordatorios)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar!!.setBackgroundDrawable(resources.getDrawable(R.color.colorPrimaryDark))
        var bd = DB_Interfaz(this)
        var list = bd.ObtenerRecordados()

        var recycler_eventos = findViewById(R.id.recycler_eventos) as RecyclerView
        recycler_eventos.adapter = Adaptador_Lista_Eventos(list,this,recycler_eventos)
        recycler_eventos.layoutManager = StaggeredGridLayoutManager(resources.getInteger(
                R.integer.columnas_calendario), StaggeredGridLayoutManager.VERTICAL)

    }

}
