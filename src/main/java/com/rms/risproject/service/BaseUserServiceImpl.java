package com.rms.risproject.service;

import com.rms.risproject.api.BaseUserService;
import com.rms.risproject.mapper.BaseUserMapper;
import com.rms.risproject.model.bo.BaseUserBo;
import com.rms.risproject.model.response.BaseUserResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Override
    public int save(BaseUserResp vo) {
        BaseUserBo baseUserBo=new BaseUserBo();

        //vo.setKeyId(UuidUtil.getTimeBasedUuid().toString().replace("-",""));
        //baseUserBo.setKeyId();
        BeanUtils.copyProperties(vo,baseUserBo);
        return baseUserMapper.insert(baseUserBo);
    }

    @Override
    public int update(BaseUserResp vo) {
        BaseUserBo baseUserBo=new BaseUserBo();
        BeanUtils.copyProperties(vo,baseUserBo);
        return baseUserMapper.updateByPrimaryKeySelective(baseUserBo);
    }

    @Override
    public int delete(String keyId) {
        BaseUserBo baseUserBo=new BaseUserBo();
        baseUserBo.setKeyId(keyId);
        return baseUserMapper.deleteByPrimaryKey(baseUserBo);
    }
}
