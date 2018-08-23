package com.andres.mercadolibre.api.core.uc;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.NetworkInterface;
import com.andres.mercadolibre.api.core.ApiConnecter;
import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import com.andres.mercadolibre.api.core.uc.base.UseCase;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetPaymentMethodsUseCase extends UseCase<List<PaymentMethodsModel>, String> {
  Retrofit retrofit;

  public GetPaymentMethodsUseCase(){
    retrofit = ApiConnecter.getRetrofit();
  }

  @Override protected Observable<List<PaymentMethodsModel>> buildUseCaseObservable(String params) {
    return retrofit.create(NetworkInterface.class).getPaymentMethods(params);
  }
}
