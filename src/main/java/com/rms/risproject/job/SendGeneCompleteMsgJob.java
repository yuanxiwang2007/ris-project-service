package com.rms.risproject.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description：
 * @Author:yangxiao
 * @Date: Create in 2018/7/13 10:07
 * @Modified By:
 */
public class SendGeneCompleteMsgJob implements SimpleJob {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private MongodbDao mongodbDao;
//    @Autowired
//    private SMSService smsService;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "   基因检测短信发送开始");
//        List<UrineCompleteMsgBo> list = mongodbDao.getGeneSendMsg();
//        if (list != null && list.size() > 0) {
//            for (UrineCompleteMsgBo data : list) {
//                System.out.println("短息发送信息 " + JSON.toJSONString(data));
//                String[] param = {data.getProductName(), "\"企鹅健康终端\"小程序"};
//                String outSystemId = data.getOutSystemId();
//                if ("3".equals(outSystemId)) {
//                    param[1] = "\"企鹅医生健康小站\"小程序";
//                }
//                try {
//                    smsService.sendGeneCompleteMessage(data, param);
//                    mongodbDao.updateGeneMsgMark(data.getBarcode());
//                } catch (BusinessException e) {
//                    logger.error("基因检测短信通知异常");
//                }
//            }
//        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "    基因检测短信发送结束");
    }
}
