package com.andres.mercadolibre.view.activity;

public interface MainActivityInterface {

  void goToAmountFragment();
  void goToPaymentMethod();
  void goToSelectBank(String id, String name);
  void goToInstallments(String id, String name);
  void goHome();

}
