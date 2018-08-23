package com.andres.mercadolibre.api.core.uc;

import com.andres.mercadolibre.api.NetworkInterface;
import com.andres.mercadolibre.api.core.ApiConnecter;
import com.andres.mercadolibre.api.core.model.InstallmentsModel;
import com.andres.mercadolibre.api.core.model.request.InstallmentsRequest;
import com.andres.mercadolibre.api.core.uc.base.UseCase;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Retrofit;

public class GetInstallmentsUseCase extends UseCase<List<InstallmentsModel>, InstallmentsRequest> {
  Retrofit retrofit;

  public GetInstallmentsUseCase() {
    retrofit = ApiConnecter.getRetrofit();
  }

  @Override
  protected Observable<List<InstallmentsModel>> buildUseCaseObservable(InstallmentsRequest params) {

    return retrofit.create(NetworkInterface.class)
        .getInstallments(params.publicKey, params.amount, params.paymentMethodId, params.issuerId);
  }
}
