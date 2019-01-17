package com.rms.risproject.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description： 每周一凌晨三点 为小红盒会员赠送心选优惠券
 * @Author:yangxiao
 * @Date: Create in 2019/1/8 17:38
 * @Modified By:
 */
public class GiftXinxuanCouponJob implements SimpleJob {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private AssociatorUserRpc associatorUserRpc;
//    @Autowired
//    private AssociatorRightsReceiveRecordRpc associatorRightsReceiveRecordRpc;
//    @Autowired
//    private CouponService couponService;
//    @Autowired
//    private MongodbDao mongodbDao;

    /**
     * 每周一凌晨三点为小红盒会员赠送优惠券，查询出本周内未领取过商城礼券的有效会员并发送优惠券，然后保存至mongo用于周一十点为用户发送通知消息或者短信
     *
     * @param shardingContext
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(calendar.DAY_OF_WEEK) - 1;
        if (week == 0) {
            week = 7;
        }
        if (week == 1) {
            System.out.println("周一发送优惠券");
            //查询出所有有效会员
            Date now = new Date();
            Integer associatorId = 1;// 小红盒会员类型暂定1
//            AssociatorUserVo associatorUserVo = new AssociatorUserVo();
//            associatorUserVo.setAssociatorID(associatorId);
//            List<AssociatorUserVo> validAssociatorList = associatorUserRpc.getValidAssociatorNoReceiveRecordInThisWk
//                    (associatorUserVo);
//            if (validAssociatorList != null && validAssociatorList.size() > 0) {
//                for (AssociatorUserVo vo : validAssociatorList) {
//                    String userId = vo.getUserID();
//                    String userPhone = vo.getUserPhone();
//                    List<TicketInfoRes> stringList = new ArrayList<>();
//                    try {
//                        stringList = couponService.giftXinxuanCoupon(userId);
//                    } catch (BusinessException e) {
//                        logger.error("赠送心选优惠券异常");
//                    }
//                    if (stringList != null && stringList.size() > 0) {
//                        for (TicketInfoRes ticketInfoRes : stringList) {
//                            AssociatorRightsReceiveRecordVo associatorRightsReceiveRecordVo = new
//                                    AssociatorRightsReceiveRecordVo();
//                            associatorRightsReceiveRecordVo.setAssociatorID(associatorId);
//                            associatorRightsReceiveRecordVo.setAssociatorName("小红盒会员");
//                            associatorRightsReceiveRecordVo.setUserID(vo.getUserID());
//                            associatorRightsReceiveRecordVo.setReceiveDate(now);
//                            associatorRightsReceiveRecordVo.setReceiveType(1);
//                            associatorRightsReceiveRecordVo.setCouponID(ticketInfoRes.getTktCode());
//                            associatorRightsReceiveRecordVo.setAddTime(now);
//                            associatorRightsReceiveRecordVo.setModifyTime(now);
//                            associatorRightsReceiveRecordVo.setIsDelete(0);
//                            associatorRightsReceiveRecordRpc.add(associatorRightsReceiveRecordVo);
//                        }
//
//                        //插入mongo,用于发送短信
//                        AssociatorMessageBo associatorMessageBo = new AssociatorMessageBo();
//                        associatorMessageBo.setKeyId(UUID.randomUUID().toString().replace("-", ""));
//                        associatorMessageBo.setUserId(userId);
//                        associatorMessageBo.setOpenId(vo.getOutUserID());
//                        associatorMessageBo.setPhone(userPhone);
//                        associatorMessageBo.setType(1);
//                        associatorMessageBo.setSendFlag(0);
//                        associatorMessageBo.setAddTime(now);
//                        mongodbDao.saveAssociatorMessage(associatorMessageBo);
//                    }
//                }
//            }
        } else {
            System.out.println("周" + week + "不发送优惠券");
        }
    }
}
