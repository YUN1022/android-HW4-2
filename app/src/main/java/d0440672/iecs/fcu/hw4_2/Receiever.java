package d0440672.iecs.fcu.hw4_2;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;

public class Receiever extends AppCompatActivity {

    static int id= 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiever);
    }

    public class BR_Notifiction extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String name=intent.getStringExtra("KEY_NAME");
            Intent newIntent=new Intent();
            newIntent.setClass(context,MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,newIntent,PendingIntent.FLAG_CANCEL_CURRENT);
            Notification notify=null;

            notify=newNotifiction(context,pendingIntent,"Boardcast is received",name);
            NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id++,notify);
        }
    }

    private Notification newNotifiction(Context context,PendingIntent pend,String title,String msg){
        Notification.Builder builder=new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();
        return notify;
    }
}

