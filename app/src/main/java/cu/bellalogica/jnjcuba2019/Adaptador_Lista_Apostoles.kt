package cu.bellalogica.jnjcuba2019

import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide


class Adaptador_Lista_Apostoles (var lista_apostoles : List<Apostoles>, var contexto:FragmentActivity): RecyclerView.Adapter<ViewHolder_Elemento> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder_Elemento {
       var inflador = LayoutInflater.from(parent!!.context)
       //             .inflate(R.layout.item_ponente,parent,false)
     //   return ViewHolder_Elemento(TextView(parent!!.context))
       return View_Holder_Ponente(inflador.inflate(R.layout.item_ponente,parent,false))

       }




    override fun onBindViewHolder(holder: ViewHolder_Elemento, position: Int) {
            var apostol = lista_apostoles.get(position) as Apostoles
            (holder as View_Holder_Ponente).nombre!!.text = apostol.nombre
            holder.oracion!!.text = apostol.oracion
        Glide.with(contexto).load(apostol.imagen).into(holder.imagen)

            holder.itemView.setOnClickListener {
                ActivityCompat.startActivityForResult(contexto,Intent(contexto,DetalleApostol::class.java).apply {
                    putExtra("apostol",apostol)
                },1,null)
            }

            }



    override fun getItemCount(): Int {
      return  lista_apostoles.size
    }



}