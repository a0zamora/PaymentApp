package com.andres.mercadolibre.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import com.andres.mercadolibre.api.impl.GetPaymentMethodsImpl;
import com.andres.mercadolibre.view.fragment.contract.PaymentMethodInterface;
import java.util.List;

public class SelectCardIssuerFragment extends Fragment implements PaymentMethodInterface {

  GetPaymentMethodsImpl impl;
  Button retry;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.card_issuers_fragment, container, false);
    retry = view.findViewById(R.id.retry);
    return view;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    impl = new GetPaymentMethodsImpl();
    impl.attachView(this);
    impl.getPaymentMethods();

    retry.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        impl.getPaymentMethods();
      }
    });
  }

  @Override public void drawData(List<PaymentMethodsModel> paymentMethodsModels) {
    if (paymentMethodsModels!=null) {

    }
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void showError() {

  }
}
