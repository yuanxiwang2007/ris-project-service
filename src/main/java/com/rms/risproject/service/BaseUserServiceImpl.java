package com.rms.risproject.service;

import com.rms.risproject.api.BaseUserService;
import com.rms.risproject.mapper.BaseUserMapper;
import com.rms.risproject.model.bo.BaseUserBo;
import com.rms.risproject.model.response.BaseUserResp;
import com.rms.risproject.ordermapper.BaseUser2Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Autowired
    private BaseUser2Mapper baseUser2Mapper;

    @Override
    public int save(BaseUserResp vo) {
        BaseUserBo baseUserBo=new BaseUserBo();
        //HttpServletResponse resp = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
        //vo.setKeyId(UuidUtil.getTimeBasedUuid().toString().replace("-",""));
        //baseUserBo.setKeyId();
        BeanUtils.copyProperties(vo,baseUserBo);
        baseUserMapper.insert(baseUserBo);
        return baseUser2Mapper.insert(baseUserBo);
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
