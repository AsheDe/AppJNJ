package cu.bellalogica.jnjcuba2019.BaseDatos

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import cu.bellalogica.jnjcuba2019.R
import java.util.*

class DB_Manager(var context: Context, name:String , factory:SQLiteDatabase.CursorFactory? , version:Int)
    : SQLiteOpenHelper(context,name,factory, version) {

    var crear_tabla_apostoles = "CREATE TABLE APOSTOLES (nombre TEXT,oracion TEXT,fecha TEXT,lugar TEXT,fiesta TEXT,biografia TEXT, recordar INTEGER, imagen INTEGER)"
    var crear_tabla_cantoral = "CREATE TABLE CANTORAL (titulo TEXT,letra TEXT)"
    var crear_tabla_contactos = "CREATE TABLE CONTACTOS (nombre TEXT,cargo TEXT,telefono TEXT,asesor INTEGER)"
    var crear_tabla_cronograma = "CREATE TABLE CRONOGRAMA (id INTEGER,evento TEXT,lugar TEXT,fechainicial DATE,fechafinal DATE,recordar INTEGER,dia INTEGER,imagen INTEGER)"
    var crear_tabla_lecturas = "CREATE TABLE LECTURAS (dia INTEGER,momento INTEGER,texto TEXT)"
    var crear_tabla_localizaciones = "CREATE TABLE LOCALIZACIONES (coordX DOUBLE,coordY DOUBLE,recurso INTEGER, imagen INTEGER,lugar TEXT, cq INTEGER,viacrucis INTEGER)"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("DROP TABLE IF EXISTS 'APOSTOLES'")
        db!!.execSQL("DROP TABLE IF EXISTS 'CANTORAL'")
        db!!.execSQL("DROP TABLE IF EXISTS 'CONTACTOS'")
        db!!.execSQL("DROP TABLE IF EXISTS 'CRONOGRAMA'")
        db!!.execSQL("DROP TABLE IF EXISTS 'LECTURAS'")
        db!!.execSQL("DROP TABLE IF EXISTS 'LOCALIZACIONES'")
        db!!.execSQL(crear_tabla_apostoles)
        db!!.execSQL(crear_tabla_cantoral)
        db!!.execSQL(crear_tabla_contactos)
        db!!.execSQL(crear_tabla_cronograma)
        db!!.execSQL(crear_tabla_lecturas)
        db!!.execSQL(crear_tabla_localizaciones)

        InsertarCronograma(db)
        InsertarApostoles(db)
        InsertarCantoral(db)
        InsertarContactos(db)
        InsertarLecturas(db)
        InsertarLocaciones(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS 'APOSTOLES'")
        db!!.execSQL("DROP TABLE IF EXISTS 'CANTORAL'")
        db!!.execSQL("DROP TABLE IF EXISTS 'CONTACTOS'")
        db!!.execSQL("DROP TABLE IF EXISTS 'CRONOGRAMA'")
        db!!.execSQL("DROP TABLE IF EXISTS 'LECTURAS'")
        db!!.execSQL("DROP TABLE IF EXISTS 'LOCALIZACIONES'")
        db!!.execSQL(crear_tabla_apostoles)
        db!!.execSQL(crear_tabla_cantoral)
        db!!.execSQL(crear_tabla_contactos)
        db!!.execSQL(crear_tabla_cronograma)
        db!!.execSQL(crear_tabla_lecturas)
        db!!.execSQL(crear_tabla_localizaciones)

        InsertarCronograma(db)
        InsertarApostoles(db)
        InsertarCantoral(db)
        InsertarContactos(db)
        InsertarLecturas(db)
        InsertarLocaciones(db)
    }





    fun InsertarLocaciones(database: SQLiteDatabase?) {

        var cv = ContentValues()
       /* cv.put("coordX", 20.0241)
        cv.put("coordY", -75.80899)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.mipmap.res_mapa)
        cv.put("lugar","Plaza Juvenil de Ferreiro")
        cv.put("cq",0)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)*/

        cv.put("coordX", 20.02096)
        cv.put("coordY", -75.82961)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Santa Basílica Metropolitana Iglesia Catedral de Santiago de Cuba.")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.02369)
        cv.put("coordY",-75.82258)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Arzobispado.")
        cv.put("cq",0)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)


        cv.put("coordX", 20.02116)
        cv.put("coordY", -75.82937)
        cv.put("recurso", R.drawable.cruz_azul)
        cv.put("imagen", R.drawable.cruz_azul)
        cv.put("lugar","Atrio de la Santa Basílica Metropolitana Iglesia Catedral de Santiago de Cuba.")
        cv.put("cq",0)
        cv.put("viacrucis",1)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.01533)
        cv.put("coordY", -75.83718)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","María Auxiliadora (Don Bosco)")
        cv.put("cq",1)
        cv.put("viacrucis",1)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.02285)
        cv.put("coordY", -75.81556)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Santa Teresita")
        cv.put("cq",1)
        cv.put("viacrucis",1)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.02395)
        cv.put("coordY", -75.83049)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Parroquia San Francisco de Asís")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.03863)
        cv.put("coordY", -75.84192)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Cristo Rey")
        cv.put("cq",1)
        cv.put("viacrucis",1)
        database!!.insert("LOCALIZACIONES",null,cv)

       /* cv.put("coordX", 20.02914)
        cv.put("coordY", -75.83137)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Cristo de la Salud")
        cv.put("cq",0)
        cv.put("viacrucis",1)
        database!!.insert("LOCALIZACIONES",null,cv)*/



       /* cv.put("coordX", 20.0166331)
        cv.put("coordY", -75.8348842)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Nuestra Señora de los desamparados")
        cv.put("cq",0)
        cv.put("viacrucis",1)  /// aqui es la comida del dia del viacrucis
        database!!.insert("LOCALIZACIONES",null,cv)
*/

        cv.put("coordX", 20.01985)
        cv.put("coordY", -75.8277)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Santa Lucía")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.02563)
        cv.put("coordY",-75.82632)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Santísima Trinidad")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

     /*   cv.put("coordX", 20.0262)
        cv.put("coordY",-75.82944)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Santo Tomás")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)
*/
      /*  cv.put("coordX", 20.16851)
        cv.put("coordY", -75.64741)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Purísima Concepción, La Maya  ")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)*/

       /* cv.put("coordX", 20.21155)
        cv.put("coordY", -75.99621)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Nuestra Señora del Rosario, Palma Soriano    ")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)
*/
      /*  cv.put("coordX", 20.18716)
        cv.put("coordY", -75.85067)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","San Joaquín, San Luis   ")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)
*/
        cv.put("coordX", 20.02859)
        cv.put("coordY", -75.80387)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Sagrada Familia")
        cv.put("cq",0)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

       /* cv.put("coordX", 20.30915)
        cv.put("coordY", -76.33604)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","San Bartolomé, Baire  ")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.30065)
        cv.put("coordY", -76.24222)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Sagrada Familia, Contramaestre ")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)
*/

        cv.put("coordX", 20.02868)
        cv.put("coordY", -75.81847)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","San Antonio María Claret ")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)
