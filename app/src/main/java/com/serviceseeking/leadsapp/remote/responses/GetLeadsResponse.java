package com.serviceseeking.leadsapp.remote.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetLeadsResponse {

    @SerializedName("data")
    private List<Data> datas;

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

}
