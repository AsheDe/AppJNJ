package cu.bellalogica.jnjcuba2019

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz
import kotlinx.android.synthetic.main.actividad_ponente.*
import kotlinx.android.synthetic.main.content_actividad_ponente.*

class Actividad_Evento : AppCompatActivity() {



    var cambios=false
    lateinit var evento:Eventos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_ponente)
        setSupportActionBar(toolbar)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var idevento = intent.getIntExtra("evento",1)
        var bd = DB_Interfaz(this)
        evento = bd.ObtenerEventodadoID(idevento)

        supportActionBar?.title = evento.evento

        txt_titulo_evento.text = evento!!.evento
        txt_lugar_evento.text = evento.lugar
        txt_fecha_evento.text = evento.ObtenerFecha()
        Glide.with(this).load(evento.imagen).into(imagen_evento)



        if(evento!!.evento.equals("Tiempo libre"))
        txt_desc_evento.text = "Tiempo libre para recoger equipaje y despedida en las parroquias"

        else if(evento!!.evento.equals("Comida")&& evento!!.lugar.equals("Centros catequéticos escogidos") )
        txt_desc_evento.text = "San Antonio María Claret: \n San Antonio María Claret, Catedral, Trinidad ." +
                " \n\nSanta Teresita: \n" +
                "Santa Teresita, Cristo Rey, María Auxiliadora (Don Bosco) y Santa Lucía"

        else if(evento.evento.equals("Viacrucis"))
            txt_desc_evento.text = " Punto de partida: Santa Teresita. "
        else
            txt_desc_evento.text = ""

        if(evento.recordar==1)
        {
            recordar_evento.text = "NO RECORDAR"
            recordar_evento.supportBackgroundTintList= ColorStateList.valueOf(
                    resources.getColor(R.color.colorBlanco))
            //holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorAccent))
            recordar_evento.setTextColor(resources.getColor(R.color.colorAccent))

        }
        else
        {
            recordar_evento.text = "RECORDAR"

            recordar_evento.supportBackgroundTintList= ColorStateList.valueOf(
                    resources.getColor(R.color.colorAccent))
            //holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorBlanco))
            recordar_evento.setTextColor(resources.getColor(R.color.colorBlanco))
        }

        recordar_evento.setOnClickListener {

            if (evento.recordar == 0) {
                evento.recordar = 1
                recordar_evento.text = "NO RECORDAR"
                recordar_evento.supportBackgroundTintList = ColorStateList.valueOf(
                        resources.getColor(R.color.colorBlanco))

                //   holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorAccent))
                recordar_evento.setTextColor(resources.getColor(R.color.colorAccent))
                Utiles.PonerAlarma(evento,this)
                cambios=!cambios
            } else {
                evento.recordar = 0
                recordar_evento.text = "RECORDAR"
                recordar_evento.supportBackgroundTintList = ColorStateList.valueOf(
                        resources.getColor(R.color.colorAccent))

                //holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorBlanco))
                recordar_evento.setTextColor(resources.getColor(R.color.colorBlanco))
                Utiles.QuitarAlarma(evento,this)
                cambios=!cambios
            }

            bd.CambiarRecordar(evento.id, evento.recordar)


        }
        if(evento.lugar.equals("...") || evento.lugar.equals("Puntos señalizados por centros catequéticos."))
            ver_mapa_evento.visibility = View.INVISIBLE

        ver_mapa_evento.setOnClickListener {
         var inte = Intent(this,Mapa::class.java)
            inte.putExtra("lugar",evento.lugar)
           startActivity(inte)
            overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
        }
    }

    override fun onBackPressed() {
        if(cambios){
            var intent =  Intent(this,Lista_Cronograma::class.java)
            intent.putExtra("date",evento!!.fechainicial.date)
            startActivity( intent)
            overridePendingTransition(R.anim.desplazamiento_lateral,R.anim.desplazamiento_lateral)
        }
        else
            super.onBackPressed()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId==android.R.id.home) {
            if(cambios){
                var intent =  Intent(this,Lista_Cronograma::class.java)
                intent.putExtra("date",evento!!.fechainicial.date)
                startActivity( intent)
                overridePendingTransition(R.anim.desplazamiento_lateral,R.anim.desplazamiento_lateral)
            }
            else
                //NavUtils.navigateUpFromSameTask(this)
                onBackPressed()
        }

        return true
    }
}
