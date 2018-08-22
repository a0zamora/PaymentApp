package com.andres.mercadolibre.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import java.util.List;

public class CardIssuerAdapter extends RecyclerView.Adapter<CardIssuerAdapter.CardHolder>{

  List<PaymentMethodsModel> data;
  OnPaymentMethodsItemClicked listener;

  @NonNull @Override
  public CardIssuerAdapter.CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    return new CardHolder(inflater.inflate(R.layout.card_item,null,false));
  }

  @Override public void onBindViewHolder(@NonNull CardIssuerAdapter.CardHolder holder, final int position) {
    holder.name.setText(data.get(position).name);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if(listener!=null) {
          listener.setName(data.get(position).id,data.get(position).name);
        }
      }
    });
  }

  @Override public int getItemCount() {
    return data == null ? 0 : data.size();
  }

  public void setData(List<PaymentMethodsModel> list, OnPaymentMethodsItemClicked listener) {
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


  public interface OnPaymentMethodsItemClicked {
    void setName(String id, String name);
  }
}
