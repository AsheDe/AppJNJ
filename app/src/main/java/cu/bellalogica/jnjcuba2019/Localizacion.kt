package cu.bellalogica.jnjcuba2019

import android.os.Parcel
import android.os.Parcelable
import org.oscim.core.GeoPoint

data class Localizacion(val coordX:Double,val coordY:Double,val recurso:Int, val imagen:Int,val nombre_lugar:String) : Parcelable{

    var punto : GeoPoint
 init {
     punto = GeoPoint(coordX,coordY)
 }



    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeDouble(coordX)
        dest!!.writeDouble(coordY)
        dest!!.writeInt(recurso)
        dest!!.writeInt(imagen)
        dest!!.writeString(nombre_lugar)
    }

    override fun describeContents(): Int {
        return 0
    }


    constructor(parcelable: Parcel) : this(
            parcelable.readDouble()
            ,parcelable.readDouble()
            , parcelable.readInt()
            , parcelable.readInt()
            , parcelable.readString()
    ) {
        punto = GeoPoint(coordX,coordY)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Localizacion> = object : Parcelable.Creator<Localizacion> {
            override fun createFromParcel(`in`: Parcel): Localizacion {
                return Localizacion(`in`)
            }

            override fun newArray(size: Int): Array<Localizacion> {
                return arrayOf<Localizacion>()
            }
        }
    }

}