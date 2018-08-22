package com.andres.mercadolibre.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.view.fragment.SelectCardIssuerFragment;

public class MainActivity extends AppCompatActivity {

  public static final String PAYMENT_METHOD = "PAYMENT_METHOD";

  private String cardIssuer;

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

  @Override protected void onStop() {
    super.onStop();
    sendAnswer();
  }

  private void sendAnswer() {
    Intent intent = new Intent();
    intent.getExtras().putString(PAYMENT_METHOD, cardIssuer);
    setResult(Activity.RESULT_OK, intent);
  }

}
