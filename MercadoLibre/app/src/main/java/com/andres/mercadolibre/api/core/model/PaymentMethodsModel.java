package com.andres.mercadolibre.api.core.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PaymentMethodsModel {
  @SerializedName("id")
  @Expose
  public String id;
  @SerializedName("name")
  @Expose
  public String name;
  @SerializedName("payment_type_id")
  @Expose
  public String paymentTypeId;
  @SerializedName("status")
  @Expose
  public String status;
  @SerializedName("secure_thumbnail")
  @Expose
  public String secureThumbnail;
  @SerializedName("thumbnail")
  @Expose
  public String thumbnail;
  @SerializedName("deferred_capture")
  @Expose
  public String deferredCapture;
  @SerializedName("settings")
  @Expose
  public List<Object> settings = null;
  @SerializedName("additional_info_needed")
  @Expose
  public List<Object> additionalInfoNeeded = null;
  @SerializedName("min_allowed_amount")
  @Expose
  public Double minAllowedAmount;
  @SerializedName("max_allowed_amount")
  @Expose
  public Integer maxAllowedAmount;
  @SerializedName("accreditation_time")
  @Expose
  public Integer accreditationTime;
  @SerializedName("financial_institutions")
  @Expose
  public List<Object> financialInstitutions = null;
  @SerializedName("processing_modes")
  @Expose
  public List<String> processingModes = null;
}
