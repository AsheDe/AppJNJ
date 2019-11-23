package cu.bellalogica.jnjcuba2019

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz
import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Manager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.support.v4.os.HandlerCompat.postDelayed
import android.view.animation.AccelerateDecelerateInterpolator
import android.animation.ObjectAnimator
import android.graphics.drawable.Drawable
import android.preference.PreferenceManager
import android.widget.Toast
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(resources.getBoolean(R.bool.horizontal))
        Glide.with(this).load(R.mipmap.logohorizontal).into(imagenlogo)
        else
        Glide.with(this).load(R.mipmap.logofull).into(imagenlogo)

        TareaBackgroundComprobarBD(this).execute()
        Utiles.FullScreen(this)




    }





}
