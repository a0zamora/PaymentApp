package com.andres.mercadolibre.api;

import com.andres.mercadolibre.api.core.model.CardIssuersModel;
import com.andres.mercadolibre.api.core.model.InstallmentsModel;
import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

  @GET("payment_methods")
  Observable<List<PaymentMethodsModel>> getPaymentMethods(@Query("public_key") String publicKey);

  @GET("payment_methods/card_issuers")
  Observable<List<CardIssuersModel>> getCardIssuers(@Query("public_key") String publicKey,
      @Query("payment_method_id") String paymentMethodId);

  @GET("payment_methods/installments")
  Observable<InstallmentsModel> getInstallments(@Query("public_key") String publicKey,
      @Query("amount") String amount,
      @Query("payment_method_id") String paymentMethodId,
      @Query("issuer.id") String issuerId);

}
