package cu.bellalogica.jnjcuba2019;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.Timer;
import java.util.TimerTask;

import cu.bellalogica.jnjcuba2019.BaseDatos.DB_Interfaz;

public class TareaBackgroundComprobarBD extends AsyncTask {

    AppCompatActivity context;

    TareaBackgroundComprobarBD(AppCompatActivity contexto) {
        context = contexto;
    }

    @Override
    protected Object doInBackground(Object[] objects) {



        DB_Interfaz interfaz = new DB_Interfaz(context);
        boolean tiempo = PreferenceManager.getDefaultSharedPreferences(context).contains("tiempo");
        if (!tiempo) {
            PreferenceManager.getDefaultSharedPreferences(context).
                    edit().putInt("tiempo", 300).apply();
            return 2000l;
        }
        return 300l;
    }

    @Override
    protected void onPostExecute(Object o) {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask cicloespera = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        context.startActivity(new Intent(context, Principal.class));
                        context.overridePendingTransition(R.anim.desplazamiento_lateral,R.anim.desplazamiento_lateral);
                    }
                });
            }
        };
        long tiempo = (long) o;
        timer.schedule(cicloespera, tiempo);

    }
}