package cu.bellalogica.jnjcuba2019

import android.os.Parcel
import android.os.Parcelable

data class Apostoles(var nombre: String,var oracion: String,var fecha: String,
                     var lugar: String,var fiesta: String,var biografia: String,
                     var recordar: Int,var imagen: Int): Parcelable
{
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeString(nombre)
        dest!!.writeString(oracion)
        dest!!.writeString(fecha)
        dest!!.writeString(lugar)
        dest!!.writeString(fiesta)
        dest!!.writeString(biografia)
        dest!!.writeInt(recordar)
        dest!!.writeInt(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    constructor(parcelable: Parcel) : this(
            parcelable.readString()
            ,parcelable.readString()
            , parcelable.readString()
            , parcelable.readString()
            , parcelable.readString()
            ,parcelable.readString()
            ,parcelable.readInt()
            ,parcelable.readInt()
    ) {

    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Apostoles> = object : Parcelable.Creator<Apostoles> {
            override fun createFromParcel(`in`: Parcel): Apostoles {
                return Apostoles(`in`)
            }

            override fun newArray(size: Int): Array<Apostoles> {
                return arrayOf<Apostoles>()
            }
        }
    }


}