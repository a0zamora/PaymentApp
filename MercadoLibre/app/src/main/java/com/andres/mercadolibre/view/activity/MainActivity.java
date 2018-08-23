package com.andres.mercadolibre.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.view.fragment.AmountFragment;
import com.andres.mercadolibre.view.fragment.SelectBankFragment;
import com.andres.mercadolibre.view.fragment.SelectCardIssuerFragment;
import com.andres.mercadolibre.view.fragment.SelectInstallmentsFragment;
import com.andres.mercadolibre.view.fragment.contract.SelectINstallmentInterface;

public class MainActivity extends AppCompatActivity implements MainActivityInterface {

  public static final String PAYMENT_METHOD = "PAYMENT_METHOD";
  MachineStates state = MachineStates.SELECT_AMOUNT;
  MercadoLibreResult result;

  enum MachineStates {
    SELECT_AMOUNT,
    SELECT_CARD,
    SELECT_BANK,
    SELECT_INSTALLMENTS
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    result = new MercadoLibreResult();
    goToPaymentMethod();
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
    /*Intent intent = new Intent();
    intent.getExtras().putString(PAYMENT_METHOD, cardIssuer);
    setResult(Activity.RESULT_OK, intent);*/
    this.finish();
  }

  @Override public void goToAmountFragment() {
    state = MachineStates.SELECT_AMOUNT;
    AmountFragment fragment = new AmountFragment();
    replace(fragment);
  }

  @Override public void goToPaymentMethod() {
    state = MachineStates.SELECT_CARD;
    result.amount = "100000";
    SelectCardIssuerFragment cardIssuerFragment = new SelectCardIssuerFragment();
    cardIssuerFragment.setListener(this);
    replace(cardIssuerFragment);
  }

  @Override public void goToSelectBank(String id, String name) {
    state = MachineStates.SELECT_BANK;
    result.paymentMethod.name = name;
    result.paymentMethod.id = id;
    SelectBankFragment fragment = new SelectBankFragment();
    fragment.setData(id);
    fragment.setListener(this);
    replace(fragment);
  }

  @Override public void goToInstallments(String id, String name) {
    state = MachineStates.SELECT_INSTALLMENTS;
    result.bank.name = name;
    result.bank.id = id;
    SelectInstallmentsFragment fragment = new SelectInstallmentsFragment();
    fragment.setListener(this);
    fragment.setData(result.amount, result.bank.id, result.paymentMethod.id);
    replace(fragment);
  }

  @Override public void goHome() {
    sendAnswer();
  }

  @Override public void onBackPressed() {
    if (state.equals(MachineStates.SELECT_AMOUNT)) {
      super.onBackPressed();
      return;
    }
    if (state.equals(MachineStates.SELECT_CARD)) {
      goToAmountFragment();
      return;
    }
    if (state.equals(MachineStates.SELECT_BANK)) {
      goToPaymentMethod();
      return;
    }
    if (state.equals(MachineStates.SELECT_INSTALLMENTS)) {
      goToSelectBank(result.paymentMethod.id, result.paymentMethod.name);
      return;
    }

    super.onBackPressed();
  }
}
