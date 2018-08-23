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
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.api.core.model.InstallmentsModel;
import com.andres.mercadolibre.api.impl.GetInstallmentsImpl;
import com.andres.mercadolibre.view.activity.MainActivityInterface;
import com.andres.mercadolibre.view.adapter.InstallmentAdapter;
import com.andres.mercadolibre.view.fragment.contract.SelectINstallmentInterface;

public class SelectInstallmentsFragment extends Fragment implements SelectINstallmentInterface,
    InstallmentAdapter.OnInstallmentClicked {
  GetInstallmentsImpl impl;
  Button retry;
  ProgressBar progressBar;
  RecyclerView list;

  MainActivityInterface listener;

  String issuerId;
  String paymentMethodId;
  String amount;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.card_issuers_fragment, container, false);
    retry = view.findViewById(R.id.retry);
    progressBar = view.findViewById(R.id.progressBar);
    list = view.findViewById(R.id.list);
    LinearLayoutManager
        linearLayoutManager =
        new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    list.setLayoutManager(linearLayoutManager);
    retry.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        impl.getInstallments(amount, issuerId, paymentMethodId);
      }
    });
    return view;
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    impl = new GetInstallmentsImpl();
    impl.attachView(this);
    impl.getInstallments(amount, issuerId, paymentMethodId);
  }

  @Override public void drawData(InstallmentsModel paymentMethodsModels) {
    if (paymentMethodsModels != null) {
      InstallmentAdapter adapter = new InstallmentAdapter();
      adapter.setData(paymentMethodsModels.payerCosts, this);
      list.setAdapter(adapter);
    }
  }

  public void setListener(MainActivityInterface listener) {
    this.listener = listener;
  }

  public void setData(String amount, String issuerId, String paymentMethodId) {
    this.amount = amount;
    this.issuerId = issuerId;
    this.paymentMethodId = paymentMethodId;
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

  @Override public void onInstallmentClicked(String id, String name) {
    if (listener != null) {
      listener.goHome();
    }
  }
}
