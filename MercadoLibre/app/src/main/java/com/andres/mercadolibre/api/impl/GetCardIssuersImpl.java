package com.andres.mercadolibre.api.impl;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.core.model.CardIssuersModel;
import com.andres.mercadolibre.api.core.model.request.CardIssuersRequest;
import com.andres.mercadolibre.api.core.uc.GetCardIssuersUseCase;
import com.andres.mercadolibre.api.impl.contract.CardIssuersImplInterface;
import com.andres.mercadolibre.api.impl.contract.GetPaymenMethodsImplInterface;
import com.andres.mercadolibre.api.impl.contract.base.BaseInterfaceImpl;
import com.andres.mercadolibre.view.fragment.contract.PaymentMethodInterface;
import com.andres.mercadolibre.view.fragment.contract.SelectBankInterface;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

public class GetCardIssuersImpl extends BaseInterfaceImpl<SelectBankInterface>
    implements CardIssuersImplInterface {

  GetCardIssuersUseCase useCase;

  public GetCardIssuersImpl() {
    useCase = new GetCardIssuersUseCase();
  }

  public void getCardIssuers(String paymentMethodId) {
    CardIssuersRequest request = new CardIssuersRequest();
    request.paymentMethodId = paymentMethodId;
    request.publicKey = BuildConfig.PUBLIC_KEY;
    useCase.execute(new GetCardIssuersObserver(), request);
  }

  public class GetCardIssuersObserver extends DisposableObserver<List<CardIssuersModel>> {

    @Override protected void onStart() {
      super.onStart();
      getView().showLoading();
    }

    @Override public void onNext(List<CardIssuersModel> value) {
      getView().draData(value);
    }

    @Override public void onError(Throwable e) {
      getView().showError();
    }

    @Override public void onComplete() {

      getView().hideLoading();
    }
  }
}
