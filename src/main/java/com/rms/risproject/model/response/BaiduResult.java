package com.rms.risproject.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaiduResult<T> implements Serializable {
    private Integer code;
    private T data;

}
