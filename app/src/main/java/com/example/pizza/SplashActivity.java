package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    private ImageView splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        splash = findViewById(R.id.splash);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    RotateAnimation rotate = new RotateAnimation(
                            0,
                            360,
                            Animation.RELATIVE_TO_SELF,
                            0.5f,
                            Animation.RELATIVE_TO_SELF,
                            0.5f
                    );
                    rotate.setDuration(1000);
                    rotate.setRepeatCount(Animation.INFINITE);
                    rotate.setInterpolator(new LinearInterpolator());
                    splash.setAnimation(rotate);

                    Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                    sleep(5000);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        thread.start();

    }
}
