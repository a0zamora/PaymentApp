package com.andres.mercadolibre.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.api.core.model.PayerCostModel;
import java.util.List;

public class InstallmentAdapter extends RecyclerView.Adapter<InstallmentAdapter.CardHolder> {

  List<PayerCostModel> data;
  OnInstallmentClicked listener;

  @NonNull @Override
  public InstallmentAdapter.CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    return new InstallmentAdapter.CardHolder(inflater.inflate(R.layout.installment_item, null, false));
  }

  @Override
  public void onBindViewHolder(@NonNull InstallmentAdapter.CardHolder holder, final int position) {
    holder.name.setText(data.get(position).recommendedMessage);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (listener != null) {
          listener.onInstallmentClicked(data.get(position).totalAmount+"", data.get(position).recommendedMessage);
        }
      }
    });
  }

  @Override public int getItemCount() {
    return data == null ? 0 : data.size();
  }

  public void setData(List<PayerCostModel> data, OnInstallmentClicked listener) {
    this.data = data;
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

  public interface OnInstallmentClicked {
    void onInstallmentClicked(String id, String name);
  }
}

