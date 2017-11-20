package com.example.sikshya.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.start_button)
    Button startButton;
    @BindView(R.id.stop_button)
    Button stopButton;
    @BindView(R.id.next_button)
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.stop_button:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.next_button:
                startActivity(new Intent(this, MainActivity2.class));
                break;

        }

    }
}
