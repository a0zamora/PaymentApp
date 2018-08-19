package com.andres.mercadolibre.api.impl;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.core.uc.GetPaymentMethodsUseCase;
import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

public class GetPaymentMethodsManager {

  GetPaymentMethodsUseCase getPaymentMethodsUseCase;

  public GetPaymentMethodsManager(){
    getPaymentMethodsUseCase = new GetPaymentMethodsUseCase();
  }

  public void getPaymentMethods() {
    getPaymentMethodsUseCase.execute(new GetPaymentMethodsObserver(), BuildConfig.PUBLIC_KEY);
  }

  public class GetPaymentMethodsObserver extends DisposableObserver<List<PaymentMethodsModel>> {

    @Override public void onNext(List<PaymentMethodsModel> methods) {
      if (methods != null) {

      }
    }

    @Override public void onError(Throwable e) {

      if(e != null) {

      }
    }

    @Override public void onComplete() {

    }
  }
}
