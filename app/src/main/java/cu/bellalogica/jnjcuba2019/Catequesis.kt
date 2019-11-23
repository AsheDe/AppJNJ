package cu.bellalogica.jnjcuba2019

import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View


import kotlinx.android.synthetic.main.activity_catequesis.*

class Catequesis : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catequesis)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        catequesis1.setOnClickListener(this)
        catequesis2.setOnClickListener(this)
        catequesis3.setOnClickListener(this)
        catequesis5.setOnClickListener(this)
        catequesis6.setOnClickListener(this)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        NavUtils.navigateUpFromSameTask(this)
        return true
    }

    override fun onClick(v: View?) {

        var titulo =""
        var mensaje =""
        when(v?.id){
            R.id.catequesis1->{
                titulo = "Isaías 65,17-25"
                mensaje = resources.getString(R.string.catequesis_t1)
            }
            R.id.catequesis2->{
                titulo = "Deuteronomio 15, 4.5-11."
                mensaje =resources.getString(R.string.catequesis_t2)
            }
            R.id.catequesis3->{
                titulo = "Jeremías 34,8-16"
                mensaje =resources.getString(R.string.catequesis_t3)
            }
            R.id.catequesis5->{
                titulo = "Hechos 4, 33.34-35"
                mensaje=resources.getString(R.string.catequesis_t5)
            }R.id.catequesis6->{
                titulo = "Para profundizar"
                mensaje=resources.getString(R.string.catequesis_t6)
            }
        }

        var builder = AlertDialog.Builder(this)
        builder.setPositiveButton("VOLVER",DialogInterface.OnClickListener { dialog,
                                                                         which ->
            dialog.dismiss()
        })

        builder.setMessage(mensaje)
        builder.setTitle(titulo)
        builder.create().show()
    }
}
