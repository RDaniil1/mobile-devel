package ru.mirea.reshetnikovdd.looper;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyLooper extends Thread{
    public Handler mHandler;
    private Handler mainHandler;
    public MyLooper(Handler mainThreadHandler) {
        mainHandler = mainThreadHandler;
    }
    public void run() {
        Log.d("MyLooper", "run");
        Looper.prepare();
        mHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message msg) {
                int age = msg.getData().getInt("age");
                String work = msg.getData().getString("work");
                Log.d("MyLooper get age: %d", String.valueOf(age));
                Log.d("MyLooper get work: %s", work);

                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putString("result", String.format("Age = %d Work = %s", age, work));
                message.setData(bundle);
                mainHandler.sendMessage(message);
            }
        };
        Looper.loop();
    }
}
