package cu.bellalogica.jnjcuba2019.BaseDatos

import android.content.ContentValues
import android.content.Context
import android.util.Log
import cu.bellalogica.jnjcuba2019.*
import org.oscim.core.GeoPoint
import java.util.*
import kotlin.collections.ArrayList

class DB_Interfaz(var contexto: Context) {
     var basedatos:DB_Manager

        init {
            basedatos = DB_Manager(contexto, "JNJCuba2019", null, 1)

        }

    fun ObtenerApostoles() : List<Apostoles>{
        var bd = basedatos.writableDatabase
        var apostoles= ArrayList<Apostoles>()
        var cursor = bd.rawQuery("SELECT * FROM APOSTOLES",null)
        if(cursor.moveToFirst())
        {

            do {
                var nombre = cursor.getString(0)
                var oracion = cursor.getString(1)
                var fecha = cursor.getString(2)
                var lugar = cursor.getString(3)
                var fiesta = cursor.getString(4)
                var biografia = cursor.getString(5)
                var recordar = cursor.getInt(6)
                var imagen = cursor.getInt(7)
                apostoles.add(Apostoles(nombre, oracion, fecha, lugar, fiesta, biografia,recordar,imagen))
            }while (cursor.moveToNext())
        }

        bd.close()
        return apostoles
    }

    fun ObtenerCanciones() : List<Cancion>{
        var bd = basedatos.writableDatabase
        var canciones= ArrayList<Cancion>()
        var cursor = bd.rawQuery("SELECT * FROM CANTORAL",null)
        if(cursor.moveToFirst())
        {

            do {
                var titulo = cursor.getString(0)
                var letra = cursor.getString(1)
                canciones.add(Cancion(titulo, letra))
            }while (cursor.moveToNext())
        }

        bd.close()
        return canciones
    }

    fun ObtenerContactos(asesor:Int) : List<Contacto>{
        var bd = basedatos.writableDatabase
        var contactos= ArrayList<Contacto>()
        var cursor = bd.rawQuery("SELECT * FROM CONTACTOS WHERE asesor==$asesor",null)
        if(cursor.moveToFirst())
        {

            do {
                var nombre = cursor.getString(0)
                var cargo = cursor.getString(1)
                var telefono = cursor.getString(2)
                contactos.add(Contacto(nombre, cargo,telefono))
            }while (cursor.moveToNext())
        }

        bd.close()
        return contactos
    }

    fun ObtenerEventos(date : Int) : List<Eventos>{
        var bd = basedatos.writableDatabase
        var eventos= ArrayList<Eventos>()
        var cursor = bd.rawQuery("SELECT * FROM CRONOGRAMA WHERE dia==$date",null)
        if(cursor.moveToFirst())
        {

            do {
                var id = cursor.getInt(0)
                var evento = cursor.getString(1)
                var lugar = cursor.getString(2)
                var fi = cursor.getLong(3)
                var ff = cursor.getLong(4)
                var recordar = cursor.getInt(5)
                var image = cursor.getInt(7)
                eventos.add(Eventos(id,evento,lugar, Date(fi) ,Date(ff),recordar,image))
            }while (cursor.moveToNext())
        }

        bd.close()
        return eventos
    }

    fun ObtenerRecordados() : List<Eventos>{
        var bd = basedatos.writableDatabase
        var eventos= ArrayList<Eventos>()
        var cursor = bd.rawQuery("SELECT * FROM CRONOGRAMA WHERE recordar==1",null)
        if(cursor.moveToFirst())
        {

            do {
                var id = cursor.getInt(0)
                var evento = cursor.getString(1)
                var lugar = cursor.getString(2)
                var fi = cursor.getLong(3)
                var ff = cursor.getLong(4)
                var recordar = cursor.getInt(5)
                var image = cursor.getInt(7)

                eventos.add(Eventos(id,evento,lugar, Date(fi) ,Date(ff),recordar,image))
            }while (cursor.moveToNext())
        }

        bd.close()
        return eventos
    }


