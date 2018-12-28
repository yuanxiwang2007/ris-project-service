package com.rms.risproject.service;

import com.rms.risproject.api.BaseUserService;
import com.rms.risproject.mapper.BaseUserMapper;
import com.rms.risproject.mapper.MongodbDao;
import com.rms.risproject.model.bo.BaseUserBo;
import com.rms.risproject.model.response.BaseUserResp;
import com.rms.risproject.ordermapper.BaseUser2Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BaseUserServiceImpl implements BaseUserService {

    @Autowired
    private BaseUserMapper baseUserMapper;

    @Autowired
    private BaseUser2Mapper baseUser2Mapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongodbDao mongodbDao;

    @Override
    public int save(BaseUserResp vo) {
        BaseUserBo baseUserBo = new BaseUserBo();
        //HttpServletResponse resp = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
        vo.setKeyId(UUID.randomUUID().toString().replace("-",""));
        //baseUserBo.setKeyId();
        BeanUtils.copyProperties(vo, baseUserBo);
        mongodbDao.saveObjectValue(baseUserBo);
        baseUserMapper.insert(baseUserBo);
        return baseUser2Mapper.insert(baseUserBo);
    }

    @Override
    public int update(BaseUserResp vo) throws NoSuchFieldException, IllegalAccessException {
        BaseUserBo baseUserBo = new BaseUserBo();
        BeanUtils.copyProperties(vo, baseUserBo);

        //Query query = new Query(Criteria.where("KeyId").is(baseUserBo.getKeyId()));
        //Update update = new Update().set("loginName", baseUserBo.getLoginName()).set("loginPwd", baseUserBo.getLoginPwd());
        //更新查询返回结果集的第一条
        //mongoTemplate.updateFirst(query, update, BaseUserBo.class);
        mongodbDao.updateObjectValueByPramarykey(baseUserBo);
        return baseUserMapper.updateByPrimaryKeySelective(baseUserBo);
    }

    @Override
    public int delete(String keyId) {
        BaseUserBo baseUserBo = new BaseUserBo();
        baseUserBo.setKeyId(keyId);
        return baseUserMapper.deleteByPrimaryKey(baseUserBo);
    }
}
