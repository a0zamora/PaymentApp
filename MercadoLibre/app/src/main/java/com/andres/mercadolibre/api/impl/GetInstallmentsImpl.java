package com.andres.mercadolibre.api.impl;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.core.model.InstallmentsModel;
import com.andres.mercadolibre.api.core.model.request.InstallmentsRequest;
import com.andres.mercadolibre.api.core.uc.GetInstallmentsUseCase;
import com.andres.mercadolibre.api.impl.contract.GetInstallmentsInterface;
import com.andres.mercadolibre.api.impl.contract.base.BaseInterfaceImpl;
import com.andres.mercadolibre.view.fragment.contract.SelectINstallmentInterface;
import io.reactivex.observers.DisposableObserver;
import java.util.List;

public class GetInstallmentsImpl extends BaseInterfaceImpl<SelectINstallmentInterface>
    implements GetInstallmentsInterface {

  GetInstallmentsUseCase useCase;

  public GetInstallmentsImpl(){
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


  public class GetInstallmentsObserver extends DisposableObserver<List<InstallmentsModel>> {
    @Override protected void onStart() {
      super.onStart();
      getView().showLoading();
    }

    @Override public void onNext(List<InstallmentsModel> value) {
      if(value != null && value.size() != 0) {
        getView().drawData(value.get(0));
      }
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
