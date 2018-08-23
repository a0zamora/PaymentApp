package com.andres.mercadolibre.view.fragment.contract;

import com.andres.mercadolibre.api.core.model.InstallmentsModel;
import com.andres.mercadolibre.api.impl.contract.base.InterfaceImpl;

public interface SelectINstallmentInterface extends InterfaceImpl.View {

  void drawData(InstallmentsModel model);
}
