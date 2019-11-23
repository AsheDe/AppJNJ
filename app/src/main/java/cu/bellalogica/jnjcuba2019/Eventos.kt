package cu.bellalogica.jnjcuba2019

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Eventos(val id:Int,val evento: String, val lugar: String, val fechainicial : Date,
                   val fechafinal : Date, var recordar:Int,var imagen:Int): Parcelable {
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeInt(id)
        dest!!.writeString(evento)
        dest!!.writeString(lugar)
        dest!!.writeLong(fechainicial.time)
        dest!!.writeLong(fechafinal.time)
        dest!!.writeInt(recordar)
        dest!!.writeInt(imagen)
    }

    constructor(parcelable: Parcel) : this(
            parcelable.readInt()
            ,parcelable.readString()
            ,parcelable.readString()
            , Date(parcelable.readLong())
            , Date(parcelable.readLong())
            , parcelable.readInt()
            , parcelable.readInt()

    ) {

    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Eventos> = object : Parcelable.Creator<Eventos> {
            override fun createFromParcel(`in`: Parcel): Eventos {
                return Eventos(`in`)
            }

            override fun newArray(size: Int): Array<Eventos> {
                return arrayOf<Eventos>()
            }
        }
    }
    override fun describeContents(): Int  = 0

    fun ObtenerFecha():String{
        if(fechainicial.time==fechafinal.time)
            return "${fechainicial.date}/${fechainicial.month} " +
                    "${when(fechainicial.hours){in 13..23 -> fechainicial.hours%12; 0->"12"; else->fechainicial.hours}}:" +
                    "${when(fechainicial.minutes){0->"00";else->fechainicial.minutes}}" +
                    " ${if(fechainicial.hours>=12)"pm" else "am"}"
        else
            return  "${fechainicial.date}/${fechainicial.month} " +
                    "${when(fechainicial.hours){in 13..23 -> fechainicial.hours%12; 0->"12"; else->fechainicial.hours}}:" +
                    "${when(fechainicial.minutes){0->"00";else->fechainicial.minutes}}" +
                    "${if (fechainicial.hours >= 12) "pm" else "am"}  hasta  " +
                    "${when(fechafinal.hours){in 13..23 -> fechafinal.hours%12; 0->"12"; else->fechafinal.hours}}:" +
                    "${when(fechafinal.minutes){0->"00";else->fechafinal.minutes}}" +
                    "${if (fechafinal.hours >= 12) "pm" else "am"}"
    }
}