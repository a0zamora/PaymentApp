package com.andres.mercadolibre.view.activity;

import android.app.Activity;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements MainActivityInterface {


  public static final String AMOUNT = "AMOUNT";
  public static final String PAYMENT_METHOD = "PAYMENT_METHOD";
  public static final String BANK = "BANK";
  public static final String INSTALLMENT = "INSTALLMENT";

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
    goToAmountFragment();
  }

  void replace(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.fragment, fragment);
    transaction.commit();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  private void sendAnswer() {
    Intent intent = new Intent();
    intent.putExtra(AMOUNT, result.amount);
    intent.putExtra(PAYMENT_METHOD, result.paymentMethod.name);
    intent.putExtra(BANK, result.bank.name);
    intent.putExtra(INSTALLMENT, result.installment);
    setResult(Activity.RESULT_OK, intent);
    finish();
  }

  @Override public void goToAmountFragment() {
    state = MachineStates.SELECT_AMOUNT;
    AmountFragment fragment = new AmountFragment();
    fragment.setListener(this);
    replace(fragment);
  }

  @Override public void goToPaymentMethod(String amount) {
    state = MachineStates.SELECT_CARD;
    result.amount = amount;
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

  @Override public void goHome(String installment) {
    result.installment = installment;
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
      goToPaymentMethod(result.amount);
      return;
    }
    if (state.equals(MachineStates.SELECT_INSTALLMENTS)) {
      goToSelectBank(result.paymentMethod.id, result.paymentMethod.name);
      return;
    }

    super.onBackPressed();
  }
}
