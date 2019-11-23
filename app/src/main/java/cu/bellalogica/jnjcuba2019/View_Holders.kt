package cu.bellalogica.jnjcuba2019

import android.support.design.button.MaterialButton
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView


open class ViewHolder_Elemento (var vista: View) : RecyclerView.ViewHolder(vista)
class View_Holder_Ponente(var vista1: View): ViewHolder_Elemento(vista1)
{

        var nombre = vista1.findViewById(R.id.txt_nombre_ponente) as TextView
        var oracion = vista1.findViewById(R.id.txt_oracion) as TextView
        var imagen = vista1.findViewById<ImageView>(R.id.apostol_imagen) as ImageView

}
class View_Holder_Evento(var vista2: View): ViewHolder_Elemento(vista2)
{
    val titulo: TextView = vista2.findViewById(R.id.txt_titulo_evento) as TextView
    val imagen: ImageView = vista2.findViewById(R.id.img_evento) as ImageView
    val fecha: TextView = vista2.findViewById(R.id.txt_fecha_evento) as TextView
    val lugar: TextView = vista2.findViewById(R.id.txt_lugar_evento) as TextView
    val ver_mapa = vista2.findViewById<FloatingActionButton>(R.id.ver_mapa_evento)
    val recordar = vista2.findViewById<MaterialButton>(R.id.recordar_evento)
}
class View_Holder_Actividad(var vista3: View): ViewHolder_Elemento(vista3) {

}

class View_Holder_Cancion(var myview: View): ViewHolder_Elemento(myview) {
    var titulo_cancion: TextView = myview.findViewById(R.id.titulo_cancion) as TextView
}

class VH_Contacto(var vista:View): RecyclerView.ViewHolder(vista){}
