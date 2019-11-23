package cu.bellalogica.jnjcuba2019

import android.os.Bundle
import android.app.Activity
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_ver_cancion.*

class VerCancion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_cancion)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var cancion = intent.getParcelableExtra<Cancion>("cancion")
        cancion_letra.text = cancion.letra
        cancion_titulo.text = cancion.titulo
        toolbar.title = cancion.titulo

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        NavUtils.navigateUpFromSameTask(this)
        return true
    }
}
