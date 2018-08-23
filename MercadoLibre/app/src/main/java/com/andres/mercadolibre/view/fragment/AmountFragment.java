package com.andres.mercadolibre.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.andres.mercadolibre.R;
import com.andres.mercadolibre.view.activity.MainActivityInterface;

public class AmountFragment extends Fragment {
  EditText editText;
  Button continueButton;

  MainActivityInterface listener;

  public void setListener(MainActivityInterface listener) {
    this.listener = listener;
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.select_amount_fragment, container, false);
    editText = view.findViewById(R.id.amount);
    continueButton = view.findViewById(R.id.continue_button);
    continueButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (listener != null) {
          listener.goToPaymentMethod(editText.getText().toString());
        }
      }
    });

    editText.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override public void afterTextChanged(Editable s) {
        if (editText.getText().toString().isEmpty()) {
          continueButton.setEnabled(false);
        } else {
          continueButton.setEnabled(true);
        }
      }
    });
    return view;
  }
}
