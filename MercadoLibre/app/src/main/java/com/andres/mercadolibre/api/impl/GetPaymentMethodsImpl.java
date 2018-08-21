package com.andres.mercadolibre.api.impl;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import com.andres.mercadolibre.api.core.uc.GetPaymentMethodsUseCase;
import com.andres.mercadolibre.api.impl.contract.GetPaymenMethodsImplInterface;
import com.andres.mercadolibre.api.impl.contract.base.BaseInterfaceImpl;
import com.andres.mercadolibre.view.fragment.contract.PaymentMethodInterface;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

public class GetPaymentMethodsImpl extends BaseInterfaceImpl<PaymentMethodInterface> implements GetPaymenMethodsImplInterface{

  GetPaymentMethodsUseCase getPaymentMethodsUseCase;

  public GetPaymentMethodsImpl(){
    getPaymentMethodsUseCase = new GetPaymentMethodsUseCase();
  }

  @Override public void getPaymentMethods() {
    getPaymentMethodsUseCase.execute(new GetPaymentMethodsObserver(), BuildConfig.PUBLIC_KEY);
  }

  public class GetPaymentMethodsObserver extends DisposableObserver<List<PaymentMethodsModel>> {

    @Override protected void onStart() {
      super.onStart();
      getView().showLoading();
    }

    @Override public void onNext(List<PaymentMethodsModel> methods) {
      getView().drawData(methods);
    }

    @Override public void onError(Throwable e) {
      getView().hideLoading();
      getView().showError();
    }

    @Override public void onComplete() {
      getView().hideLoading();
    }
  }
}
