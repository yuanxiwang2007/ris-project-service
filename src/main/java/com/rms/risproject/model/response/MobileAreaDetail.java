package com.rms.risproject.model.response;

import lombok.Data;

import java.util.List;

@Data
public class MobileAreaDetail {

    private List<MobileCityInfo> area;

    private String province;
    private String type;
    private String operator;
}
