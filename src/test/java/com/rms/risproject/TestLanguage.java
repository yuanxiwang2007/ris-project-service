package com.rms.risproject;

import com.alibaba.fastjson.JSONObject;
import com.rms.common.util.baidu.BaiduMobileApiUtils;
import com.rms.common.util.baidu.MobileAreaModel;
import com.rms.risproject.model.response.MobileAreaResp;
import com.rms.risproject.model.response.TestVo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.List;

public class TestLanguage {

    public List<TestVo> getList() {
        return list;
    }

    public void setList(List<TestVo> list) {
        this.list = list;
    }

    private List<TestVo> list;

    public static void main(String[] args) throws IOException {

        String phoneNos = "13738331042,13580693563,15832179198,13402311465,18200446013,17083603969,13282094756,13402486635,13463961977,13458608423,15273844297,17136394674,15183863854,13252481532,13775660379,15714351545,15976575878,18238761928,17170315086,15714358784,17131672880,17136624752,18443829573,17123024257,19891052205,13894587054,19891052204,13568564329,15114353414,17666205635,13920678570,15731810260,18250930731,15386246394,17764857967,16634423543,13797680563,13463119212,13483147624,13403310856,13483182858,15536397770,13731494735,13483153769,13402482651,13483131401,13483668127,13483140452,15297728921,17612576122,18232688514,15893272416,13627983743,15620739424,13513898429,18216481221,15953861411,13348942156,13655221954,18877537307,15813904805,13129445810,18353282008,17682448502,18779137932,13553883115,17346051554,13979409850,13693134727,13145813569,18657582956,13463804855,18271561461,13282053914,18308095841,13819529690,13367896221,18952319419,18756645190,13814850464,13245718779,13024377500,15581527500,18370270542,18770926328,18370248277,18365443723,18370275964,18470749569,18370268421,18370276049,18460003542,18370236481,18370280421,18085484006,18570308711,18438706585,15835194932,13922500764,15279369002,13001033933,13001052663,13001063927,13001078076,13001091796,13001103139,13001115712,13001173841,13001202409,13001215577,13001215778,13001228670,13001239329,13001263517,13001287570,13001300599,13001303126,13001306818,13001312832,13001321898,13001323190,13001328930,13001335098,13001358062,13001358376,13001367211,13001369558,13001378721,13001389043,13001409136,13001413518,13001413582,13001415671,13001421019,13001422163,13001428890,13001481143,13001485887,13001489777,13001527483,13001539553,13001548682,13001550361,13001556934,13001559765,13001566241,13001567078,13001576883,13001578153,13001592353,13001592598,13001599036,13001599413,13001702583,13001706382,13001712447,13001729003,13001729459,13001751964,13001754396,13001755134,13001755144,13001755804,13001756528,13001757349,13001761366,13001767661,13001772143,13001779024,13001781179,13001783132,13001784258,13001789352,13001798830,13001805697,13001811291,13001811825,13001826829,13001836687,13001836884,13001838552,13001842363,13001843168,13001855908,13001872209,13001898295,13001899705,13001934985,13001978940,13001999166,13002002317,13002005233,13002010096,13002035751,13002041454,13002082109,13002096385,13002113530,13002173010,13002180062";
        MobileAreaModel dd = BaiduMobileApiUtils.getMobileAreaInfo(phoneNos);
        System.out.println(JSONObject.toJSONString(dd));
//        String agent = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15G77 MicroMessenger/6.7.3(0x16070321) NetType/WIFI Language/zh_CN";
//        //解析agent字符串
//        UserAgent userAgent = UserAgent.parseUserAgentString(agent);
//        //获取浏览器对象
//        Browser browser = userAgent.getBrowser();
//        //获取操作系统对象
//        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
//        System.out.println("agent:" + agent);
//        System.out.println("浏览器名:" + browser.getName());
//        System.out.println("浏览器类型:" + browser.getBrowserType());
//        System.out.println("浏览器家族:" + browser.getGroup());
//        System.out.println("浏览器生产厂商:" + browser.getManufacturer());
//        System.out.println("浏览器使用的渲染引擎:" + browser.getRenderingEngine());
//        System.out.println("浏览器版本:" + userAgent.getBrowserVersion());
//
//        System.out.println("\n操作系统名:" + operatingSystem.getName());
//        System.out.println("访问设备类型:" + operatingSystem.getDeviceType());
//        System.out.println("操作系统家族:" + operatingSystem.getGroup());
//        System.out.println("操作系统生产厂商:" + operatingSystem.getManufacturer());
    }

    public static String calcMobileCity(String mobileNumber) throws MalformedURLException {

        //获取拍拍网的API地址
        //        String urlString = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?mobile="
        //                + mobileNumber + "&amount=10000&callname=getPhoneNumInfoExtCallback";
        //淘宝网的API地址
        String urlString = "http://mobsec-dianhua.baidu.com/dianhua_api/open/location?tel="
                + mobileNumber;


        StringBuffer sb = new StringBuffer();
        BufferedReader buffer;

        String province = "";
        try {
            HttpClient httpCient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(urlString);
            HttpResponse response = httpCient.execute(httpget);
            InputStream in = response.getEntity().getContent();
            // 解决乱码问题
            buffer = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String line = null;
            //一行一行的读取数据
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            buffer.close();
            String jsonObject2 = sb.toString();
            //System.out.println(jsonObject2);
//            //定义两种不同格式的字符串
//            //   __GetZoneResult_ = {    mts:'1594578',    province:'黑龙江',    catName:'中国移动',    telString:'15945782060',    areaVid:'30496',    ispVid:'3236139',   carrier:'黑龙江移动'}
//            String objectStr = sb.toString().replace("__GetZoneResult_ = ", "");// = "{\"mts\":\"1594578\",\"province\":\"黑龙江\",\"catName\":\"中国移动\",\"telString\":\"15945782060\",\"areaVid\":\"30496\",\"ispVid\":\"3236139\",\"carrier\":\"黑龙江移动\"}";
//            //1、使用JSONObject
//            JSONObject jsonObject2 = JSONObject.parseObject(objectStr);
//            String pro1 = jsonObject2.getString("province");
//            System.out.println(pro1);
            MobileAreaResp stu = JSONObject.parseObject(jsonObject2, MobileAreaResp.class);
            System.out.println(JSONObject.toJSONString(stu));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //从JSONObject对象中读取城市名称
        return province/*jsonObject.getString("cityname")*/;
    }

}
