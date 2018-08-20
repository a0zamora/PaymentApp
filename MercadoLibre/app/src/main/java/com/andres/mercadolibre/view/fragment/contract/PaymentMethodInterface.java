package com.andres.mercadolibre.view.fragment.contract;

import com.andres.mercadolibre.api.core.model.PaymentMethodsModel;
import com.andres.mercadolibre.api.impl.contract.base.InterfaceImpl;
import java.util.List;

public interface PaymentMethodInterface extends InterfaceImpl.View {

  void engineData(List<PaymentMethodsModel> paymentMethodsModels);

}
