package com.rms.risproject;

import com.rms.risproject.model.response.TestVo;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import java.util.List;

public class TestLanguage {

    public List<TestVo> getList() {
        return list;
    }

    public void setList(List<TestVo> list) {
        this.list = list;
    }

    private List<TestVo> list;

    public static void main(String[] args) {

        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15G77 MicroMessenger/6.7.3(0x16070321) NetType/WIFI Language/zh_CN";
        //解析agent字符串
        UserAgent userAgent = UserAgent.parseUserAgentString(agent);
        //获取浏览器对象
        Browser browser = userAgent.getBrowser();
        //获取操作系统对象
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        System.out.println("agent:" + agent);
        System.out.println("浏览器名:" + browser.getName());
        System.out.println("浏览器类型:" + browser.getBrowserType());
        System.out.println("浏览器家族:" + browser.getGroup());
        System.out.println("浏览器生产厂商:" + browser.getManufacturer());
        System.out.println("浏览器使用的渲染引擎:" + browser.getRenderingEngine());
        System.out.println("浏览器版本:" + userAgent.getBrowserVersion());

        System.out.println("\n操作系统名:" + operatingSystem.getName());
        System.out.println("访问设备类型:" + operatingSystem.getDeviceType());
        System.out.println("操作系统家族:" + operatingSystem.getGroup());
        System.out.println("操作系统生产厂商:" + operatingSystem.getManufacturer());
    }

}
