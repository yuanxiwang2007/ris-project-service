package com.rms.risproject.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description：
 * @Author:yangxiao 发送优惠券到期提示短信
 * @Date: Create in 2018/11/8 19:35
 * @Modified By:
 */
public class SendCouponValidDaysMsgJob implements SimpleJob {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private MongodbDao mongodbDao;
//    @Autowired
//    private SMSService smsService;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("优惠券到期提示短信发送开始==========");
//        List<CouponValidDasyMsgBo> msgBoList = mongodbDao.getCouponValidDaysSendMsg();
//        if (msgBoList != null && msgBoList.size() > 0) {
//            for (CouponValidDasyMsgBo bo : msgBoList) {
//                String[] param = {bo.getCouponName(), DateUtil.format(bo.getCouponEndTime())};
//                try {
//                    String phone = bo.getPhone();
//                    smsService.sendCouponValiddaysMsg(phone, param);
//                    mongodbDao.updateCouponValidDaysMsgMark(phone);
//                } catch (BusinessException e) {
//                    logger.error("优惠券到期提示短信发送异常：" + e.getMessage());
//                }
//            }
//        }
        System.out.println("优惠券到期提示短信发送结束==========");
    }
}
