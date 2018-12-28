package com.rms.risproject.api;

import com.rms.risproject.model.response.BaseUserResp;

public interface BaseUserService {

    int save(BaseUserResp vo);

    int update(BaseUserResp vo) throws NoSuchFieldException, IllegalAccessException;

    int delete(String keyId);

}
