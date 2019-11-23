package cu.bellalogica.jnjcuba2019

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.BottomSheetDialog
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.PopupMenu
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz
import kotlinx.android.synthetic.main.activity_principal.*
import java.util.*
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment


class Principal : AppCompatActivity()
{

    val REQUEST_CODE_ASK = 1
    override fun onPostResume() {
        super.onPostResume()
        if(intent.hasExtra("mover"))
            paginado_eventos.currentItem = 1
    }


    private var onclick = View.OnClickListener {

        if(it!!.id == R.id.navigation_masopciones)
        {
            MostrarMenuSecundario(it)
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        ultimoseleccionado = item.itemId
        when (item.itemId) {
            R.id.navigation_calendario -> {
                paginado_eventos.visibility = View.VISIBLE
                mapa_principal.visibility = View.GONE
                paginado_eventos.currentItem = 0

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_apostoles-> {
                paginado_eventos.visibility = View.VISIBLE
                mapa_principal.visibility = View.GONE
                paginado_eventos.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_mapa-> {

                var bd = DB_Interfaz(this)
                var list = bd.ObtenerTodasLocalizaciones()
                var frag =  FragmentoMapa()
                var bdle = Bundle()//.apply { putParcelableArray("puntos",list.toTypedArray()) }
                bdle.putParcelableArrayList("puntos", list )
                frag!!.arguments = bdle
                supportFragmentManager.beginTransaction().replace(R.id.mapa_principal,frag).commit()
                paginado_eventos.visibility = View.GONE
                mapa_principal.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_masopciones-> {

                MostrarMenuSecundario(bottombar)
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }
    var ultimoseleccionado = R.id.navigation_calendario
    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putInt("last",ultimoseleccionado)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        bottombar.selectedItemId = savedInstanceState!!.getInt("last",0)
    }

    fun MostrarMenuSecundario (v: View){
        val popup = PopupMenu(this, v,Gravity.RIGHT)
        val inflater = popup.getMenuInflater()
          inflater.inflate(R.menu.navegacion_secundaria, popup.getMenu())
        popup.show()

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { menuItem ->
            popup.dismiss()
            when (menuItem.itemId) {
                R.id.menu_historia-> {
                    startActivity(Intent(baseContext, Historia::class.java))
                    overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
                }
                R.id.menu_comunicar->
                {
                    MostrarBottomSheet()
                }
                R.id.menu_cantos-> startActivity(Intent(baseContext, Canto::class.java))
                R.id.menu_eucaristia-> startActivity(Intent(baseContext, Eucaristia::class.java))
                R.id.menu_examen-> startActivity(Intent(baseContext, Examen::class.java))
                R.id.menu_catequesis-> startActivity(Intent(baseContext, Catequesis::class.java))
                R.id.menu_recordar-> startActivity(Intent(baseContext, Recordatorios::class.java))
                R.id.menu_viacrucis-> startActivity(Intent(baseContext, Oracion_Viacrucis::class.java))
                R.id.menu_oracion-> startActivity(Intent(baseContext, OracionJNJ::class.java))
            }
            overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
            false
        })


    }

    fun MostrarBottomSheet(){
        var btsd = BottomSheetDialog(this)

        var vist = LayoutInflater.from(this).inflate(R.layout.botoomshet_contactar,null,false)


        (vist.findViewById<View>(R.id.contllamar)).setOnClickListener{
            btsd.dismiss()
           EjecutarLlamar(0)
        }
        (vist.findViewById<View>(R.id.contllamarASESORES)).setOnClickListener{
            btsd.dismiss()
            EjecutarLlamar(1)
        }
        (vist.findViewById<View>(R.id.imgllamar)).setOnClickListener{
            btsd.dismiss()
            EjecutarLlamar(0)
        }
        (vist.findViewById<View>(R.id.imgllamarASESORES)).setOnClickListener{
            btsd.dismiss()
            EjecutarLlamar(1)
        }

        (vist.findViewById<View>(R.id.imgfacebook)).setOnClickListener {
            btsd.dismiss()
            VerFacebook()
        }

        (vist.findViewById<View>(R.id.verfacebook)).setOnClickListener {
            btsd.dismiss()
            VerFacebook()
        }

        (vist.findViewById<View>(R.id.imgyoutube)).setOnClickListener {
            btsd.dismiss()
            VerYoutube()
        }

        (vist.findViewById<View>(R.id.veryoutube)).setOnClickListener {
            btsd.dismiss()
            VerYoutube()
        }

        btsd.setContentView(vist)
        btsd.show()
    }

    fun EjecutarLlamar(asesor:Int){
        var bd = DB_Interfaz(this)
        var dialog = AlertDialog.Builder(this)
        var mContactos =bd.ObtenerContactos(asesor)
        dialog.setAdapter(LAdapter(mContactos),DialogInterface.OnClickListener { dialog, which ->
            Utiles.Llamar(mContactos.get(which).telefono,this)
        })
        if(asesor==0)
            dialog.setTitle("CONTACTOS PARA JÓVENES")
        else
            dialog.setTitle("CONTACTOS PARA ASESORES")
        dialog.setIcon(resources.getDrawable(R.drawable.illamar))
        dialog.setPositiveButton("CANCELAR",DialogInterface.OnClickListener { dialog, which ->  dialog.dismiss()})
        dialog.create().show()
    }

    fun VerFacebook()
    {
        val uri = Uri.parse("https://m.facebook.com/jnjcuba")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
        overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
    }

    fun VerYoutube()
    {
        val uri = Uri.parse("https://www.youtube.com/channel/UCDMUJSQOtUyJs4C9L7YopsQ")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
        overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
    }


    internal class LAdapter(var listcontactos:List<Contacto>) :  BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
           var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_contacto,
                    parent,false)

            view.findViewById<TextView>(R.id.nombre_contacto).text  = listcontactos.get(position).nombre
            view.findViewById<TextView>(R.id.cargo_contacto).text  = listcontactos.get(position).cargo
            return view
        }



        override fun getItem(position: Int): Any = listcontactos.get(position)
        override fun getItemId(position: Int): Long = position.toLong()
        override fun getCount(): Int = listcontactos.size
    }

    var desplazamiento = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Utiles.FullScreen(this)
        setContentView(R.layout.activity_principal)
        paginado_eventos.adapter = Adaptador_Pager_Principal(supportFragmentManager,this)

        paginado_eventos.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottombar.selectedItemId = R.id.navigation_calendario
                    1 -> bottombar.selectedItemId = R.id.navigation_apostoles

                }
            }

        })

        bottombar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }


    override fun onResume() {
        super.onResume()
        val hasSMSPermissionW = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val hasSMSPermissionR = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)


        //   val hasSMSPermission = packageManager.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,packageName)
        if (hasSMSPermissionW != PackageManager.PERMISSION_GRANTED || hasSMSPermissionR != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_CODE_ASK
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CODE_ASK) {
                for (perm in grantResults)
                    if(perm!=PackageManager.PERMISSION_GRANTED)
                        Toast.makeText(this, "No se aceptaron todos los permisos, no se podrá abrir el MAPA", Toast.LENGTH_SHORT).show();

            }



    }



}



/*   popup.setOnMenuItemClickListener ({object : PopupMenu.OnMenuItemClickListener{
            override fun onMenuItemClick(p0: MenuItem?): Boolean {
                when (p0!!.itemId)
                {
                    R.id.historia->startActivity( Intent(baseContext,Historia::class.java))
                }
                return true
            }
         }
        })*/