package com.andres.mercadolibre.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import com.andres.mercadolibre.api.impl.GetPaymentMethodsImpl;
import com.andres.mercadolibre.view.adapter.CardIssuerAdapter;
import com.andres.mercadolibre.view.fragment.contract.PaymentMethodInterface;
import java.util.List;

public class SelectCardIssuerFragment extends Fragment implements PaymentMethodInterface, CardIssuerAdapter.OnPaymentMethodsItemClicked {

  GetPaymentMethodsImpl impl;
  Button retry;
  ProgressBar progressBar;
  RecyclerView list;

  MercadoLibreResult result;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.card_issuers_fragment, container, false);
    retry = view.findViewById(R.id.retry);
    progressBar = view.findViewById(R.id.progressBar);
    list = view.findViewById(R.id.list);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
    list.setLayoutManager(linearLayoutManager);
    result = new MercadoLibreResult();
    retry.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        impl.getPaymentMethods();
      }
    });
    return view;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    impl = new GetPaymentMethodsImpl();
    impl.attachView(this);
    impl.getPaymentMethods();
  }

  @Override public void drawData(List<PaymentMethodsModel> paymentMethodsModels) {
    if (paymentMethodsModels!=null) {
      CardIssuerAdapter adapter = new CardIssuerAdapter();
      adapter.setData(paymentMethodsModels, this);
      list.setAdapter(adapter);
    }
  }

  @Override public void showLoading() {
    progressBar.setVisibility(View.VISIBLE);
    retry.setVisibility(View.GONE);
  }

  @Override public void hideLoading() {
    progressBar.setVisibility(View.GONE);

  }

  @Override public void showError() {
    retry.setVisibility(View.VISIBLE);
  }

  @Override public void setName(String id, String name) {
    result.paymentMethodName = name;
    Toast.makeText(getActivity(),id + " - " +name,Toast.LENGTH_SHORT).show();
  }

  public class MercadoLibreResult {
    public String paymentMethodName;
  }

}
