package com.andres.mercadolibre.api.core.uc;

import com.andres.mercadolibre.api.NetworkInterface;
import com.andres.mercadolibre.api.core.ApiConnecter;
import com.andres.mercadolibre.api.core.model.CardIssuersModel;
import com.andres.mercadolibre.api.core.model.request.CardIssuersRequest;
import com.andres.mercadolibre.api.core.uc.base.UseCase;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Retrofit;

public class GetCardIssuersUseCase extends UseCase<List<CardIssuersModel>, CardIssuersRequest> {
  Retrofit retrofit;

  public GetCardIssuersUseCase(){
    retrofit = ApiConnecter.getRetrofit();
  }

  @Override protected Observable<List<CardIssuersModel>> buildUseCaseObservable(CardIssuersRequest params) {
    return retrofit.create(NetworkInterface.class).getCardIssuers(params.publicKey, params.paymentMethodId);
  }
}
