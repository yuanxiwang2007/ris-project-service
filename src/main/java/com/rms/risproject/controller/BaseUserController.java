package com.rms.risproject.controller;

import com.rms.common.controller.BaseController;
import com.rms.common.result.HttpResult;
import com.rms.risproject.api.BaseUserService;
import com.rms.risproject.model.response.BaseUserResp;
import com.rms.risproject.rpc.BaseUserRpc;
import com.rms.risproject.service.RedisService;
import com.rms.risproject.vo.BaseUserVO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/UserManager")
public class BaseUserController extends BaseController {

    @Autowired
    private BaseUserService baseUserService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/index")
    public HttpResult index(){
        BaseUserResp baseUserResp=new BaseUserResp();
        baseUserResp.setKeyId("111111111");
        String key= UUID.randomUUID().toString();
        redisService.put(key,baseUserResp);

        BaseUserResp baseUserResp1=(BaseUserResp)redisService.get(key);

        log.info("取值："+baseUserResp1.toString());
        return success(baseUserResp1);
    }

    @RequestMapping(value= "/save")
    public HttpResult save(@RequestBody BaseUserResp baseUserResp){

        baseUserService.save(baseUserResp);
        return success();
    }

    @RequestMapping(value= "/update")
    public HttpResult update(@RequestBody BaseUserResp baseUserResp){
        log.info(String.format("/update:{0}",baseUserResp.toString()));

        if(StringUtils.isEmpty(baseUserResp.getKeyId())){
            return error("更新用户的ID不能为空！");
        }
        try{
            baseUserService.update(baseUserResp);
            return success();
        }catch (Exception ex){
            log.error(ex.getMessage());
            return error("更新失败");
        }

    }
    @RequestMapping(value= "/delete")
    public HttpResult delete(){
        //@RequestBody
        String keyId="222";
        if(StringUtils.isEmpty(keyId)){
            return error("删除用户的ID不能为空！");
        }
        baseUserService.delete(keyId);
        return success();
    }
}
