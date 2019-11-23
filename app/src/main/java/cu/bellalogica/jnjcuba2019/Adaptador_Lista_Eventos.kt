package cu.bellalogica.jnjcuba2019

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz


class Adaptador_Lista_Eventos(var lista_eventos : List<Eventos>,
                              var contexto:AppCompatActivity,
                              var recycler:RecyclerView): RecyclerView.Adapter<ViewHolder_Elemento> (){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder_Elemento {
        var inflador = LayoutInflater.from(parent!!.context)
        //             .inflate(R.layout.item_ponente,parent,false)
        //   return ViewHolder_Elemento(TextView(parent!!.context))
        var vista = inflador.inflate(R.layout.item_eventos,parent,false)
        return  View_Holder_Evento(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder_Elemento, position: Int) {
        var evento = lista_eventos.get(position) as Eventos
        (holder as View_Holder_Evento).titulo!!.text = evento.evento
        holder.fecha.text = evento.ObtenerFecha()
        holder.lugar.text = evento.lugar
        Glide.with(contexto).load(evento.imagen).into(holder.imagen)

        if(evento.lugar.equals("...") || evento.lugar.equals("Puntos señalizados por centros catequéticos."))
            holder.ver_mapa.visibility = View.INVISIBLE

        if(evento.recordar==1)
        {
            holder.recordar.text = "NO RECORDAR"
            holder.recordar.supportBackgroundTintList= ColorStateList.valueOf(
                    contexto.resources.getColor(R.color.colorBlanco))
            //holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorAccent))
            holder.recordar.setTextColor(contexto.resources.getColor(R.color.colorAccent))

        }
        else
        {
            holder.recordar.text = "RECORDAR"

            holder.recordar.supportBackgroundTintList= ColorStateList.valueOf(
                    contexto.resources.getColor(R.color.colorAccent))
            //holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorBlanco))
            holder.recordar.setTextColor(contexto.resources.getColor(R.color.colorBlanco))
        }

        holder.recordar.setOnClickListener {

            if(evento.recordar==0)
            {
                lista_eventos.get(position).recordar =1
                holder.recordar.text = "NO RECORDAR"
                holder.recordar.supportBackgroundTintList= ColorStateList.valueOf(
                        contexto.resources.getColor(R.color.colorBlanco))

                //   holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorAccent))
                  holder.recordar.setTextColor(contexto.resources.getColor(R.color.colorAccent))
                Utiles.PonerAlarma(evento,contexto)
            }
            else
            {
                lista_eventos.get(position).recordar=0
                holder.recordar.text = "RECORDAR"
                holder.recordar.supportBackgroundTintList= ColorStateList.valueOf(
                        contexto.resources.getColor(R.color.colorAccent))

                //holder.recordar.setBackgroundColor(contexto.resources.getColor(R.color.colorBlanco))
                holder.recordar.setTextColor(contexto.resources.getColor(R.color.colorBlanco))
                Utiles.QuitarAlarma(evento,contexto)
            }



           var bd = DB_Interfaz (contexto)
            bd.CambiarRecordar(evento.id,
                    lista_eventos.get(position).recordar)

           recycler.adapter!!.notifyDataSetChanged()

        }

        holder.itemView.setOnClickListener{
            val intent = Intent(contexto,Actividad_Evento::class.java)
            intent.putExtra("evento",lista_eventos.get(position).id)
            contexto.startActivity(intent)
        }
        holder.ver_mapa.setOnClickListener {
            var inte = Intent(contexto,Mapa::class.java)
            inte.putExtra("lugar",evento.lugar)
            contexto.startActivity(inte)
            contexto.overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
        }
    }



    override fun getItemCount(): Int {
      return  lista_eventos.size
    }



}