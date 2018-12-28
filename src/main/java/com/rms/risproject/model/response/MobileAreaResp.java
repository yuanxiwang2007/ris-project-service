package com.rms.risproject.model.response;

import lombok.Data;

import java.util.Map;

@Data
public class MobileAreaResp {

    private Map<String, MobileAreaInfo> response;

    private ResponseHeader responseHeader;


}
