package com.andres.mercadolibre.api.core.uc;

import com.andres.mercadolibre.BuildConfig;
import com.andres.mercadolibre.api.NetworkInterface;
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
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    retrofit = new Retrofit.Builder()
        .baseUrl(BuildConfig.CORE_API)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build();
  }

  @Override protected Observable<List<PaymentMethodsModel>> buildUseCaseObservable(String params) {
    return retrofit.create(NetworkInterface.class).getPaymentMethods(params);
  }
}
