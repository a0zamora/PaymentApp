package com.andres.mercadolibre.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.view.activity.MainActivity;

public class WelcomeActivity extends AppCompatActivity {
  public static final int MAIN_CODE = 9001;
  Button startTestButton;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome_activity);
    startTestButton = findViewById(R.id.startTest);
    startTestButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivityForResult(intent, MAIN_CODE);
      }
    });
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == MAIN_CODE && requestCode == Activity.RESULT_OK) {

      String result = "AMOUNT: " + data.getExtras().getString(MainActivity.AMOUNT) +
          "\nPAYMENT METHOD " + data.getExtras().getString(MainActivity.PAYMENT_METHOD) +
          "\nBANK " + data.getExtras().getString(MainActivity.BANK) +
          "\nINSTALLMENT" + data.getExtras().getString(MainActivity.INSTALLMENT);

      Toast.makeText(WelcomeActivity.this, result, Toast.LENGTH_LONG).show();
    }
    super.onActivityResult(requestCode, resultCode, data);
  }
}
