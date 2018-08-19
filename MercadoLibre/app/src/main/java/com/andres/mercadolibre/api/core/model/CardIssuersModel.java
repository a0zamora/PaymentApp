package com.andres.mercadolibre.api.core.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardIssuersModel {
  @SerializedName("id")
  @Expose
  public String id;
  @SerializedName("name")
  @Expose
  public String name;
  @SerializedName("secure_thumbnail")
  @Expose
  public String secureThumbnail;
  @SerializedName("thumbnail")
  @Expose
  public String thumbnail;
  @SerializedName("processing_mode")
  @Expose
  public String processingMode;
  @SerializedName("merchant_account_id")
  @Expose
  public Object merchantAccountId;
}
