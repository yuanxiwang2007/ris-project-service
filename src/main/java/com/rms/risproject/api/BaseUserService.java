package com.rms.risproject.api;

import com.rms.risproject.model.response.BaseUserResp;

public interface BaseUserService {

    int save(BaseUserResp vo);

    int update(BaseUserResp vo);

    int delete(String keyId);

}
