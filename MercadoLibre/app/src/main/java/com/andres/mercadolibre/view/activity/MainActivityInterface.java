package com.andres.mercadolibre.view.activity;

public interface MainActivityInterface {

  void goToAmountFragment();
  void goToPaymentMethod(String amount);
  void goToSelectBank(String id, String name);
  void goToInstallments(String id, String name);
  void goHome(String installment);

}
