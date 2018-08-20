package com.andres.mercadolibre.api.impl.contract.base;

public abstract class BaseInterfaceImpl <V extends InterfaceImpl.View> {

  private V view;

  public void attachView(V view) {
    this.view = view;
  }

  public V getView() {
    return view;
  }

}
