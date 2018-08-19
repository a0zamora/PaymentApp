package com.andres.mercadolibre.api.impl;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.core.model.InstallmentsModel;
import com.andres.mercadolibre.api.core.model.request.InstallmentsRequest;
import com.andres.mercadolibre.api.core.uc.GetInstallmentsUseCase;
import io.reactivex.observers.DisposableObserver;

public class GetInstallmentsManager {

  GetInstallmentsUseCase useCase;

  public GetInstallmentsManager(){
    useCase = new GetInstallmentsUseCase();
  }
  public void getInstallments(String amount, String issuerId, String paymentMethodId) {

    InstallmentsRequest request = new InstallmentsRequest();
    request.amount = amount;
    request.issuerId = issuerId;
    request.paymentMethodId = paymentMethodId;
    request.publicKey = BuildConfig.PUBLIC_KEY;
    useCase.execute(new GetInstallmentsObserver(), request);

  }


  public class GetInstallmentsObserver extends DisposableObserver<InstallmentsModel> {

    @Override public void onNext(InstallmentsModel value) {
      if(value== null){

      }
    }

    @Override public void onError(Throwable e) {
      if(e == null) {

      }

    }

    @Override public void onComplete() {

    }
  }
}
