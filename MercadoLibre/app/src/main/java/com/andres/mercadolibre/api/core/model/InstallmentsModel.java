
package com.andres.mercadolibre.api.core.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InstallmentsModel {

    @SerializedName("payment_method_id")
    @Expose
    public String paymentMethodId;
    @SerializedName("payment_type_id")
    @Expose
    public String paymentTypeId;
    @SerializedName("issuer")
    @Expose
    public IssuerModel issuer;
    @SerializedName("processing_mode")
    @Expose
    public String processingMode;
    @SerializedName("merchant_account_id")
    @Expose
    public Object merchantAccountId;
    @SerializedName("payer_costs")
    @Expose
    public List<PayerCostModel> payerCosts = null;

}
