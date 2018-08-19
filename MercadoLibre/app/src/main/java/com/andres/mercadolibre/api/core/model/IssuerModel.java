
package com.andres.mercadolibre.api.core.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssuerModel {

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

}
