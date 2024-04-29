package ru.mirea.reshetnikovdd.yandexdriver;
import android.app.Application;
import com.yandex.mapkit.MapKitFactory;

import io.github.cdimascio.dotenv.Dotenv;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Dotenv dotenv = Dotenv.configure()
                .directory("/assets")
                .filename("env")
                .load();

        MapKitFactory.setApiKey(dotenv.get("API_KEY"));
    }
}