package com.rms.risproject.rpc;

import com.github.pagehelper.PageHelper;
import com.rms.common.result.PageResult;
import com.rms.risproject.mapper.BaseUserMapper;
import com.rms.risproject.model.bo.BaseUserBo;
import com.rms.risproject.vo.BaseUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseUserRpcImpl implements BaseUserRpc {

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Override
    public int save(BaseUserVO baseUserVO) {
        BaseUserBo baseUserBo=new BaseUserBo();
        BeanUtils.copyProperties(baseUserVO,baseUserBo);
        return baseUserMapper.insertSelective(baseUserBo);
    }

    @Override
    public int update(BaseUserVO baseUserVO) {
        BaseUserBo baseUserBo=new BaseUserBo();
        BeanUtils.copyProperties(baseUserVO,baseUserBo);
        return baseUserMapper.updateByPrimaryKeySelective(baseUserBo);
    }

    @Override
    public PageResult<BaseUserVO> listByMachineID(Integer pageNum, Integer pageSize) {
        PageHelper pageHelper=new PageHelper();
        //pageHelper.s
        return null;
    }
}