/*

        cv.put("coordX", 20.00978)
        cv.put("coordY", -75.76771)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","San José Obrero. Edificio 28 apto 4, Micro 2. (Yeni 58564550) ")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)
*/

        cv.put("coordX", 20.06047)
        cv.put("coordY", -75.93755)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.mipmap.res_mapa)
        cv.put("lugar","Melgarejo, Cobre, Santiago de Cuba")
        cv.put("cq",0)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)


        cv.put("coordX", 20.05069)
        cv.put("coordY", -75.94903)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Santuario Nacional de Nuestra Señora de la Caridad del Cobre")
        cv.put("cq",1)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)


        cv.put("coordX", 20.05153)
        cv.put("coordY", -75.95122)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.drawable.cruz)
        cv.put("lugar","Parque del Cobre")
        cv.put("cq",0)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

        cv.put("coordX", 20.04985)
        cv.put("coordY", -75.94978)
        cv.put("recurso", R.mipmap.res_mapa)
        cv.put("imagen", R.mipmap.res_mapa)
        cv.put("lugar","Parqueo del Santuario Nacional de Nuestra Señora de la Caridad del Cobre")
        cv.put("cq",0)
        cv.put("viacrucis",0)
        database!!.insert("LOCALIZACIONES",null,cv)

    }





    fun InsertarContactos(database: SQLiteDatabase?)
    {
        var cv = ContentValues()
        cv.put("nombre","P. Eduardo Redondo ")
        cv.put("cargo","Asesor de Pastoral Juvenil")
        cv.put("telefono","54808644")
        cv.put("asesor",1)
        database!!.insert("CONTACTOS",null,cv)

        cv.put("nombre","Sandra Mancía")
        cv.put("cargo","RMI Asesora de Pastoral Juvenil  ")
        cv.put("telefono","55339531")
        cv.put("asesor",1)
        database!!.insert("CONTACTOS",null,cv)

        cv.put("nombre","Susana González ")
        cv.put("cargo","Secretaria de Pastoral Juvenil")
        cv.put("telefono","52468440")
        cv.put("asesor",0)
        database!!.insert("CONTACTOS",null,cv)

        cv.put("nombre","P. Leandro Hiung  ")
        cv.put("cargo","Responsable Comisión Logística.")
        cv.put("telefono","58146096")
        cv.put("asesor",1)
        database!!.insert("CONTACTOS",null,cv)

        cv.put("nombre","Rosario Vázquez ")
        cv.put("cargo","Comunicadora")
        cv.put("telefono","58553988")
        cv.put("asesor",0)
        database!!.insert("CONTACTOS",null,cv)

        cv.put("nombre","Victoria Villareal")
        cv.put("cargo","Asesora")
        cv.put("telefono","52744558")
        cv.put("asesor",0)
        database!!.insert("CONTACTOS",null,cv)

        cv.put("nombre","Yelian Castillo")
        cv.put("cargo","Animador Diocesano")
        cv.put("telefono","55328080")
        cv.put("asesor",0)
        database!!.insert("CONTACTOS",null,cv)

        cv.put("nombre","P. Carlos Fernández")
        cv.put("cargo","Asesor de Pastoral Juvenil")
        cv.put("telefono","56849368")
        cv.put("asesor",0)
        database!!.insert("CONTACTOS",null,cv)
    }

    fun InsertarCronograma(database: SQLiteDatabase?)
    {
        var id=1
        var cv = ContentValues()
        cv.put("recordar",0)
        cv.put("dia",1)

        cv.put("id",id++)
        cv.put("evento","Capilla de adoración al Santísimo.")
        cv.put("lugar","Arzobispado.")
        var fi = GregorianCalendar(2019,8,1,8,30)
        cv.put("fechainicial",fi.timeInMillis)
        var ff = GregorianCalendar(2019,8,1,17,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.capilla_de_adoracion)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Acreditación y recibimiento")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,1,14,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,1,18,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.logohorizontal)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Inauguración")
        cv.put("lugar","Santa Basílica Metropolitana Iglesia Catedral de Santiago de Cuba.")
        fi = GregorianCalendar(2019,8,1,20,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,1,20,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.inauguracion)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("dia",2)


        cv.put("id",id++)
        cv.put("evento","Desayuno")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,2,7,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,8,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.desayunomerienda)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Capilla de adoración al Santísimo.")
        cv.put("lugar","Arzobispado.")
        fi = GregorianCalendar(2019,8,2,8,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,17,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.capilla_de_adoracion)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Eucaristía")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,2,8,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,9,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.eucaristiaviernesmannana)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Misión")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,2,9,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,13,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.foto12)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Cristoferia")
        cv.put("lugar","Parroquia San Francisco de Asís")
        fi = GregorianCalendar(2019,8,2,14,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,17,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.feria_vocacional_expocarisma)
        database!!.insert("CRONOGRAMA",null,cv)

      /*  cv.put("id",id++)
        cv.put("evento","Feria Vocacional: -Fiesta de la Reconciliación y Adoración.")
        cv.put("lugar","Santa Basílica Metropolitana Iglesia Catedral de Santiago de Cuba.")
        fi = GregorianCalendar(2019,8,2,14,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,17,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.feria_vocacional_fiestareconciliacion)
        database!!.insert("CRONOGRAMA",null,cv)
*/
        cv.put("id",id++)
        cv.put("evento","Comida")
        cv.put("lugar","Centros catequéticos escogidos")
        fi = GregorianCalendar(2019,8,2,18,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,19,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.almurzoycomida)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Viacrucis")
        cv.put("lugar","Atrio de la Santa Basílica Metropolitana Iglesia Catedral de Santiago de Cuba.")
        fi = GregorianCalendar(2019,8,2,19,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,2,19,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.viacrucis)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("dia",3)

        cv.put("id",id++)
        cv.put("evento","Desayuno")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,3,7,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,8,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.desayunomerienda)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Capilla de adoración al Santísimo.")
        cv.put("lugar","Arzobispado.")
        fi = GregorianCalendar(2019,8,3,8,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,17,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.capilla_de_adoracion)
        database!!.insert("CRONOGRAMA",null,cv)


        cv.put("id",id++)
        cv.put("evento","Oración")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,3,8,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,9,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.oracion)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Catequesis ")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,3,9,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,12,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.catequsis)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Almuerzo ")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,3,12,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,13,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.almurzoycomida)
        database!!.insert("CRONOGRAMA",null,cv)


        cv.put("id",id++)
        cv.put("evento","Tiempo libre")
        cv.put("lugar","...")
        fi = GregorianCalendar(2019,8,3,13,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,17,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.logohorizontal)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Comida")
        cv.put("lugar","Centros catequéticos")
        fi = GregorianCalendar(2019,8,3,17,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,17,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.almurzoycomida)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Santo Rosario")
        cv.put("lugar","Parque del Cobre")
        fi = GregorianCalendar(2019,8,3,19,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,19,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.santorosariosabado)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Adoración Eucarística")
        cv.put("lugar","Santuario Nacional de Nuestra Señora de la Caridad del Cobre")
        fi = GregorianCalendar(2019,8,3,22,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,3,22,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.adoracioneucaristicasabadodespuesdelrosario)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("dia",4)

        cv.put("id",id++)
        cv.put("evento","Eucaristía de Envío")
        cv.put("lugar","Santuario Nacional de Nuestra Señora de la Caridad del Cobre")
        fi = GregorianCalendar(2019,8,4,0,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,4,0,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.eucaristiadomingo)
        database!!.insert("CRONOGRAMA",null,cv)


        cv.put("id",id++)
        cv.put("evento","Merienda")
        cv.put("lugar","Puntos señalizados por centros catequéticos.")
        fi = GregorianCalendar(2019,8,4,2,0)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,4,2,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.desayunomerienda)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Vigilia")
        cv.put("lugar","Parqueo del Santuario Nacional de Nuestra Señora de la Caridad del Cobre")
        fi = GregorianCalendar(2019,8,4,2,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,4,5,30)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.vigiliamadrugadadomingo)
        database!!.insert("CRONOGRAMA",null,cv)

        cv.put("id",id++)
        cv.put("evento","Capilla de adoración al Santísimo.")
        cv.put("lugar","Arzobispado.")
        fi = GregorianCalendar(2019,8,4,8,30)
        cv.put("fechainicial",fi.timeInMillis)
        ff = GregorianCalendar(2019,8,4,17,0)
        cv.put("fechafinal",ff.timeInMillis)
        cv.put("imagen",R.mipmap.capilla_de_adoracion)
        database!!.insert("CRONOGRAMA",null,cv)



    }

    fun InsertarApostoles(database: SQLiteDatabase?)
    {
        var cv = ContentValues()

        cv.put("recordar",0)

        cv.put("nombre","Nuestra Señora de la Caridad del Cobre.")
        cv.put("oracion","Madre de Jesús y Madre nuestra, los jóvenes cubanos solicitamos tu eterna intercesión, para encontrarnos con Tu Hijo y responder con un solícito SÍ a todos los hágase de nuestras vidas, tal como lo hiciste al decir: “He aquí la sierva del Señor, hágase en mí según tu palabra”. Nuestra Señora de la Caridad del Cobre, ¡Ruega por nosotros!")
        cv.put("fecha","Patrona de Cuba")
        cv.put("lugar","")
        cv.put("fiesta","8 de septiembre")
        cv.put("biografia","La Virgen María de la Caridad acompaña la historia y la vida del pueblo cubano desde hace más de 400 años. Su imagen fue hallada por los tres Juanes, en 1612, en las aguas de la Bahía de Nipe. Fue proclamada como Patrona de Cuba por el papa Benedicto XV el10 de mayo de 1916 ante la petición de los veteranos de la Guerra de la Independencia a su Santidad. Durante la visita de San Juan Pablo II en 1998 a Cuba, coronó y bendijo la imagen de Nuestra Señora durante la tercera misa que ofició en el país, celebrada en la ciudad de Santiago de Cuba el 24 de enero de 1998. En septiembre de 2015, durante la visita pastoral del Papa Francisco a Cuba, y con motivo de la conmemoración de los 100 años de la consagración de Cuba a la Virgen de la Caridad, decretó el Año Santo Excepcional de la Misericordia y le regaló en su Santuario un ramo de flores de plata, los cuales descansan a los pies de la Virgen. Los santiagueros guardamos con devoción y orgullo la imagen de la Caridad en su Santuario en el poblado del Cobre, allí acuden miles de peregrinos a pedir su intercesión.")
        cv.put("imagen",R.mipmap.apostol3)
        database!!.insert("APOSTOLES",null,cv)

        cv.put("nombre","San Antonio María Claret")
        cv.put("oracion","Jesús, llámanos a salir y a comprometernos con nuestra realidad, que el llamado misionero sea atendido por cada joven cubano en nuestra Patria y en el mundo. San Antonio María Claret, ¡Ruega por nosotros!")
        cv.put("fecha","1807 - 1870")
        cv.put("lugar","España")
        cv.put("fiesta","24 de octubre ")
        cv.put("biografia","Nació en Barcelona y las palabras del Evangelio: \"¿De qué le vale al hombre ganar todo el mundo si pierde su alma?\", motivaron su vocación y con 21 años ingresó al seminario. Con 41 años fundó la Congregación de Misioneros Hijos del Inmaculado Corazón de María (Claretianos). Un año después, fue nombrado Arzobispo de Santiago de Cuba y aquí dedicó seis años a la misión. Trabajó incansablemente, sembrando el amor y la justicia y renovó todos los aspectos de la vida de la iglesia. En el año 1855 fundó en esta ciudad el Instituto de Religiosas de María Inmaculada, junto a la Madre María Antonia París; llamadas misioneras claretianas.  Fundó escuelas, asilos, visitó cuatro veces todas las ciudades, pueblos y rancherías de su diócesis, ya fuera a pie o a caballo. Regresó a España y participó en el Concilio Vaticano I.")
        cv.put("imagen",R.mipmap.apostol1)
        database.insert("APOSTOLES",null,cv)

        cv.put("nombre","San Juan Pablo II")
        cv.put("oracion","Jesús, que los jóvenes cubanos sepamos responder a tu llamado concreto en nuestro país y sepamos construir juntos la sociedad nueva, donde sumemos y no descartemos. San Juan Pablo II, ¡Ruega por nosotros!")
        cv.put("fecha","1920 – 2005")
        cv.put("lugar","Polonia")
        cv.put("fiesta","22 de octubre")
        cv.put("biografia","Fue el papa número 264 de la Iglesia Católica desde el 16 de octubre de 1978 hasta su muerte en 2005. Él tenía un mensaje especial para los jóvenes y después del Jubileo de la Redención, en 1984 instituyó las Jornadas Mundiales de la Juventud, de las cuales es patrón. Marcó también la historia de la Iglesia en Cuba, al ser el primer pontífice en visitar nuestra Patria en enero de 1998. En su encuentro con los jóvenes, en la ciudad de Camagüey, les dijo: “Queridos jóvenes, sean creyentes o no, acojan el llamado a ser virtuosos. Ello quiere decir que sean fuertes por dentro, grandes de alma, ricos en los mejores sentimientos, valientes en la verdad, audaces en la libertad, constantes en la responsabilidad, generosos en el amor, invencibles en la esperanza. La felicidad se alcanza desde el sacrificio. No busquen fuera lo que pueden encontrar dentro. No esperen de los otros lo que ustedes son capaces y están llamados a ser y a hacer. No dejen para mañana el construir una sociedad nueva, donde los sueños más nobles no se frustren y donde ustedes puedan ser los protagonistas de su historia.” Fue canonizado por el Papa Francisco, el Domingo de la Divina Misericordia, en 2014.")
        cv.put("imagen",R.mipmap.apostol6)
        database.insert("APOSTOLES",null,cv)


        cv.put("nombre","Beata Dolores Sopeña")
        cv.put("oracion","Jesús, intercede por las vocaciones de los jóvenes cubanos, para que sepamos responderte y servirte en todo y en todos. Beata Dolores Sopeña, ¡Ruega por nosotros!")
        cv.put("fecha","1848 - 1918")
        cv.put("lugar","España")
        cv.put("fiesta","10 de enero")
        cv.put("biografia","Nació en una familia de clase social media alta y desde muy joven descubrió su vocación: ayudar a los que más la necesitaban. Siempre estuvo motivada por su profunda fe cristiana que anhelaba transmitir y compartir. Se mudó a Santiago de Cuba por asuntos familiares y aquí visitaba a los enfermos en el hospital militar. Comenzó a trabajar en los barrios periféricos y fundó los Centros de Instrucción, donde enseñaba cultura general, el catecismo y prestaba asistencia médica a la población más pobre. Volvió a España en 1877 y continuó su misión solidaria y evangelizadora. En 1902 fundó una institución civil que hoy lleva su nombre: Fundación Dolores Sopeña.")
        cv.put("imagen",R.mipmap.apostol4)
        database.insert("APOSTOLES",null,cv)

        cv.put("nombre","Beato José López Piteira")
        cv.put("oracion","Jesús, intercede por todos los perseguidos y enjuiciados cubanos, que la fortaleza de aceptar Tu voluntad les de paz. Beato José López Piteira, ¡Ruega por nosotros!")
        cv.put("fecha","1912 - 1936")
        cv.put("lugar","Cuba")
        cv.put("fiesta","6 de noviembre")
        cv.put("biografia","Nació en Jatibonico, Cuba y volvió a España con su familia cuando todavía era pequeño. Se le conoció como joven de carácter entusiasta y observante, bondadoso y tratable, a quien le gustaba estudiar y le aficionaba la música.  Con solo 16 años comenzó el noviciado en el convento de la Orden de San Agustín y en el 1935, lo ordenaron diácono. En 1936, se desató una cruenta persecución antirreligiosa en gran parte de España y la numerosa comunidad del convento donde vivía Piteira quedó prisionera. Podía valerse de su condición de ciudadano cubano para quedar en libertad, sin embargo, dijo: “Están aquí todos ustedes que han sido mis educadores, mis maestros y mis superiores, ¿qué voy a hacer yo en la ciudad? Prefiero seguir la suerte de todos, y que sea lo que Dios quiera...”\n" +
                "Fueron juzgados y condenados por su simple condición de religiosos, dejando admirados a los propios verdugos que les mataron por su valor y fortalezas cristianas. \n")
        cv.put("imagen",R.mipmap.apostol2)
        database.insert("APOSTOLES",null,cv)



        cv.put("nombre","Venerable P. Félix Varela")
        cv.put("oracion","Jesús, tú que conoces el sufrimiento de tantas familias separadas en nuestra patria, por tu bondad, haz que el amor a tu Iglesia y a nuestra Patria nos mantenga unidos. Venerable Padre Félix Varela, ¡Ruega por nosotros! ")
        cv.put("fecha","1788 - 1853")
        cv.put("lugar","Cuba")
        cv.put("fiesta","")
        cv.put("biografia","Nació en La Habana y ha trascendido en nuestra historia como sacerdote, maestro, escritor, filósofo y político. Fue formador de destacados hombres de su época, uno de ellos, José de la Luz y Caballero, refiriéndose al Padre Varela dijo: “Mientras se piense en Cuba, se pensará con respeto y veneración en aquel que nos enseñó a pensar”. Tan solo con 23 años fue ordenado sacerdote, vocación a la que se sintió llamado desde la temprana adolescencia. Vivió en el exilio muchos años de su vida, debido a su posición política en contra del Reino de España. A pesar de la distancia geográfica, dedicó los últimos años de su vida a trabajar en pos de ver su tierra libre de cualquier sufrimiento, fundó escuelas, edificó iglesias y defendió la fe católica ante le predominio del protestantismo. Entre sus obras más importantes, se encuentran las Cartas a Elpidio, donde legó uno de los más hermosos mensajes que guarda la juventud cubana: “Diles que ellos son la dulce esperanza de la patria, y que no hay patria sin virtud, ni virtud con impiedad”. ")
        cv.put("imagen",R.mipmap.apostol5)
        database.insert("APOSTOLES",null,cv)





        //Ready()
    }

    fun InsertarCantoral(database: SQLiteDatabase?)
    {


        var cv = ContentValues()

        cv.put("titulo","Himno de la JNJ")
        cv.put("letra","Somos peregrinos\n" +
                "Que venimos hoy aquí\n" +
                "Desde continentes y ciudades\n" +
                "Queremos ser misioneros del Señor,\n" +
                "Llevar su palabra y su mensaje.\n" +
                "Ser como María la que un día dijo sí\n" +
                "Ante la llamada de tu proyecto,\n" +
                "El cielo se goza y canta de alegría\n" +
                "Toda la tierra alaba tus portentos.\n" +
                "\n" +
                "Coro:\n" +
                "He aquí la sierva del Señor\n" +
                "Hágase en mí según tu palabra (bis)\n" +
                "Tu sierva yo soy\n" +
                "Tu hija yo soy\n" +
                "Tu hijo yo soy.\n" +
                "\n" +
                "Ser como María\n" +
                "Disponibles a salir\n" +
                "Iglesia peregrina con amor\n" +
                "Jóvenes testigos y discípulos\n" +
                "Con alegría, fe y vocación.\n" +
                "\n" +
                "Coro\n" +
                "\n" +
                "No tengan miedo; no,\n" +
                "No tengan miedo\n" +
                "De llevar el amor de Dios\n" +
                "Comprometidos sí, como María\n" +
                "Que supo ser la sierva del Señor.\n" +
                "\n" +
                "Coro (3 veces)\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","Venimos con María ")
        cv.put("letra","1.-Venimos con María a dar gracias, Señor, por todas esas cosas que nos da tu amor: (Bis)alegrías y tristezas, el cantar y el dolor, venidos de tus manos, asidos a tus manos, y en tus manos, Señor.\n" +
                "\n" +
                "María, faro de luz. María, puerta de Dios. Eres fuente de amor y de esperanza, tierra de Dios eres tú.\n" +
                "\n" +
                "2.-En ti encarnó, María, la Palabra de Dios, por ti nos vino Cristo, que es la luz y verdad; (Bis)el Espíritu Divino a ti sombra te dio y Madre de la Iglesia te aclaman los cristianos, Madre de la Caridad.\n" +
                "\n" +
                "3.-El pueblo hoy reunido, todo pueblo de Dios, maracas, claves, güiros cantan con devoción (bis)\n" +
                "A esa madre morenita, virgencita de amor, madre de los cubanos, que todos veneramos con todo el corazón.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","A los pies de la Virgen ")
        cv.put("letra","A los pies de la Virgen traigo mis penas, mis plegarias, mis sueños, mi vida entera. Ruega por nosotros, santa Madre de Dios, para ser dignos de las promesas del Señor.\n" +
                "\n" +
                "1.-Dios te salve, Reina y Madre de misericordia, vida, dulzura y esperanza nuestra, Dios te salve, a ti clamamos los desterrados hijos de Eva, a ti suspiramos gimiendo y llorando en este valle de lágrimas.\n" +
                "\n" +
                "2.-Ea, pues, Señora, abogada nuestra, vuelve a nosotros tus ojos misericordiosos, Dios te salve, y después de este destierro muéstranos tú el fruto de tu vientre, Jesús.\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","Señor ten piedad")
        cv.put("letra","Señor, ten piedad. Señor, ten piedad,\n" +
                "ten piedad de nosotros, ten piedad. \n" +
                "\n" +
                "Cristo, ten piedad. Cristo, ten piedad, ten piedad de nosotros, ten piedad. \n" +
                "\n" +
                "Señor, ten piedad. Señor, ten piedad, ten piedad de nosotros, ten piedad.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","Gloria")
        cv.put("letra","Gloria, Gloria a Dios en el cielo y en la tierra, paz a los hombres que ama el Señor/\n" +
                "\n" +
                "Por tu inmensa gloria te alabamos, glorificamos, te bendecimos y te adoramos, ///te damos gracias Señor///\n" +
                "/Gloria…/\n" +
                "\n" +
                "Señor, Dios Rey Celestial, Dios Padre Todopoderoso, Jesucristo, único Hijo, Cordero de Dios, Hijo del Padre.\n" +
                "/Gloria…/\n" +
                "\n" +
                "/Tú que quitas el pecado del mundo, ten piedad de nosotros/ Nuestra súplica atiende. Tú que estás sentado a la diestra, ten piedad de nosotros.\n" +
                "/Gloria…/\n" +
                "\n" +
                "Porque Tú sólo eres Santo. Sólo Tú, Señor Jesucristo, con el Espíritu en la gloria /de Dios Padre amén/\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","¡Aleluya!  ")
        cv.put("letra","Aleluya. Aleluya. Aleluya/\n" +
                "/Mi corazón de alegría y de júbilo rebosa, porque el Todopoderoso por mí ha hecho grandes cosas/.\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Aleluya\n" +
                "\n" +
                "Aleluya, aleluya, aleluya, aleluya. (Bis)\n" +
                "Gloria a ti, Señor, Aleluya, Gloria a ti, Señor, Señor.\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","Pan y vino serán tu Cuerpo y tu Sangre")
        cv.put("letra","Este pan, fruto de la tierra, que nos das, Señor, en el trabajo por tu bondad, por tu bondad, será tu pan, será tu Cuerpo.\n" +
                "\n" +
                "Pan y vino serán tu Cuerpo y Sangre, memorial del sacrificio que nos salva. Acepta con ellos nuestra pequeñez y transforma con tu gracia nuestras vidas.\n" +
                "\n" +
                "2.-Este vino, fruto de la vid que tus manos nos regala cada día, por tu bondad, por tu bondad, ¡oh Señor! será tu Sangre. Pan y vino serán tu Cuerpo y Sangre.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","Santo")
        cv.put("letra","Santo, Santo, Santo es el Señor Dios del Universo, llenos están el cielo y la tierra, de tu gloria Señor.\n" +
                "Hosanna, Hosanna, Hosanna en el cielo. (Bis)\n" +
                "Bendito el que viene en nombre del Señor. \n" +
                "Hosanna, Hosanna, Hosanna en el cielo. (Bis)\n")

        database!!.insert("CANTORAL",null,cv)


        cv.put("titulo","Cordero")
        cv.put("letra","Cordero de Dios, que quitas el pecado del mundo, ten piedad de nosotros, y danos la paz. (3 veces)")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Qué bien")
        cv.put("letra","1.-Más cálido que el sol de la mañana, más dulce que la miel de los panales, más fresco que el olor a hierba nueva, más tierno que la luna y más hermoso.\n" +
                "\n" +
                "Qué bien, todos unidos a tu mesa, qué suave compartir con los hermanos; es como ungüento fino que resbala, incienso que se eleva a tu presencia.\n" +
                "\n" +
                "2.-Un solo pueblo, una sola familia, que sabe comprenderse mutuamente, que tiene una esperanza que la anima, que vive del amor y amando vive.\n" +
                "\n" +
                "3.-Las ramas de este árbol siempre joven, los miembros de Jesús resucitado, un signo de tu amor hacia los hombres, un sacramento vivo que es tu Cuerpo.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Cena Pascual")
        cv.put("letra","1.-Manos honradas de carpintero, manos benditas de buen pastor, manos que parten su pan con todos, con el amigo, con el traidor. \n" +
                "\n" +
                "Manos que alzan su copa al mundo, ofrecen vino y en él se dan, y día a día, la historia vuelve, brindando eterna Cena Pascual.\n" +
                "\n" +
                "“Éste es mi Cuerpo, ésta es mi Sangre, y en mi memoria siempre lo harán.” Su despedida es una entrega\n" +
                "con un sentido de eternidad. \n" +
                "\n" +
                "Momento cumbre de aquel que vino trayendo al mundo su eterna luz. Ya no hay tinieblas, las dudas mueren, camino y vida, eso es Jesús.\n" +
                "\n" +
                "2.-El mundo es Cena donde se sienta aquel que lucha brindando amor, aquel que sabe lo que es hermano, sin egoísmo y sin rencor, pero la historia de aquel día vuelve y en ella vemos al vil traidor quien a su amigo entrega por miedo, por acomodo, por ambición. \n" +
                "\n" +
                "3.-Para que se amen los he llamado, que tengan vida es mi voluntad, en un abrazo vivan unidos, que esta es la Cena de la hermandad. \n" +
                "Alcen la copa hasta el fin del tiempo, partan el pan, repartan amor. Soy el Cordero que por ustedes en sacrificio hoy se entregó.\n" +
                "\n" +
                "4.-Que el que posee dé al que no tiene, que aquel que es grande aprenda a servir, que el más pequeño sea el primero, de los que acuden a este festín.\n" +
                "\n" +
                "Lavar los pies, cual signo fraterno, unos a otros habrán de hacer, comer mi Cuerpo, beber mi Sangre, que en mis hermanos me quedaré.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Pescador de hombres")
        cv.put("letra","1.-Tú has venido a la orilla, no has buscado ni a sabios ni a ricos, tan sólo quieres que yo te siga.\n" +
                "\n" +
                "Señor, me has mirado a los ojos, sonriendo has dicho mi nombre. En la arena he dejado mi barca, junto a ti buscaré otro mar.\n" +
                "\n" +
                "2.-Tú sabes bien lo que tengo, en mi barca no hay oro ni espadas, tan sólo redes y mi trabajo.\n" +
                "\n" +
                "3.-Tú necesitas mis manos, mi cansancio que a otros descanse, amor que quiera seguir amando.\n" +
                "\n" +
                "4.-Tú, pescador de otros lagos, ansia eterna de almas que esperan, amigo bueno que así me llamas.\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Reina en el corazón ")
        cv.put("letra","Reina en el corazón, reina en al corazón, reina en el corazón del pueblo cubano. \n" +
                "Siembra siempre el amor, siembra siempre el amor, siembra siempre el amor, Madre del pueblo, siembra el amor.\n" +
                "\n" +
                "1.-Porque el amado y la amada se juran fidelidad, más cuesta mucho la forja, la forja de la unidad.\n" +
                "\n" +
                "2.-Para que el niño en la escuela, en la calle y en su hogar respeto y paso a las canas nunca deje de otorgar.\n" +
                "\n" +
                "3.-Porque hay quien estando solo\n" +
                "y enfermo, en su soledad necesita quien le extienda su mano con caridad.\n" +
                "\n" +
                "4.-Para que el que aspire a nubes y quiera subir, subir, no aplaste al que más abajo tenga que pagar sufrir.\n" +
                "\n" +
                "5.-Porque cuando digo: “hermano, hermano de corazón”, hay que serlo en todo tiempo, en buena y mala ocasión.\n" +
                "\n" +
                "6.-Para que el que diga: “amigo, amigo, contigo estoy”, se muestre siempre dispuesto, que vaya y no diga: “voy”.\n" +
                "\n" +
                "7.-Porque si alguno se alegra, su gozo compartirá con amigos y enemigos, con este y el que está allá.\n" +
                "8.-Para que nunca se apaguen la ternura y la verdad, para que todos vivamos en paz y con dignidad.\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Piedad")
        cv.put("letra","///Señor ten piedad de nosotros///\n" +
                "///Cristo ten piedad de nosotros///\n" +
                "///Señor ten piedad de nosotros\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Gloria a Dios en el cielo")
        cv.put("letra","/Gloria, Gloria a Dios en el cielo y en la tierra, paz a los hombres que ama el Señor/\n" +
                "\n" +
                "Por tu inmensa gloria te alabamos, glorificamos, te bendecimos y te adoramos, ///te damos gracias Señor///\n" +
                "/Gloria…/\n" +
                "\n" +
                "Señor, Dios Rey Celestial, Dios Padre Todopoderoso, Jesucristo, único Hijo, Cordero de Dios, Hijo del Padre.\n" +
                "/Gloria…/\n" +
                "\n" +
                "/Tú que quitas el pecado del mundo, ten piedad de nosotros/ Nuestra súplica atiende. Tú que estás sentado a la diestra, ten piedad de nosotros.\n" +
                "/Gloria…/\n" +
                "\n" +
                "Porque Tú sólo eres Santo. Sólo Tú, Señor Jesucristo, con el Espíritu en la gloria /de Dios Padre amén/\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Canta aleluya al Señor ")
        cv.put("letra","Canta aleluya al Señor. Canta aleluya al Señor. Canta aleluya, canta aleluya, canta aleluya al Señor. ")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Tu amor es lo más hermoso")
        cv.put("letra","Tu amor es lo más hermoso de mi vida, Señor. Tu amor es lo más hermoso de mi vida, Señor.\n" +
                "\n" +
                "1.-En el altar donde te ofreces,\n" +
                "Señor, pon mis miedos, pon mis ansias, Señor. Miedo no a mis pequeñeces, Señor, es temor de tu abundancia, porque:\n" +
                "\n" +
                "2.-En el altar donde te inmolas, Señor, pon mis gozos y alegrías, Señor, pon mis sombras y dolores, Señor, día a día de mi vida, porque:\n" +
                "\n" +
                "3.-En el altar donde te inmolas, Señor, pon mi vida como ofrenda, Señor; tú la inundas por entero, Señor, la engrandeces por completo, porque:\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Santo")
        cv.put("letra","Santo, Santo, Santo es el Señor, es el Señor, es el Señor.\n" +
                "Llenos están cielos y tierra de tu gloria, llenos están.\n" +
                "Hosanna en las alturas, bendito es el que viene, en nombre, en nombre del Señor. \n" +
                "Hosanna, hosanna, bendito es el que viene. Hosanna, hosanna, en nombre del Señor.\n")

        database!!.insert("CANTORAL",null,cv)

        cv.put("titulo","Eres tú, Jesús")
        cv.put("letra","Eres tú, Jesús, eres tú. Eres tú en un trozo de pan y en un poco de vino.\n" +
                "\n" +
                "1.-¡Qué alegría encontrarte, Jesús, en tu vino y tu pan! ¡Oh Señor, qué consuelo saber que me amas! Eres tú la palabra de Dios, la eterna palabra de Dios, y has querido venir a morar en mi pecho.\n" +
                "\n" +
                "2.-Eres tú, oh principio y fin, manantial de la vida; eres tú, Luz de Luz, Dios de Dios verdadero; eres tú ¡oh milagro de amor! ¡oh eterno milagro de amor! eres tú, mi Señor y mi Dios, mi alimento.\n" +
                "\n" +
                "3.-Cuánto amor al nacer en Belén de María la Virgen, al andar los caminos del hombre, y llamarle tu amigo.\n" +
                "¡Oh Cordero de Dios, cuánto amor, cuánto amor al morir en la cruz! ¡Cuánto amor al querer compartir tu victoria!\n" +
                "\n" +
                "4.-Sólo en ti, oh Señor, hay amor que comprende y perdona, sólo en ti, oh Jesús, hay amor verdadero.\n" +
                "\n" +
                "¡Oh Jesús, quiero amar como tú! ¡Quiero amar hasta el fin como tú! Oh Señor, dale vida a mi amor con tu vida.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Felicidad (B) Salmo 83")
        cv.put("letra","Felicidad de vivir en tu casa y de alabarte por toda la vida/.\n" +
                "\n" +
                "1.-Qué bueno es estar en tu casa, Aleluya. Padre mío y Dios mío, Aleluya, cuánto anhela mi alma, Aleluya, y qué ardiente desea, Aleluya, habitar en tu templo, Aleluya, todo me alegro en ti, Señor.\n" +
                "\n" +
                "2.-Su nido hallan todas las aves, Aleluya, donde poner polluelos, Aleluya; también las golondrinas, Aleluya. Yo encontré en tus altares, Aleluya, el lugar de mi dicha, Aleluya, yo te he encontrado a ti, mi Dios. \n" +
                "\n" +
                "3.-Dichoso el hombre que en ti pone, Aleluya, toda su fortaleza, Aleluya, y que compasión quiere, Aleluya, caminar por sendas, Aleluya, yendo por los desiertos, Aleluya, lluvias y fresco siempre hallará.\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Virgen Mambisa ")
        cv.put("letra","1.-Madre, que en la tierra cubana riegas desde lo alto tu amor, Madre del pobre y del que sufre, Madre de alegría y dolor.\n" +
                "\n" +
                "Todos tus hijos, a ti clamamos, Virgen Mambisa, que seamos hermanos. (Bis)\n" +
                "\n" +
                "2.-Madre, que en tus campos sembraste flores de paz y comprensión, dale la unidad a tu pueblo, siembra amorosa la unión.\n" +
                "\n" +
                "3.-Madre, que el sudor de tus hijos te ofrezca su trabajo creador, Madre, que el amor a mi tierra nazca del amor a mi Dios.\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Acéptalo")
        cv.put("letra","1. Yo que no tengo más que tu alegría, yo que no tengo más que tu esperanza, vengo con mi canción y mi guitarra, a ofrecerte mi vida ante tu altar. Perdona la pobreza de mi ofrenda, perdona si no supe amar mejor; tú conoces mis pasos y mis obras, tú sabes que no tengo nada más. \n" +
                "Acéptalo, es lo que tengo, acéptalo, Señor del cielo, acéptalo igual que el mar, acepta el ancho caudal del río y del arroyo débil, pequeño, que entre las piedras cantando va.\n" +
                "\n2. La oscura flor que cultivé en mi alma, la traigo, Padre mío a tu presencia, nació de tu semilla y mi pobreza; perdóname si no es bella, Señor. Yo quiero unirla en un solo ramo, junto a la de mis hermanos que aquí están, y su tenue color hará más lindas las flores que te traigan los demás. \n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Una luz en la oscuridad")
        cv.put("letra","Una luz en la oscuridad, un arroyo de agua viva,\n" +
                "Un cantar a la esperanza, quiere ser tu Iglesia,\n" +
                "Quiere ser tus manos, quiere ser tu voz,\n" +
                "Quiere ser tu imagen.\n" +
                "\n" +
                "1.\tManos pobres de Cristo, duras y secas, llenas de gracia. Manos solidarias en la miseria, que compartan la tristeza y la alegría de vivir. Manos de amor y de paz, manos de hombre y de Dios.\n" +
                "2.\tVoz que proclame tu existencia, tu inmensa ternura, tu resurrección. Voz que transmita tu mensaje limpio y desnudo, fuente de paz y libertad. Voz que sin miedo haga vibrar en cada hombre tu voz.\n" +
                "3.\tImagen del Señor del universo, autor de la vida, Padre y Creador. Imagen del Señor humanizado que es pastor y camino, fuerza y salud en el dolor. Signos humildes del Señor, de su misterio y verdad.\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Cristo que se da")
        cv.put("letra","1.\tAgobiado por el tiempo y la fatiga, me senté bajo un árbol del camino, imploré al Señor que me librara de la carga y el yugo de la vida. El Señor que sabía mi flaqueza, envió en mi auxilio su Palabra: “El camino es largo, pero tienes mi alimento, él, que te hará capaz de continuar”.\n" +
                "Cuerpo que es tu Cuerpo, Sangre que es tu Sangre, vino y pan de vida, Cristo que se da, que viene a caminar contigo.\n" +
                "2.\tAbatido por ofensas y desprecios me detuve una tarde en el camino y clamé al Señor que me vengara, que cumpliera con su brazo mi justicia. El Señor, que perdona mis delitos, ignoró mi insolencia cuando dijo: “El camino es difícil, pero tienes mi alimento, él, que te hará capaz de perdonar”.\n" +
                "3.\tMe dañaron la injusticia y la mentira, me golpeó la incomprensión de mis hermanos, supliqué al Señor que me aliviara, que allanara el camino de mi vida. El Señor, que comprende mis temores, me mostró las heridas de sus manos, “El camino es largo, pero tienes mi alimento, él, que te hará capaz de amar y amar.\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Te ofrecemos, Señor, nuestra juventud")
        cv.put("letra","Te ofrecemos, Señor, nuestra juventud.\n" +
                "1.\tEste día que amanece (que anochece) entre cantos y alegrías, este día en que sentimos tu presencia en nuestras vidas.\n" +
                "2.\tIlusiones y esperanzas, la alegría de vivir, todos juntos como hermanos, caminando hacia ti.\n" +
                "3.\tEl esfuerzo de los hombres, el dominio de la tierra, la llegada de tu Reino, inquietud que se hace eterna.\n" +
                "4.\tOfrecemos todos juntos nuestras vidas al Señor, los trabajos y dolores, la alegría y el amor.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Tú eres, Señor, el alimento")
        cv.put("letra","1.\tEl Padre que te ha enviado tiene vida y tú vives por Él. Así, quien se alimenta de tu Cuerpo, vivirá por ti. Tú eres el único que ha visto al Padre, Tú eres el que viene de Él. Aquel que bebe de tu agua, no tendrá más sed.\n" +
                "Tú eres, Señor, el alimento, el Pan que nos hará vivir; tú eres, Señor el Pan de vida, la vida vivirá por ti.\n" +
                "2.\tComieron el maná nuestros antepasados y murieron al fin, mas tú nos aseguras que el Pan vivo nos hará vivir. Tu cuerpo entregado por nosotros, nos resucitará.\n" +
                "3.\tTú eres la causa de la alegría, como el amanecer. La brisa de la mañana, que alivia nuestro andar. Tu cuerpo, Jesús, se eleva ante nosotros, se eleva como el sol. Tu sangre ha marcado nuestras puertas, Cordero de Dios.\n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","El amor es nuestro canto")
        cv.put("letra","1.\tEl amor es la palabra limpia, que hace vivir. Es el fruto de la tierra buena, y es sufrir. Es decirle al hermano pobre, solo no estás. No dejes que pase tu tiempo sin más.\n" +
                "El amor es nuestro canto a la vida que se da, y que espera un amanecer en la verdad.\n" +
                "2.\tEl amor es el regalo eterno, que nos da Dios, es tener el corazón abierto y es perdón. Es la fe y la esperanza puesta en el más allá, no dejes que pase tu tiempo sin más.\n" +
                "3.\tEl amor es un camino largo y sin final, es la luz que inunda sombras en la oscuridad. Es la vida que nos brinda un tiempo de oportunidad. No dejes que pase tu tiempo sin más. \n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Háblame")
        cv.put("letra","1.\tYo siento, Señor, que tú me amas, yo siento, Señor, que te puedo amar. Háblame, Señor, que tu siervo escucha. Háblame, ¿qué quieres de mí? Señor, tú has sido grande para mí, en el desierto de mi vida: ¡Háblame!\n" +
                "Yo quiero estar dispuesto a todo. Toma mi ser, mi corazón es para ti, por eso canto tus maravillas, por eso canto tu amor. (Bis)\n" +
                "2.\tTe alabo, Jesús, por tu grandeza. Mil gracias te doy por tu gran amor. Heme aquí, Señor, para acompañarte. Heme aquí, ¿qué quieres de mí? Señor, tú has sido grande para mí, en el desierto de mi vida: ¡Háblame!\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Santa María del Camino.")
        cv.put("letra","Mientras recorres la vida tú nunca solo estás, \n" +
                "       contigo por el camino Santa María va.  \n" +
                "   \n" +
                "      Ven con nosotros a caminar, Santa María, ven.  \n" +
                "    \n" +
                "   2. Aunque te digan algunos que nada puedes cambiar,\n" +
                "       lucha por un mundo nuevo, lucha por la verdad.  \n" +
                "   \n" +
                "   3. Si por el mundo los hombres sin conocerse van,\n" +
                "       no niegues nunca tu mano al que contigo está. \n" +
                "  \n" +
                "   4. Aunque parezcan tus pasos inútiles caminar,\n" +
                "       tú vas haciendo caminos, otros los seguirán.  \n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo"," Hoy te quiero cantar.")
        cv.put("letra","1. Hoy te quiero cantar, hoy te quiero rezar,\n" +
                "Madre mía del cielo. Si en mi alma hay dolor, \n" +
                "busco apoyo en tu amor y hallo en ti mi consuelo. \n" +
                "\n" +
                "Hoy te quiero cantar, hoy te quiero rezar. \n" +
                "Mi plegaria es canción. Yo te quiero ofrecer \n" +
                "lo más bello y mejor que hay en mi corazón.  (Bis) \n" +
                "\n" +
                "2. Porque tienes a Dios, porque tienes a Dios,\n" +
                "   Madre, todo lo puedes. Soy tu hijo también, \n" +
                "soy tu hijo también, y por eso me quieres. \n" +
                "\n" +
                "3. Dios te quiso elegir, Dios te quiso elegir\n" +
                "como puente y camino. Que une al hombre con Dios, \n" +
                "que une al hombre con Dios en abrazo divino. \n" +
                "\n")

        database!!.insert("CANTORAL",null,cv)
        cv.put("titulo","Siembra siempre el Amor.")
        cv.put("letra","Reina en el corazón, reina en el corazón, \n" +
                "reina en el corazón del pueblo cubano. \n" +
                "Siembra siempre el amor, siembra siempre el amor, \n" +
                "siembra siempre el amor, Madre del pueblo, \n" +
                "siembra el amor. \n" +
                "\n" +
                "1. Porque el amado y la amada se juran fidelidad,\n" +
                "    mas cuesta mucho la forja, la forja de la unidad.\n" +
                "    Para que el niño en la escuela, \n" +
                "    en la calle y en el hogar \n" +
                "    respeto y paso a las canas nunca deje de otorgar. \n" +
                "\n" +
                "2. Porque hay quien estando solo\n" +
                "    y enfermo, en su soledad \n" +
                "    necesita quien le extienda su mano con caridad. \n" +
                "    Para que el que aspire a nube \n" +
                "    y quiera subir, subir, \n" +
                "    no aplaste al que más abajo tenga que pagar sufrir. \n" +
                "3. Porque cuando digo: “hermano, hermano de corazón”,\n" +
                "    hay que serlo en todo tiempo, en buena y mala ocasión. \n" +
                "    Para que el que diga: “amigo, amigo, contigo estoy” \n" +
                "    se muestre siempre dispuesto, que vaya y no diga “voy”. \n" +
                "\n" +
                "4. Porque si alguno se alegra, su gozo compartirá\n" +
                "    con amigos y enemigos, con éste y el que está allá. \n" +
                "    Para que nunca se apaguen la ternura y la verdad, \n" +
                "    para que todos vivamos en paz y con dignidad. \n")

        database!!.insert("CANTORAL",null,cv)
       /* cv.put("titulo","CANTOS DEL VIACRUCIS")
        cv.put("letra","1.A ti levanto mis ojos, a ti, que habitas en el Cielo. A ti levanto mis ojos, porque espero tu misericordia. \n\n" +
                "2.En la Cruz murió el hombre un día, hay que aprender a morir todos los días en la Cruz, con Jesús. \n\n" +
                "3.Este es el día del Señor, este es el tiempo de sus Misericordia. \n\n" +
                "4.Si me levantaré, volveré junto a mis padres. \n\n" +
                "5.Perdona a tu pueblo, Señor, perdona a tu pueblo. Perdónale, Señor. \n" +
                "\n" +
                "6.Perdón, oh Dios mío, perdón e indulgencia, perdón y clemencia, perdón y piedad. \n" +
                "\n" +
                "7.Protégeme, Dios mío, me refugio en ti. (2 veces) \n\n" +
                "8.Victoria tu reinarás, oh Cruz, tú nos salvarás. \n\n" +
                "9.Padre a ti encomiendo mi vida. (2 veces)\n" +
                "\n" +
                "10. Con su muerte nos justificará y nuestras culpas soportará. (2 veces)\n" +
                "\n" +
                "11.La misericordia del Señor, cada día cantaré. \n\n" +
                "12.¿Oh Dios, por qué nos has abandonado? (2 veces)\n" +
                "\n" +
                "13.Pueblo mío, qué te he hecho, en qué te he ofendido. Respóndeme. (2 veces) \n\n" +
                "14. Aleluya.\n\n")

        database!!.insert("CANTORAL",null,cv)
*/

    }

    private fun InsertarLecturas(db : SQLiteDatabase?){

        var cv = ContentValues()

            cv.put("dia",1)
            cv.put("momento",2)
            cv.put("texto",context.resources.getString(R.string.lecturas_jueves_noche))
            db!!.insert("LECTURAS",null,cv)

        cv.put("dia",2)
        cv.put("momento",1)
        cv.put("texto",context.resources.getString(R.string.lecturas_viernes_morning))
        db!!.insert("LECTURAS",null,cv)

        cv.put("dia",2)
        cv.put("momento",2)
        cv.put("texto",context.resources.getString(R.string.lecturas_viernes_noche))
        db!!.insert("LECTURAS",null,cv)

        cv.put("dia",3)
        cv.put("momento",1)
        cv.put("texto",context.resources.getString(R.string.lecturas_sabado_morning))
        db!!.insert("LECTURAS",null,cv)

        cv.put("dia",3)
        cv.put("momento",2)
        cv.put("texto",context.resources.getString(R.string.lecturas_sabado_noche))
        db!!.insert("LECTURAS",null,cv)

        cv.put("dia",4)
        cv.put("momento",1)
        cv.put("texto",context.resources.getString(R.string.lecturas_doming_morning))
        db!!.insert("LECTURAS",null,cv)

    }

   /* private fun Ready()
    {
        var cv = ContentValues()
        cv.put("ready",1)
        database.update("READY",cv,"WHERE ready==0",null)
        close()
    }

    fun isReady():Boolean
    {
        return database.isDbLockedByCurrentThread
       /* var cursor = database.rawQuery("SELECT * FROM READY", null)
        var re = 0;
        if (cursor.moveToFirst()) {
            re = cursor.getInt(0)
        }
        return re==0;*/
    }*/
}