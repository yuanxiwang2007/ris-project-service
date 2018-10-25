package com.rms.risproject.controller;

import com.rms.common.controller.BaseController;
import com.rms.common.excel.ExcelUtil;
import com.rms.common.result.HttpResult;
import com.rms.risproject.api.BaseUserService;
import com.rms.risproject.model.response.BaseUserResp;
import com.rms.risproject.service.RedisService;
import com.rms.risproject.util.TwoDimensionCode;
import com.rms.risproject.util.TwoDimensionCodeBackImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/UserManager")
public class BaseUserController extends BaseController {

    @Autowired
    private BaseUserService baseUserService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/index")
    public HttpResult index() {
        BaseUserResp baseUserResp = new BaseUserResp();
        baseUserResp.setKeyId("111111111");
        String key = "ris:project:" + UUID.randomUUID().toString();
        redisService.set(key, baseUserResp, 1l, TimeUnit.MINUTES);

        BaseUserResp baseUserResp1 = (BaseUserResp) redisService.get(key);

        logger.info("取值：" + baseUserResp1.toString());
        return success(baseUserResp1);
    }

    @RequestMapping(value = "/save")
    public HttpResult save(@RequestBody BaseUserResp baseUserResp) {

        baseUserService.save(baseUserResp);
        return success();
    }

    @RequestMapping(value = "/update")
    public HttpResult update(@RequestBody BaseUserResp baseUserResp) {
        logger.info(String.format("/update:{0}", baseUserResp.toString()));

        if (StringUtils.isEmpty(baseUserResp.getKeyId())) {
            return error("更新用户的ID不能为空！");
        }
        try {
            baseUserService.update(baseUserResp);
            return success();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return error("更新失败");
        }

    }

    @RequestMapping(value = "/delete")
    public HttpResult delete() {
        //@RequestBody
        String keyId = "222";
        if (StringUtils.isEmpty(keyId)) {
            return error("删除用户的ID不能为空！");
        }
        baseUserService.delete(keyId);
        return success();
    }

    @RequestMapping(value = "/UserListExportExcel")
    public HttpResult UserListExportExcel(@RequestParam("fileName") String fileName) {
        List<BaseUserResp> userRespList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BaseUserResp baseUserResp = new BaseUserResp();
            baseUserResp.setKeyId("keyid123123" + i);
            baseUserResp.setCode("code1312111" + i);
            baseUserResp.setName("张三" + i);
            baseUserResp.setPhoneNo("133456788" + i);
            baseUserResp.setAge(18 + i);
            userRespList.add(baseUserResp);
        }
        try {
            ExcelUtil.ExportToClient(fileName, userRespList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success();
    }

    @RequestMapping(value = "/promotionCode")
    public HttpResult promotionCode(int size,int pixelSize,int complex, HttpServletResponse response) throws Exception {
        TwoDimensionCodeBackImg backImg = new TwoDimensionCodeBackImg();
        TwoDimensionCode handler = new TwoDimensionCode();
        //backImg.setBackPath("classpath:qrCodeBackImg.png");
        backImg.setBackPath("");
        backImg.setIcoSize(250);
        backImg.setIcoX(250);
        backImg.setIcoY(603);
        backImg.setTitle("扫码解锁红包");
        backImg.setTitleX(10);
        backImg.setTitleX(10);
        String randomStr ="12010101200100481540435520077";
        String path = URLEncoder.encode(randomStr, "UTF-8");
        String projectPath = "https://urine-analysis.doctorwork.com/urine-miniapp";
        handler.encoderQRCode(projectPath + "/unknown?path=" + path, response.getOutputStream(), backImg, size, pixelSize, complex);

        return success();
    }
}
