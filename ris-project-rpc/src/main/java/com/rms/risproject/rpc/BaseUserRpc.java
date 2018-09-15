package com.rms.risproject.rpc;

import com.rms.common.result.PageResult;
import com.rms.risproject.vo.BaseUserVO;

public interface BaseUserRpc {

    int save(BaseUserVO baseUserVO);

    int update(BaseUserVO baseUserVO);

    PageResult<BaseUserVO> listByMachineID(Integer pageNum, Integer pageSize);
}
