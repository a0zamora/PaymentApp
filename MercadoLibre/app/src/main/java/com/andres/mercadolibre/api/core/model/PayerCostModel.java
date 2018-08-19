
package com.andres.mercadolibre.api.core.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayerCostModel {

    @SerializedName("installments")
    @Expose
    public Integer installments;
    @SerializedName("installment_rate")
    @Expose
    public Double installmentRate;
    @SerializedName("discount_rate")
    @Expose
    public Integer discountRate;
    @SerializedName("labels")
    @Expose
    public List<String> labels = null;
    @SerializedName("installment_rate_collector")
    @Expose
    public List<String> installmentRateCollector = null;
    @SerializedName("min_allowed_amount")
    @Expose
    public Integer minAllowedAmount;
    @SerializedName("max_allowed_amount")
    @Expose
    public Integer maxAllowedAmount;
    @SerializedName("recommended_message")
    @Expose
    public String recommendedMessage;
    @SerializedName("installment_amount")
    @Expose
    public Integer installmentAmount;
    @SerializedName("total_amount")
    @Expose
    public Integer totalAmount;

}
