package com.robin.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CurrencyChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_chooser);

        findViewById(R.id.usaButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDollarWithExtra();
            }
        });
        findViewById(R.id.ukButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPoundsWithClass();
            }
        });
    }

    private void goToDollarWithExtra() {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("flagId", R.drawable.flag_usa);
        i.putExtra("rate", 1.13f);
        i.putExtra("symbol", "$");
        startActivity(i);
    }

    private void goToPoundsWithClass() {
        Intent intent = new Intent(this, MainWithClassActivity.class);
        Currency c = new Currency(R.drawable.flag_uk, 0.86f, "£");
        intent.putExtra("currency", c);
        startActivity(intent);
    }
}
