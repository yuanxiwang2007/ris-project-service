package com.rms.risproject.util;

import java.io.Serializable;
import java.util.List;

public class  ResultResponse<T> extends PageResponse implements Serializable {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}