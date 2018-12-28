package com.rms.risproject.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseHeader {
    private Integer status;
    private Date time;
    private String version;

}