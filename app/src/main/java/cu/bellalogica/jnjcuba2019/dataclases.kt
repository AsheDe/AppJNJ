package cu.bellalogica.jnjcuba2019

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Ponente(val nombre: String,val nick : String, val descripcion : String)
data class Actividad(val nombre:String)
data class Contacto(val nombre:String,val cargo:String,val telefono:String)


data class Cancion(var titulo: String,var letra:String):Parcelable{

    constructor(parcelable: Parcel) : this(
            parcelable.readString()
            ,parcelable.readString()){}

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeString(titulo)
        dest!!.writeString(letra)
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Cancion> = object : Parcelable.Creator<Cancion> {
            override fun createFromParcel(`in`: Parcel): Cancion {
                return Cancion(`in`)
            }

            override fun newArray(size: Int): Array<Cancion> {
                return arrayOf<Cancion>()
            }
        }
    }
}

data class Lectura(var dia:Int,var momento:Int,var texto:String)