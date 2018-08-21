package com.andres.mercadolibre;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.andres.mercadolibre.view.fragment.SelectCardIssuerFragment;

public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    goToPaymentMethods();
  }


  void goToPaymentMethods() {
    SelectCardIssuerFragment cardIssuerFragment = new SelectCardIssuerFragment();
    replace(cardIssuerFragment);
  }

  void replace(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.fragment, fragment);
    transaction.commit();
  }
}
