package com.robin.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // On récupère l'extra de notre intent de lancement
        Intent srcIntent = getIntent();
        String version = srcIntent.getStringExtra("version");

        TeamInfo info = srcIntent.getParcelableExtra("team");
        Log.i("AboutActivity", "onCreate: " + info);

        // On met à jour l'UI avec la version récupérée
        TextView versionTextView = findViewById(R.id.versionTextView);
        versionTextView.setText(version);

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
