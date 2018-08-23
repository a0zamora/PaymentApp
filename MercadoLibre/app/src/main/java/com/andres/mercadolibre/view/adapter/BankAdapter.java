package com.andres.mercadolibre.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.api.core.model.CardIssuersModel;
import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.CardHolder>{

  List<CardIssuersModel> data;
  OnBankSelected listener;

  @NonNull @Override
  public BankAdapter.CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    return new BankAdapter.CardHolder(inflater.inflate(R.layout.card_item,null,false));
  }

  @Override public void onBindViewHolder(@NonNull BankAdapter.CardHolder holder, final int position) {
    holder.name.setText(data.get(position).name);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if(listener!=null) {
          listener.onBankSelected(data.get(position).id,data.get(position).name);
        }
      }
    });
  }

  @Override public int getItemCount() {
    return data == null ? 0 : data.size();
  }

  public void setData(List<CardIssuersModel> list, OnBankSelected listener) {
    data = list;
    this.listener = listener;
    notifyDataSetChanged();
  }

  public class CardHolder extends RecyclerView.ViewHolder {
    public TextView name;

    public CardHolder(View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.name);
    }
  }


  public interface OnBankSelected {
    void onBankSelected(String id, String name);
  }
}
