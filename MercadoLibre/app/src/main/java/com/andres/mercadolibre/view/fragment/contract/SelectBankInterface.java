package com.andres.mercadolibre.view.fragment.contract;

import com.andres.mercadolibre.api.core.model.CardIssuersModel;
import com.andres.mercadolibre.api.impl.contract.base.InterfaceImpl;
import java.util.List;

public interface SelectBankInterface extends InterfaceImpl.View {

  void draData(List<CardIssuersModel> value);

}
