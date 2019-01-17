package com.rms.risproject.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H5SecretElasticJob implements SimpleJob {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Autowired
    //private SystemSettingRpc systemSettingRpc;

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.debug(String.format("------Thread ID: %s, 任务总片数: %s, 当前分片项: %s",
                Thread.currentThread().getId(), shardingContext.getShardingTotalCount(), shardingContext.getShardingItem()));
        System.out.println(String.format("------Thread ID: %s, 任务总片数: %s, 当前分片项: %s",
                Thread.currentThread().getId(), shardingContext.getShardingTotalCount(), shardingContext.getShardingItem()));
//        //定时更新H5密钥
//        SystemSettingVo settingVo=new SystemSettingVo();
//        settingVo.setParamGroup("H5Secret");
//        List<SystemSettingVo> systemSettingVos=systemSettingRpc.listByOrderModifyTime(settingVo);
//        SystemSettingVo vo = systemSettingVos.get(0);
//        vo.setParamValue(UUID.randomUUID().toString().replaceAll("-",""));
//        systemSettingRpc.updateByID(vo);
    }
}