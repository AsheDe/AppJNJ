package cu.bellalogica.jnjcuba2019

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.NavUtils
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.content_oracion__viacrucis.*

class Oracion_Viacrucis : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_oracion__viacrucis)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        estacion_1.setOnClickListener(this)
        estacion_2.setOnClickListener(this)
        estacion_3.setOnClickListener(this)
        estacion_4.setOnClickListener(this)
        estacion_5.setOnClickListener(this)
        estacion_6.setOnClickListener(this)
        estacion_7.setOnClickListener(this)
        estacion_8.setOnClickListener(this)
        estacion_9.setOnClickListener(this)
        estacion_10.setOnClickListener(this)
        estacion_11.setOnClickListener(this)
        estacion_12.setOnClickListener(this)
        estacion_13.setOnClickListener(this)
        estacion_14.setOnClickListener(this)
        estacion_15.setOnClickListener(this)
        estacion_oracionfinal.setOnClickListener(this)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        NavUtils.navigateUpFromSameTask(this)
        return true
    }

    override fun onClick(v: View?) {

        var titulo =""
        var mensaje =""
        when(v?.id){
            R.id.estacion_1->{
                titulo = "Estación I"
                mensaje = resources.getString(R.string.estaciones_viacrucis_1)
            }

            R.id.estacion_2->{
                titulo = "Estación II"
                mensaje = resources.getString(R.string.estaciones_viacrucis_2)
            }

            R.id.estacion_3->{
                titulo = "Estación III"
                mensaje = resources.getString(R.string.estaciones_viacrucis_3)
            }

            R.id.estacion_4->{
                titulo = "Estación IV"
                mensaje = resources.getString(R.string.estaciones_viacrucis_4)
            }

            R.id.estacion_5->{
                titulo = "Estación V"
                mensaje = resources.getString(R.string.estaciones_viacrucis_5)
            }

            R.id.estacion_6->{
                titulo = "Estación VI"
                mensaje = resources.getString(R.string.estaciones_viacrucis_6)
            }

            R.id.estacion_7->{
                titulo = "Estación VII"
                mensaje = resources.getString(R.string.estaciones_viacrucis_7)
            }

            R.id.estacion_8->{
                titulo = "Estación VIII"
                mensaje = resources.getString(R.string.estaciones_viacrucis_8)
            }

            R.id.estacion_9->{
                titulo = "Estación IX"
                mensaje = resources.getString(R.string.estaciones_viacrucis_9)
            }

            R.id.estacion_10->{
                titulo = "Estación X"
                mensaje = resources.getString(R.string.estaciones_viacrucis_10)
            }

            R.id.estacion_11->{
                titulo = "Estación XI"
                mensaje = resources.getString(R.string.estaciones_viacrucis_11)
            }

            R.id.estacion_12->{
                titulo = "Estación XII"
                mensaje = resources.getString(R.string.estaciones_viacrucis_12)
            }

            R.id.estacion_13->{
                titulo = "Estación XIII"
                mensaje = resources.getString(R.string.estaciones_viacrucis_13)
            }

            R.id.estacion_14->{
                titulo = "Estación XIV"
                mensaje = resources.getString(R.string.estaciones_viacrucis_14)
            }

            R.id.estacion_15->{
                titulo = "Estación XV"
                mensaje = resources.getString(R.string.estaciones_viacrucis_15)
            }

            R.id.estacion_oracionfinal->{
                titulo = "ORACIÓN FINAL"
                mensaje = resources.getString(R.string.estaciones_viacrucis_oracion_final)
            }


        }

        var builder = AlertDialog.Builder(this)
        builder.setPositiveButton("ACEPTAR", DialogInterface.OnClickListener { dialog,
                                                                               which ->
            dialog.dismiss()
        })
        builder.setMessage(mensaje)
        builder.setTitle(titulo)
        builder.create().show()
    }

}
