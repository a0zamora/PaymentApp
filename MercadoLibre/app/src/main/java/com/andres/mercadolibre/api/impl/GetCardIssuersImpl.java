package com.andres.mercadolibre.api.impl;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.core.model.CardIssuersModel;
import com.andres.mercadolibre.api.core.model.request.CardIssuersRequest;
import com.andres.mercadolibre.api.core.uc.GetCardIssuersUseCase;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

public class GetCardIssuersImpl {

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

    @Override public void onNext(List<CardIssuersModel> value) {
      if(value != null) {

      }
    }

    @Override public void onError(Throwable e) {
      if (e!=null) {

      }
    }

    @Override public void onComplete() {

    }
  }
}
