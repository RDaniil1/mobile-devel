package ru.mirea.reshetnikovdd.notificationapp;

import static android.Manifest.permission.POST_NOTIFICATIONS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "com.mirea.reshetnikovdd.notification.ANDROID";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
            Log.d(MainActivity.class.getSimpleName().toString(), "Разрешения получены");
        }
        else {
            Log.d(MainActivity.class.getSimpleName().toString(), "Нет разрешения");
            ActivityCompat.requestPermissions(this, new String[] {POST_NOTIFICATIONS}, 200);
        }
    }

    public void onClickSendNotification(View view) {
        if (ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentText("Congratulation!");
        builder.setSmallIcon(androidx.constraintlayout.widget.R.drawable.notification_icon_background);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Much longer text that cannot fit one line..."));
        builder.setContentTitle("Mirea");

        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Student ReshetnikovDD Notification", importance);
        channel.setDescription("MIREA Channel");

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.createNotificationChannel(channel);
        manager.notify(1, builder.build());
    }
}