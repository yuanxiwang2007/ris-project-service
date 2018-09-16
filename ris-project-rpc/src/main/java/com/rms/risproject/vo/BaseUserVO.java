package com.rms.risproject.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseUserVO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String keyId;

    private String code;

    private String name;

    private String phoneNo;
}
