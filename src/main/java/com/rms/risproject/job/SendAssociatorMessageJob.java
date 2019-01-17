package com.rms.risproject.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * @Description： 每周一十点发送赠送心选优惠券的提示信息 如果有用户有FORMID则发送微信消息通知，没有则发送短信
 * @Author:yangxiao
 * @Date: Create in 2019/1/9 17:10
 * @Modified By:
 */
public class SendAssociatorMessageJob implements SimpleJob {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    private MongodbDao mongodbDao;
//    @Autowired
//    private WeChatRedisService weChatRedisService;
//    @Autowired
//    private AssociatorMsgSendService associatorMsgSendService;
//    @Autowired
//    private TicketApi ticketApi;
//    @Autowired
//    private AssociatorPeriodRpc associatorPeriodRpc;
//    @Autowired
//    private AssociatorUserRpc associatorUserRpc;

    @Override
    public void execute(ShardingContext shardingContext) {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(calendar.DAY_OF_WEEK) - 1;
        if (week == 0) {
            week = 7;
        }
        if (week == 1) {
            System.out.println("周一发送商城礼券通知");
//            List<AssociatorMessageBo> list = mongodbDao.getAssociatorMessage();
//            if (list != null && list.size() > 0) {
//                List<String> phoneList = new ArrayList<>();
//                for (AssociatorMessageBo bo : list) {
//                    String userId = bo.getUserId();
//                    String userPhone = bo.getPhone();
//                    String openId = bo.getOpenId();
//                    String miniappFormId = weChatRedisService.getFormID(userId);
//                    if (StringUtils.isNotBlank(miniappFormId)) {
//                        //发送微信通知消息
//                        sendXinxuanCouponMsg(userId, openId, miniappFormId);
//                        //更新发送标志
//                    } else {
//                        phoneList.add(userPhone);
//                    }
//                    mongodbDao.updateAssociatorMessage(bo.getKeyId());
//                }
//
//                if (phoneList != null && phoneList.size() > 0) {
//                    //发送短息
//                    try {
//                        associatorMsgSendService.sendXinxuanCouponMsg(phoneList);
//                    } catch (BusinessException e) {
//                        logger.error("赠送心选商城礼券短信通知失败》》》" + e.getMessage());
//                    }
//                }
//            }
        } else {
            System.out.println("周" + week + "不发送商城礼券通知");
        }

//        //向会员发送分期活动开始时间是当天的消息通知或短信，用户有formid则发送微信消息通知，没有则发送短信通知。
//        Integer associatorId = 1;
//        AssociatorPeriodVo associatorPeriodVo = new AssociatorPeriodVo();
//        associatorPeriodVo.setAssociatorID(associatorId);
//        associatorPeriodVo = associatorPeriodRpc.getValidPeriod(associatorPeriodVo);
//        if (associatorPeriodVo != null) {
//            Date startDate = associatorPeriodVo.getAssociatorPeriodStartDate();
//            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//            //如果活动的开始时间是当天，则发送消息。
//            if (fmt.format(new Date()).toString().equals(fmt.format(startDate).toString())) {
//                List<String> phoneList = new ArrayList<>();
//                //获取有效会员
//                AssociatorUserVo associatorUserVo = new AssociatorUserVo();
//                associatorUserVo.setAssociatorID(associatorId);
//                List<AssociatorUserVo> userVoList = associatorUserRpc.getValidAssociatorUser(associatorUserVo);
//                if (userVoList != null && userVoList.size() > 0) {
//                    String periodName = associatorPeriodVo.getAssociatorPeriodName();
//                    for (AssociatorUserVo vo : userVoList) {
//                        String userId = vo.getUserID();
//                        String userPhone = vo.getUserPhone();
//                        String openId = vo.getOutUserID();
//                        String miniappFormId = weChatRedisService.getFormID(userId);
//                        if (StringUtils.isNotBlank(miniappFormId)) {
//                            SendWxTemplateMgsReq sendWxTemplateMgsReq = new SendWxTemplateMgsReq();
//                            sendWxTemplateMgsReq.setFormId(miniappFormId);
//                            sendWxTemplateMgsReq.setOpenId(openId);
//                            sendWxTemplateMgsReq.setKeyValueTwo(periodName);
//                            sendWxTemplateMgsReq.setKeyValueThree(fmt.format(associatorPeriodVo
//                                    .getAssociatorPeriodStartDate()));
//
//                            try {
//                                associatorMsgSendService.sendPreiodTemplateMsg(sendWxTemplateMgsReq);
//                            } catch (Exception e) {
//                                logger.error("小红盒会员分期活动开启微信通知消息失败》》》" + e.getMessage());
//                            }
//                        } else {
//                            phoneList.add(userPhone);
//                        }
//                    }
//                    if (phoneList != null && phoneList.size() > 0) {
//                        String[] param = {periodName};
//                        try {
//                            associatorMsgSendService.sendPreiodSignMsg(phoneList, param);
//                        } catch (BusinessException e) {
//                            logger.error("小红盒会员分期活动开启短信通知失败失败》》》" + e.getMessage());
//                        }
//                    }
//                }
//            } else {
//                System.out.println("分期活动开始时间不是今天");
//            }
//        } else {
//            System.out.println("未开启分期活动");
//        }
    }

//    private void sendXinxuanCouponMsg(String userId, String openId, String miniappFormId) {
//        SendWxTemplateMgsReq sendWxTemplateMgsReq = new SendWxTemplateMgsReq();
//        sendWxTemplateMgsReq.setKeyValueTwo("成都企鹅门诊部小程序商城礼券");
//        List<UserValidTicket> validTickets = ticketApi.getValidTicket(Long.parseLong(userId));
//        if (validTickets != null && validTickets.size() > 0) {
//            //根据到期时间排倒叙
//            Collections.sort(validTickets, new Comparator<UserValidTicket>() {
//
//                @Override
//                public int compare(UserValidTicket o1, UserValidTicket o2) {
//                    return o1.getGmtValidExpire().compareTo(o2.getGmtValidExpire());
//                }
//
//            });
//            if (validTickets.size() == 1) {
//                sendWxTemplateMgsReq.setKeyValueTwo(validTickets.get(0).getTktName());
//            } else {
//                sendWxTemplateMgsReq.setKeyValueTwo(validTickets.get(0).getTktName() + "等" + validTickets.size()
//                        + "张优惠券");
//            }
//        }
//        //发送微信消息通知
//        sendWxTemplateMgsReq.setFormId(miniappFormId);
//        sendWxTemplateMgsReq.setOpenId(openId);
//        sendWxTemplateMgsReq.setKeyValueThree(DateUtil.format(validTickets.get(0).getGmtValidExpire()));
//        try {
//            associatorMsgSendService.sendXinxuanTemplateMsg(sendWxTemplateMgsReq);
//        } catch (Exception e) {
//            logger.error("赠送心选商城礼券微信通知消息失败》》》" + e.getMessage());
//        }
//    }
}
