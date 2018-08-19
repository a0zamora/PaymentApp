package com.andres.mercadolibre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.andres.mercadolibre.api.impl.GetPaymentMethodsManager;

public class MainActivity extends AppCompatActivity {

  GetPaymentMethodsManager manager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    manager = new GetPaymentMethodsManager();
    manager.getPaymentMethods();

  }
}
