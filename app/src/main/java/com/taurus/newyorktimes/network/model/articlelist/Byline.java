
package com.taurus.newyorktimes.network.model.articlelist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Byline {

    @SerializedName("original")
    @Expose
    private String original;

    @SerializedName("organization")
    @Expose
    private String organization;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

}
