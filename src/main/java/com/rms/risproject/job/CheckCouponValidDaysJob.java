package com.rms.risproject.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Description：
 * @Author:yangxiao 检测有效日期还有7天的优惠券，记录用户电话。
 * @Date: Create in 2018/11/8 17:14
 * @Modified By:
 */
public class CheckCouponValidDaysJob implements SimpleJob {
//    @Autowired
//    private CouponServiceRpc couponServiceRpc;
//    @Autowired
//    private UserInfoRpc userInfoRpc;
//    @Autowired
//    private MongodbDao mongodbDao;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("获取信息开始=============");
//        CouponParamVO couponParamVO = new CouponParamVO();
//        couponParamVO.setPlatform(1);
//        couponParamVO.setStatus(1);
//        couponParamVO.setValidDays(7);
//        couponParamVO.setPageNum(1);
//        couponParamVO.setPageSize(100);
//        PageResult<CouponVO> pageResult = couponServiceRpc.getCouponList(couponParamVO);
//        if (pageResult != null && pageResult.getTotalCount() > 0) {
//            List<CouponVO> voList = pageResult.getList();
//            UserInfoVo userInfoVo = new UserInfoVo();
//            Map<String, CouponValidDasyMsgBo> map = new HashMap<>();//使用Map去重，相同的手机号只发送一次短信
//            for (CouponVO vo : voList) {
//                CouponValidDasyMsgBo bo = new CouponValidDasyMsgBo();
//                userInfoVo.setUserID(vo.getUserId());
//                String phone = userInfoRpc.getOne(userInfoVo).getPhone();
//                bo.setPhone(phone);
//                bo.setAddTime(new Date());
//                bo.setCouponEndTime(vo.getCouponEndTime());
//                bo.setCouponName(vo.getName());
//                bo.setIsSend(0);
//                bo.setValidDays(7);
//                map.put(phone, bo);
//            }
//            long pages = pageResult.getTotalPage();
//            if (pages > 1) {
//                for (int i = 2; i <= pages; i++) {
//                    couponParamVO.setPageNum(i);
//                    pageResult = couponServiceRpc.getCouponList(couponParamVO);
//                    voList = pageResult.getList();
//                    for (CouponVO vo : voList) {
//                        CouponValidDasyMsgBo bo = new CouponValidDasyMsgBo();
//                        userInfoVo.setUserID(vo.getUserId());
//                        String phone = userInfoRpc.getOne(userInfoVo).getPhone();
//                        bo.setPhone(phone);
//                        bo.setAddTime(new Date());
//                        bo.setCouponEndTime(vo.getCouponEndTime());
//                        bo.setCouponName(vo.getName());
//                        bo.setIsSend(0);
//                        bo.setValidDays(7);
//                        map.put(phone, bo);
//                    }
//                }
//            }
//            for (CouponValidDasyMsgBo bo : map.values()) {
//                //将需要发送短信的用户信息保存至mongo
//                mongodbDao.saveCouponValidDaysMsg(bo);
//            }
//        }
        System.out.println("获取信息结束=============");
    }
}
