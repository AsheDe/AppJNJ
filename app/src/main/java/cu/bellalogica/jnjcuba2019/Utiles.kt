package cu.bellalogica.jnjcuba2019

import android.Manifest
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.Manifest.permission
import android.Manifest.permission.CALL_PHONE
import android.content.Context
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.net.Uri
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.app.AlarmManager
import java.util.*
import android.support.v4.content.ContextCompat.getSystemService
import android.widget.Toast


class Utiles{
    companion object {
        fun FullScreen(actividad: AppCompatActivity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    actividad.window.statusBarColor = Color.TRANSPARENT
                    actividad.window
                            .decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                } else {
                    actividad.window
                            .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                }
            }
        }

        val REQUEST_CODE_ASK_PERMISSIONS_CALL = 1987
        fun Llamar(telefono: String,actividad:AppCompatActivity) {

            val hasCALLPermission = ActivityCompat.checkSelfPermission(actividad, Manifest.permission.CALL_PHONE)
            if (hasCALLPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(actividad, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CODE_ASK_PERMISSIONS_CALL)

            } else {
                val callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:$telefono")
                actividad.startActivity(callIntent)
                actividad.overridePendingTransition(R.anim.desplazamiento_lateral, R.anim.desplazamiento_lateral)
            }
        }

        fun PonerAlarma(evento: Eventos, context:Context) {
               val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager?
            val intent = Intent(context, AlarmaBroadcastReceiver::class.java)
            intent.putExtra("evento",evento)
            val pendingIntent = PendingIntent.getBroadcast(context, evento.id, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val calendar = Calendar.getInstance()
            calendar.setTimeInMillis(System.currentTimeMillis())
           // calendar.setTimeInMillis(evento.fechainicial.time)
         //calendar.set(Calendar.HOUR_OF_DAY, 14)
            calendar.set(Calendar.YEAR, 2019)
            calendar.set(Calendar.MONTH, Calendar.AUGUST)
            calendar.set(Calendar.DATE, evento.fechainicial.date)
            calendar.set(Calendar.HOUR_OF_DAY, evento.fechainicial.hours)
          //  calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+2)
            calendar.set(Calendar.MINUTE, evento.fechainicial.minutes-15)

            alarmManager!!.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,  pendingIntent);

       //     val alarmMgr: AlarmManager?
         //   val alarmIntent: PendingIntent

            //alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
           // val intent = Intent(context, AlarmaBroadcastReceiver::class.java)
           // intent.putExtra("evento",evento)
           // alarmIntent = PendingIntent.getBroadcast(context, evento.id, intent, 0)

// Alarma a las 8:30 a.m.


// Repeticiones en intervalos de 20 minutos
          //  alarmMgr!!.set(AlarmManager.RTC_WAKEUP, evento.fechainicial.time - (1000*60*15), alarmIntent)
            //alarmMgr!!.setRepeating(AlarmManager.RTC_WAKEUP, evento.fechainicial.time ,1000*60 ,alarmIntent)

            Toast.makeText(context,"Alarma configurada para el evento ${evento.evento}. Le alertará 15 minutos antes.",Toast.LENGTH_SHORT).show()
            //Toast.makeText(context,calendar.toString(),Toast.LENGTH_SHORT).show()
        }
/*
1st Param : Type of the Alarm
2nd Parm : Time in milliseconds when the alarm will be triggered first
3rd Param : Interval after which alarm will be repeated .
4th Param : Pending Intent
Note that we have changed the type to RTC_WAKEUP as we are using Wall clock time
*/

        fun QuitarAlarma(evento: Eventos, context:Context)
        {
           /* val alarmMgr: AlarmManager?
            val alarmIntent: PendingIntent

            alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
            val intent = Intent(context, AlarmaBroadcastReceiver::class.java)
           // intent.putExtra("evento",evento)
            alarmIntent = PendingIntent.getBroadcast(context, evento.id, intent, 0)*/

            val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager?
            val intent = Intent(context, AlarmaBroadcastReceiver::class.java)
            intent.putExtra("evento",evento)
            val pendingIntent = PendingIntent.getBroadcast(context, evento.id, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val calendar = Calendar.getInstance()
            calendar.setTimeInMillis(System.currentTimeMillis())
            // calendar.setTimeInMillis(evento.fechainicial.time)
            //calendar.set(Calendar.HOUR_OF_DAY, 14)
            calendar.set(Calendar.YEAR, 2019)
            calendar.set(Calendar.MONTH, Calendar.JUNE)
            calendar.set(Calendar.DATE, evento.fechainicial.date)
            calendar.set(Calendar.HOUR_OF_DAY, evento.fechainicial.hours)
            //  calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+2)
            calendar.set(Calendar.MINUTE, evento.fechainicial.minutes)

            //alarmManager!!.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,  pendingIntent)

            alarmManager!!.cancel(pendingIntent)

            Toast.makeText(context,"Se ha quitado la alarma del evento ${evento.evento}",Toast.LENGTH_SHORT).show()
        }

        }


    }




