package cu.bellalogica.jnjcuba2019

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_eucaristia.*

class Eucaristia : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eucaristia)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        guia_eucaristica.setOnClickListener(this)
        lecturas_viernes.setOnClickListener(this)
        misa_envio.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var intent = Intent(this,VerActividadEucaristia::class.java)
        when(v?.id){
            R.id.guia_eucaristica->intent.putExtra("actividad",0)
            R.id.lecturas_viernes->intent.putExtra("actividad",1)
            R.id.misa_envio->intent.putExtra("actividad",2)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        NavUtils.navigateUpFromSameTask(this)
        return true
    }

}
