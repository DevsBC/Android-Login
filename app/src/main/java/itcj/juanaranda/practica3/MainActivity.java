package itcj.juanaranda.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        TextView textView = findViewById(R.id.username);
        int slideInLeft = android.R.anim.slide_in_left;
        this.startAnimation(textView, username, 1000, slideInLeft);
        String subtitle = "Práctica de Login";
        TextView textView1 = findViewById(R.id.textView);
        int fadeIn = android.R.anim.fade_in;
        this.startAnimation(textView1, subtitle, 1500, fadeIn);
    }

    private void startAnimation(TextView textView, String textToAnimate, int duration, int animation) {
        new Handler().postDelayed(() -> {
            textView.setText(textToAnimate);
            textView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), animation));
        }, duration);
    }
}