package cu.bellalogica.jnjcuba2019

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detalle_patrono.*

class DetalleApostol : AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home )
        {
            startActivity( Intent(this,Principal::class.java).apply { putExtra("mover",1) })
            overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
        }
        return true
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_patrono)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //supportActionBar!!.setBackgroundDrawable(resources.getDrawable(android.R.color.transparent))
       var patron = intent.getParcelableExtra<Apostoles>("apostol")
        Glide.with(this).load(patron.imagen).into(imagen_apostol)
        patron_nombre.text =" ${patron.nombre} "
        supportActionBar!!.setTitle(patron.nombre)
        patron_oracion.text ="Oración: ${patron.oracion}"
        patron_fecha.text ="Fecha: ${patron.fecha}"
        patron_fiesta.text ="Fiesta: ${patron.fiesta}"
        patron_lugar.text ="Lugar de nacimiento: ${patron.lugar}"
        patron_biografia.text ="Biografía: ${patron.biografia}"
    }
}
