package cu.bellalogica.jnjcuba2019

import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View


import kotlinx.android.synthetic.main.activity_examen.*

class Examen : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        examen_dios.setOnClickListener(this)
        examen_familia.setOnClickListener(this)
        examen_amigos.setOnClickListener(this)
        examen_trabajo.setOnClickListener(this)
        examen_diversion.setOnClickListener(this)
        examen_tu.setOnClickListener(this)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        NavUtils.navigateUpFromSameTask(this)
        return true
    }

    override fun onClick(v: View?) {

        var titulo =""
        var mensaje =""
        when(v?.id){
            R.id.examen_dios->{
                titulo = "Con Dios"
                mensaje = resources.getString(R.string.examen_dios)
            }
            R.id.examen_familia->{
                titulo = "Tu familia"
                mensaje =resources.getString(R.string.examen_familia)
            }
            R.id.examen_amigos->{
                titulo = "Tus amigos/as"
                mensaje =resources.getString(R.string.examen_amigos)
            }
            R.id.examen_trabajo->{
                titulo = "Tu trabajo/estudio"
                mensaje=resources.getString(R.string.examen_trabajo)
            }
            R.id.examen_diversion->{
                titulo = "Tu diversión/consumo"
                mensaje=resources.getString(R.string.examen_diversion)
            }R.id.examen_tu->{
                titulo = "Tú mismo"
                mensaje=resources.getString(R.string.examen_tu)
            }
        }

        var builder = AlertDialog.Builder(this)
        builder.setPositiveButton("ACEPTAR",DialogInterface.OnClickListener { dialog,
                                                                         which ->
            dialog.dismiss()
        })
        builder.setMessage(mensaje)
        builder.setTitle(titulo)
        builder.create().show()
    }
}