    fun ObtenerEventodadoID(id : Int) : Eventos{
        var bd = basedatos.writableDatabase

        var cursor = bd.rawQuery("SELECT * FROM CRONOGRAMA WHERE id==$id",null)
        if(cursor.moveToFirst())
        {

                var id = cursor.getInt(0)
                var evento = cursor.getString(1)
                var lugar = cursor.getString(2)
                var fi = cursor.getLong(3)
                var ff = cursor.getLong(4)
                var recordar = cursor.getInt(5)
                var image = cursor.getInt(7)
            bd.close()
                return Eventos(id,evento,lugar, Date(fi) ,Date(ff),recordar,image)

        }


        return Eventos(1,"Inauguracion","Plaza Ferreiro", Date() ,Date(),0,R.mipmap.catedralstgo)
    }


    fun ObtenerLecturas(dia : Int,momento:Int) : Lectura{
        var bd = basedatos.writableDatabase
        var cursor = bd.rawQuery("SELECT * FROM LECTURAS WHERE dia==$dia AND momento==$momento",null)
        if(cursor.moveToFirst())
        {

                var dia = cursor.getInt(0)
                var momento = cursor.getInt(1)
                var texto = cursor.getString(2)
            bd.close()
            return Lectura(dia,momento,texto)
        }
        return Lectura(1,1,"Lectura diaria")
    }

    fun CambiarRecordar(id:Int,value:Int)
    {

        var bd = basedatos.writableDatabase
        var cv = ContentValues()
        cv.put("recordar",value)
        bd.update("CRONOGRAMA",cv,"id==$id",null)
        bd.close()
    }

    fun ObtenerLocalizacionDadoLugar(luga : String) : Localizacion?{
        var bd = basedatos.writableDatabase

        var cursor = bd.rawQuery("SELECT * FROM LOCALIZACIONES WHERE lugar=='$luga'",null)
        if(cursor.moveToFirst())
        {

            var coordX = cursor.getDouble(0)
            var coordY = cursor.getDouble(1)
            var recurso = cursor.getInt(2)
            var imagen = cursor.getInt(3)

            bd.close()
            return Localizacion(coordX,coordY,recurso,imagen,luga)

        }


        return null
    }

    fun ObtenerLocalizacionCentroCatequeticos() : ArrayList<Localizacion>{

        var bd = basedatos.writableDatabase
        var list = ArrayList<Localizacion>()
        var cursor = bd.rawQuery("SELECT * FROM LOCALIZACIONES WHERE cq==1",null)
        if(cursor.moveToFirst())
        {
            do{
                var coordX = cursor.getDouble(0)
                var coordY = cursor.getDouble(1)
                var recurso = cursor.getInt(2)
                var imagen = cursor.getInt(3)
                var lugar = cursor.getString(4)
                list.add(Localizacion(coordX,coordY,recurso,imagen,lugar))
            }while (cursor.moveToNext())
        }
        bd.close()
        return list

    }

    fun ObtenerLocalizacionViacrucis() : ArrayList<Localizacion>{

        var bd = basedatos.writableDatabase
        var list = ArrayList<Localizacion>()
        var cursor = bd.rawQuery("SELECT * FROM LOCALIZACIONES WHERE viacrucis==1",null)
        if(cursor.moveToFirst())
        {

            var coordX = cursor.getDouble(0)
            var coordY = cursor.getDouble(1)
            var recurso = cursor.getInt(2)
            var imagen = cursor.getInt(3)
            var lugar = cursor.getString(4)

            bd.close()
            list.add(Localizacion(coordX,coordY,recurso,imagen,lugar))

        }

        return list

    }

    fun ObtenerTodasLocalizaciones() :ArrayList<Localizacion> {
        var bd = basedatos.writableDatabase
        var listado = ArrayList<Localizacion>()
        var cursor = bd.rawQuery("SELECT * FROM LOCALIZACIONES",null)
        if(cursor.moveToFirst())
        {
            do{
                var coordX = cursor.getDouble(0)
                var coordY = cursor.getDouble(1)
                var recurso = cursor.getInt(2)
                var imagen = cursor.getInt(3)
                var lugar = cursor.getString(4)
             var l =   Localizacion(coordX,coordY,recurso,imagen,lugar)
                listado.add(l)
            }
            while (cursor.moveToNext())
        }
        bd.close()
        return listado
    }

}