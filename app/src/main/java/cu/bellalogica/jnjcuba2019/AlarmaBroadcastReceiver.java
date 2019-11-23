package cu.bellalogica.jnjcuba2019;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

import cu.bellalogica.jnjcuba2019.Principal;

public class AlarmaBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

       // Log.d("despertar",intent.getParcelableExtra("evento").toString());
      //  Toast.makeText(context,intent.getStringExtra("evento"),Toast.LENGTH_SHORT).show();

        Eventos evento = intent.getParcelableExtra("evento");
        if(evento!=null)
        {
            Integer recurso = R.mipmap.agosto1;
        switch (evento.getFechainicial().getDate())
        {
            case 2: {
                recurso = R.mipmap.agosto2;
                break;
            }
            case 3: {
                recurso = R.mipmap.agosto3;
                break;
            }
            case 4: {
                recurso = R.mipmap.agosto4;
                break;
            }
        }
        NotificationCompat.Builder notoficacion =
                new NotificationCompat.Builder(context)
                        .setColor(context.getResources().getColor(R.color.colorAccent))
                        .setContentText(evento.getLugar())
                        .setSmallIcon(recurso)
                        .setContentTitle( evento.getEvento()  )
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.logofull))
                ;
        Intent resultIntent = new Intent(context, Actividad_Evento.class);
        resultIntent.putExtra("evento",evento.getId());
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(Actividad_Evento.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        evento.getId(),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        notoficacion.setContentIntent(resultPendingIntent);

        if (Build.VERSION.SDK_INT <= 25) {
            notoficacion.setDefaults(Notification.DEFAULT_ALL);
            notoficacion.setPriority(NotificationCompat.PRIORITY_HIGH);
        } else {
            notoficacion.setPriority(NotificationManager.IMPORTANCE_HIGH);
        }

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(evento.getId(), notoficacion.build());

    }

    else
    {

        Integer recurso = R.mipmap.agosto1;

        NotificationCompat.Builder notoficacion =
                new NotificationCompat.Builder(context)
                        .setColor(context.getResources().getColor(R.color.colorAccent))
                        .setContentText("Se aproxima el evento que agregaste a recordatorios")
                        .setSmallIcon(recurso)
                        .setContentTitle( "Notificación de la JNJ"  )
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.logofull))
                ;
        Intent resultIntent = new Intent(context, Actividad_Evento.class);
        resultIntent.putExtra("evento",1);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(Actividad_Evento.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        1,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        notoficacion.setContentIntent(resultPendingIntent);

        if (Build.VERSION.SDK_INT <= 25) {
            notoficacion.setDefaults(Notification.DEFAULT_ALL);
            notoficacion.setPriority(NotificationCompat.PRIORITY_HIGH);
        } else {
            notoficacion.setPriority(NotificationManager.IMPORTANCE_HIGH);
        }

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, notoficacion.build());

    }
}
}
