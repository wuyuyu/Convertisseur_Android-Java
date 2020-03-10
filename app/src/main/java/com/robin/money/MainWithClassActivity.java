package com.robin.money;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainWithClassActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityWithClass";

    private Currency currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent srcIntent = getIntent();
        currency = srcIntent.getParcelableExtra("currency");

        ImageView flagImageView = findViewById(R.id.flagImageView);
        flagImageView.setImageResource(currency.flagId);

        TextView symbolTextView = findViewById(R.id.symbolTextView);
        symbolTextView.setText(currency.symbol);

        Log.i("MainActivity", "Hello World!");

        // On récupère la référence vers le bouton à partir de son id
        Button convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });

        findViewById(R.id.aboutButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAbout();
            }
        });
    }

    private void goToAbout() {
        Intent intent = new Intent(this, AboutActivity.class);
        intent.putExtra("version", "v2.3.1");

        TeamInfo teamInfo = new TeamInfo(
                "TP Reco",
                "v.3.1.8",
                4);

        // Cette ligne ne fonctionne que parce que
        // TeamInfo implémente l'interface Parcelable
        intent.putExtra("team", teamInfo);

        startActivity(intent);
    }

    private void convert() {
        Log.i("MainActivity", "onClick: convert");

        EditText amountEditText = findViewById(R.id.amountEditText);
        String amountStr = amountEditText.getText().toString();

        Log.i("MainActivity", "onClick: uservalue=" + amountStr);

        // VERSION EARLY RETURN
        if (amountStr.isEmpty()) {
            Toast.makeText(MainWithClassActivity.this, "Montant vide", Toast.LENGTH_SHORT)
                    .show();

            return;
        }

        float result = Float.parseFloat(amountStr) * currency.rate;

        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(result + currency.symbol);
    }

}
