package com.andres.mercadolibre.view.activity;

public class MercadoLibreResult {
  public Card paymentMethod = new Card();
  public Bank bank = new Bank();

  public String amount;
  public String installment;

  public class Card {
    public String id;
    public String name;
  }

  public class Bank {
    public String id;
    public String name;
  }
}
