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
import com.andres.mercadolibre.api.core.model.CardIssuersModel;
import com.andres.mercadolibre.api.impl.GetCardIssuersImpl;
import com.andres.mercadolibre.view.activity.MainActivityInterface;
import com.andres.mercadolibre.view.adapter.BankAdapter;
import com.andres.mercadolibre.view.fragment.contract.SelectBankInterface;
import java.util.List;

public class SelectBankFragment extends Fragment implements SelectBankInterface,
    BankAdapter.OnBankSelected{

  RecyclerView recyclerView;
  GetCardIssuersImpl impl;
  Button retry;
  ProgressBar progressBar;
  MainActivityInterface listener;

  String id;

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.card_issuers_fragment, container, false);
    return view;

  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    retry = view.findViewById(R.id.retry);
    progressBar = view.findViewById(R.id.progressBar);
    recyclerView = view.findViewById(R.id.list);
    LinearLayoutManager
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
    recyclerView.setLayoutManager(linearLayoutManager);
    impl = new GetCardIssuersImpl();
    impl.attachView(this);
    impl.getCardIssuers(id);
  }

  public void setData(String id) {
    this.id = id;
  }
  @Override public void showLoading() {
    progressBar.setVisibility(View.VISIBLE);
    retry.setVisibility(View.GONE);
  }

  @Override public void hideLoading() {
    progressBar.setVisibility(View.GONE);

  }

  public void setListener(MainActivityInterface listener) {
    this.listener = listener;
  }

  @Override public void showError() {
    retry.setVisibility(View.VISIBLE);
  }

  @Override public void draData(List<CardIssuersModel> value) {

    BankAdapter adapter = new BankAdapter();
    recyclerView.setAdapter(adapter);
    adapter.setData(value,this);
  }

  @Override public void onBankSelected(String id, String name) {
    listener.goToInstallments(id, name);
  }
}
